import domain.BinaryTreeNode;
import utils.SOPrintUtil;

/**
 * 面试题8：二叉树的下一个结点
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 **/
public class _08_NextINBinaryTree {

    public static void main(String[] args){

        BinaryTreeNode rootNode = new BinaryTreeNode('a');

        BinaryTreeNode bNode =  rootNode.addLeft('b'); //98

        BinaryTreeNode dNode =  bNode.addLeft('d');


        BinaryTreeNode eNode = bNode.addRight('e');
        BinaryTreeNode hNode = eNode.addLeft('h');
        BinaryTreeNode iNode = eNode.addRight('i');

        BinaryTreeNode cNode = rootNode.addRight('c');
        BinaryTreeNode fNode = cNode.addLeft('f');
        BinaryTreeNode gNode = cNode.addRight('g');



//        SOPrintUtil.preForBinaryTree(rootNode);


        BinaryTreeNode resultNode = findNextNode(gNode);

        if(resultNode!=null){
            SOPrintUtil.println(resultNode.value);

        }
    }


    public static BinaryTreeNode findNextNode(BinaryTreeNode node){

        /**
         * 如果有右节点 找右节点的最左节点
         */
        if(node.right!=null){
            node = node.right;
            while (node.left!=null){
//                SOPrintUtil.println(node.value);
                node = node.left;
            }
            return node;
        }


        if(node.parent!=null){
            if (node.parent.left == node){
                return node.parent;
            }else {
                while (node.parent!=null&& node.parent.parent!=null){
                    if(node.parent==node.parent.parent.left){
                        return node.parent.parent;
                    }
                    node=node.parent;
                }

            }
        }

        return null;
    }



}
