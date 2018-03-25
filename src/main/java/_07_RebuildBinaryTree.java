import domain.BinaryTreeNode;
import utils.SOPrintUtil;

/**
 * 一句话 复杂问题简单化还有找规律
 *
 *
 * 面试题7：重建二叉树
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
 * 入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，
 * 则重建出 图2.6所示的二叉树并输出它的头结点。
 * 图2.6 普通二叉树
 * //              1
 * //           /     \
 * //          2       3
 * //         /       / \
 * //        4       5   6
 * //         \         /
 * //          7       8
 *
 */
public class _07_RebuildBinaryTree {
    public static void main(String[] args){
        //先序遍历的数组
        int[] preOrder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        //中序遍历的数组
        int[] inOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

        BinaryTreeNode rootNode = rebuildBinaryTree(preOrder,inOrder);
        preForBinaryTree(rootNode);

    }



    public static BinaryTreeNode rebuildBinaryTree(int[] preOrder,int[] inOrder){
        return rebuildBinaryTree(preOrder,inOrder,0,preOrder.length-1,0,inOrder.length-1);
    }

    public static void preForBinaryTree(BinaryTreeNode rootNode){
        if (rootNode!=null)
            {SOPrintUtil.println(rootNode.value);
                preForBinaryTree(rootNode.left);
                preForBinaryTree(rootNode.right);
        }
    }



    public static BinaryTreeNode rebuildBinaryTree(int[] preOrder,int[] inOrder,int preStartPos,int preEndPos,int inStartPos,int inEndPos){
        if(preEndPos==preStartPos ){
//            if( preOrder[preStartPos]==inOrder[inStartPos]){
            if( inStartPos==inEndPos && preOrder[preStartPos]==inOrder[inStartPos]){
                return new BinaryTreeNode(preOrder[preStartPos]);
            }else {
    //            throw new Exception("canshu iyi chang");
                SOPrintUtil.println("参数异常");
            }
        }


        //首先找到根节点
        BinaryTreeNode rootNode = new BinaryTreeNode(preOrder[preStartPos]);

        //遍历二叉树中序结果 找到位置值分开左右两部分
        int leftLength = 0;
        for(int tmpInStartPos = inStartPos;tmpInStartPos<=inEndPos;tmpInStartPos++){
            if ((Integer)rootNode.value == inOrder[tmpInStartPos]){
                break;
            }
            leftLength++;
        }


        //进行角标范围确定
        int leftPreStartPos = preStartPos + 1;
        int leftPreEndPos = preStartPos + leftLength;
        int leftInStartPos = inStartPos;
        int leftInEndPos = inStartPos + leftLength -1;

        if (leftLength > 0) { //少加了4行的限制条件为什么？
            //左节点树
            BinaryTreeNode leftNode = rebuildBinaryTree(preOrder, inOrder, leftPreStartPos, leftPreEndPos, leftInStartPos, leftInEndPos);
            rootNode.left = leftNode;

        }

        int rightPreStartPos = leftPreEndPos+1;
        int rightPreEndPos = preEndPos;
        int rightInStartPos = inEndPos - leftLength;
        int rightInEndPos = inEndPos;


        if (leftLength < preEndPos - preStartPos) {  //少加了4行的限制条件为什么？
            BinaryTreeNode rightNode = rebuildBinaryTree(preOrder, inOrder, rightPreStartPos, rightPreEndPos, rightInStartPos, rightInEndPos);

            rootNode.right = rightNode;
        }
        return rootNode;
    }

}
