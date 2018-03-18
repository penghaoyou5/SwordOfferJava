package _04_FindInSortedMatrix;


import utils.SOPrintUtil;

/**
 * 面试题4：二维数组中的查找
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
 * 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
 * 整数，判断数组中是否含有该整数。
 */
public class FindInSortedMatrix {
    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        int findNum = 5;
        findInSortedMatrix(matrix,findNum);

        SOPrintUtil.println("==========================");
        findInSortedMatrix(matrix,7);

    }


    public static boolean findInSortedMatrix(int[][] matrix,int findNum){
        boolean found = false;
        if (matrix == null || matrix.length==0 || matrix[0].length == 0){
            return found;
        }

        int rows = matrix[0].length;
        int column = matrix.length - 1;
        int row = 0;

        while (row<=rows && column >=0){
            if(matrix[column][row] == findNum){
                found = true;
                SOPrintUtil.println(row);
                SOPrintUtil.println(column);
                break;
            }

            if (matrix[column][row] > findNum){
                column--;
            }else {
                row++;
            }

        }


        return found;
    }
}
