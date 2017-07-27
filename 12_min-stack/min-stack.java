public class MinStack {
    List <Integer> list;
    int top = -1;
    Stack<Integer> minStack;

    public MinStack() {
        // do initialize if necessary
        list = new LinkedList();
        minStack = new Stack();
    }

    public void push(int number) {
        // write your code here
        list.add(number);
        top++;
        if (minStack.isEmpty() || number <= minStack.peek()) {
            minStack.push(number);
        }
    }

    public int pop() {
        // write your code here
        if (top < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (list.get(top).equals(minStack.peek())) {
            minStack.pop();
        }
        return list.remove(top--);
    }

    public int min() {
        // write your code here
        if (top < 0) {
            throw new IndexOutOfBoundsException();
        }
        return minStack.peek();
    }
}
// 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
//
// 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。
//
//  注意事项
//
// 如果堆栈中没有数字则不能进行min方法的调用
//
// 样例
// 如下操作：push(1)，pop()，push(2)，push(3)，min()， push(1)，min() 返回 1，2，1
