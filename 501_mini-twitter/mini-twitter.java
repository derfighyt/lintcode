/**
 * Definition of Tweet:
 * public class Tweet {
 *     public int id;
 *     public int user_id;
 *     public String text;
 *     public static Tweet create(int user_id, String tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
 */
public class MiniTwitter {
    //需要维护几种关系
    //1. 每个用户发布，会有自己的时间线，暂时考虑用list
    //2. 每个用户可能关注别人，需要维护一个关注关系，可以用map
    //3. 每个用户的朋友圈时间线。
    //4. 1和3可以合并，在取数据时做过滤，时间开销会增加
    //5. 为了节省空间，可以把所有发布集中在一起，每个用户的时间线里只存id
    Map<Integer, List<Integer>> timelineMap; //保存每个人的时间线
    Map<Integer, List<Integer>> newsFeedMap; //保存朋友圈
    Map<Integer, Set<Integer>> followMap; //保存你的follower
    Map<Integer, Tweet> tweetMap; //保存所有推

    public MiniTwitter() {
        // initialize your data structure here.
        timelineMap = new HashMap();
        newsFeedMap = new HashMap();
        followMap = new HashMap();
        tweetMap = new HashMap();
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here
        // 发推时，首先要生成一条推，到推特表，
        Tweet tweet = Tweet.create(user_id, tweet_text);
        tweetMap.put(tweet.id, tweet);
        //然后把id插入到自己的时间线，
        if (!timelineMap.containsKey(user_id)) {
            timelineMap.put(user_id, new LinkedList());
        }
        timelineMap.get(user_id).add(0, tweet.id);
        //最后插入到自己的follower的时间线
        if (!followMap.containsKey(user_id)) {
            followMap.put(user_id, new HashSet());
            followMap.get(user_id).add(user_id);
        }
        for (int friend_id : followMap.get(user_id)) {
            if (!newsFeedMap.containsKey(user_id)) {
                newsFeedMap.put(user_id, new LinkedList());
            }
            newsFeedMap.get(user_id).add(0, tweet.id);
        }
        return tweet;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        //先获取用户的朋友圈，取前10个id，再填充数据
        List<Tweet> result = new ArrayList();
        List<Integer> newsFeedList = newsFeedMap.get(user_id);
        if (newsFeedList == null || newsFeedList.size() == 0) {
            return result;
        }
        int endIndex = Math.min(10, newsFeedList.size());
        for (int tweet_id : newsFeedList.subList(0, endIndex)) {
            result.add(tweetMap.get(tweet_id));
        }
        return result;
    }

    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here
        //先获取用户的时间线，取前10个id，再填充数据
        List<Tweet> result = new ArrayList();
        List<Integer> timelineList = timelineMap.get(user_id);
        if (timelineList == null || timelineList.size() == 0) {
            return result;
        }
        int endIndex = Math.min(10, timelineList.size());
        for (int tweet_id : timelineList.subList(0, endIndex)) {
            result.add(tweetMap.get(tweet_id));
        }
        return result;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        //加到用户的follower表
        if (!followMap.containsKey(to_user_id)) {
            followMap.put(to_user_id, new HashSet());
            followMap.get(to_user_id).add(to_user_id);
        }
        followMap.get(to_user_id).add(from_user_id);
        //加完后还要刷新自己的朋友圈
        if (!newsFeedMap.containsKey(from_user_id)) {
            newsFeedMap.put(from_user_id, new LinkedList());
        }
        List<Integer> timelineList = timelineMap.get(to_user_id);
        List<Integer> newsFeedList = newsFeedMap.get(from_user_id);
        merge(newsFeedList, timelineList);
    }

    private void merge(List<Integer> newsFeedList, List<Integer> timelineList) {
        if (newsFeedList == null || timelineList == null) {
            return;
        }
        int i = 0, j = 0;
        while (j < timelineList.size()) {
            int id = timelineList.get(j);
            while (i < newsFeedList.size() && newsFeedList.get(i) > id) {
                i++;
            }
            newsFeedList.add(i, id);
            j++;
        }
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if (followMap.containsKey(to_user_id)) {
            followMap.get(to_user_id).remove(from_user_id);
        }
        //需要删掉朋友圈
        List<Integer> newsFeedList = newsFeedMap.get(from_user_id);
        if (newsFeedList != null) {
            List<Integer> removeList = new LinkedList();
            for (int id : newsFeedList) {
                Tweet tweet = tweetMap.get(id);
                if (tweet.user_id == to_user_id) {
                    removeList.add(id);
                }
            }
            newsFeedList.removeAll(removeList);
        }
    }
}

// 实现一个迷你的推特，支持下列几种方法
// 1.postTweet(user_id, tweet_text). 发布一条推特.
// 2.getTimeline(user_id). 获得给定用户最新发布的十条推特，按照发布时间从最近的到之前排序
// 3.getNewsFeed(user_id). 获得给定用户的朋友或者他自己发布的最新十条推特，从发布时间最近到之前排序
// 4.follow(from_user_id, to_user_id). from_user_id 关注 to_user_id.
// 5.unfollow(from_user_id, to_user_id). from_user_id 取消关注 to_user_id.
//
// 样例
// postTweet(1, "LintCode is Good!!!")
// >> 1
// getNewsFeed(1)
// >> [1]
// getTimeline(1)
// >> [1]
// follow(2, 1)
// getNewsFeed(2)
// >> [1]
// unfollow(2, 1)
// getNewsFeed(2)
// >> []
