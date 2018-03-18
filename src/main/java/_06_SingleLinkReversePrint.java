import domain.LinkSingleNode;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import utils.SOPrintUtil;

import java.util.Stack;


/**
 * 面试小技巧，做之前先问问面试官能不能改链表结构？
 *
 *
 * 面试题6：从尾到头打印链表
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
/**
 * 对单向链表反向打印
 *
 * 思路1用压栈实现
 * 思路2 既然能用压栈实现那么就可以用递归实现
 */
public class _06_SingleLinkReversePrint {


    public static void main(String[] args){

        LinkSingleNode startNode = new LinkSingleNode(1);
        startNode.addNodeToEnd(2).addNodeToEnd(3).addNodeToEnd(4).addNodeToEnd(5);

//        printByStack(startNode);
        printByRecurve(startNode);

    }


    /**
     * 第一种采用压栈的方法
     */
    public static void printByStack(LinkSingleNode node){
        Stack<LinkSingleNode> stack = new Stack<LinkSingleNode>();
        while (node!=null){
            stack.add(node);
            node = node.next;
        }

        while (!stack.empty()){
            SOPrintUtil.println(stack.pop().value);
        }
    }


    /**
     * 采用递归的方式
     * @param node
     */
    public static void printByRecurve(LinkSingleNode node){
        if(node.next!=null){
            printByStack(node.next);
        }
        SOPrintUtil.println(node.value);
    }
}
