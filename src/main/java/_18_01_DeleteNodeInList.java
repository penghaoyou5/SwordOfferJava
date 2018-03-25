import domain.LinkSingleNode;
import utils.SOPrintUtil;

/**
 * 面试题18（一）：在O(1)时间删除链表结点
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 *
 * 这里当然是用了替代的思路 拷贝下一个节点的内容到本节点  这种思路是要得的
 *
 *
 * 其实我也可以先做那个工作半年后跳槽的
 */
public class _18_01_DeleteNodeInList {

    public static void main(String[] args){
        LinkSingleNode nodeHead = new LinkSingleNode(1);
        LinkSingleNode nodeEnd = nodeHead.addNodeToEnd(2).addNodeToEnd(3).addNodeToEnd(4).addNodeToEnd(5);


        deleteNode(nodeHead, nodeEnd);

        while (nodeHead!=null){
            SOPrintUtil.println(nodeHead.value);
            nodeHead = nodeHead.next;
        }



    }



    //边界值 不合理的输入法 错误处理
    public static LinkSingleNode deleteNode(LinkSingleNode nodeHead,LinkSingleNode nodeDelete){
        if(nodeDelete== null || nodeDelete==null){
            return null;
        }

        // 链表有多个节点  要删除的节点不是尾节点
        // 直接用下一个节点的信息覆盖本节点
        if(nodeDelete.next != null){
            nodeDelete.value = nodeDelete.next.value;
            nodeDelete.next = nodeDelete.next.next;
            return nodeHead;
            //链表中只有一个节点  删除节点就是头结点
        }else if(nodeHead == nodeDelete){
            return null;
            //链表中有多个节点 删除尾节点
        }else {
            LinkSingleNode currentNode = nodeHead;
            while ( nodeDelete !=currentNode.next){
                currentNode = currentNode.next;
            }
            currentNode.next = null;

            return nodeHead;
        }

    }

}
