import utils.SOPrintUtil;

import java.util.Stack;

public class _09_QueueWithTwoStacks<T> {

    public static void main(String[] args){
        _09_QueueWithTwoStacks<Integer> queueWithTwoStacks = new _09_QueueWithTwoStacks<Integer>();

        queueWithTwoStacks.appendTail(1).appendTail(2).appendTail(3).appendTail(4);

        SOPrintUtil.println(queueWithTwoStacks.deleteHead());
        SOPrintUtil.println(queueWithTwoStacks.deleteHead());

        queueWithTwoStacks.appendTail(6).appendTail(7);

        SOPrintUtil.println(queueWithTwoStacks.deleteHead());
        SOPrintUtil.println(queueWithTwoStacks.deleteHead());
    }

    public Stack<T> stack1 = new Stack<T>();
    public Stack<T> stack2 = new Stack<T>();

    public   _09_QueueWithTwoStacks appendTail(T t){
        while (stack2.size()>0){
            stack1.push(stack2.pop());
        }
        stack1.push(t);
        return this;
    }



    public  T deleteHead(){
        while (stack1.size()>0){
            stack2.push(stack1.pop());
        }

        if(stack2.size()>0){
            return stack2.pop();
        }else {
            return null;
        }

    }

}
