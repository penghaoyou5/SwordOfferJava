package utils;

import domain.BinaryTreeNode;

public class SOPrintUtil {
    public static void println(Object obj){
        //如果是数组 直接打印数组的形式
        if (obj instanceof int[]){
            for (Object item:(int[]) obj) {
                System.out.print(item + " ");
            }
            System.out.println();
            return;
        }
        System.out.println(obj);
    }


    public static void preForBinaryTree(BinaryTreeNode rootNode){
        if (rootNode!=null)
        {SOPrintUtil.println(rootNode.value);
            preForBinaryTree(rootNode.left);
            preForBinaryTree(rootNode.right);
        }
    }

    public static void println(Object... args){
        for (Object obj:args) {
            System.out.print(obj + "  ");
        }
        System.out.println();
    }

}
