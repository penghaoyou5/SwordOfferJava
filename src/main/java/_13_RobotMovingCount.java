import utils.SOPrintUtil;

/**
 * * 题目描述：机器人的运动范围
 *              地上有一个m行n列的方格。一个机器人从坐标（0,0）的格子开始移动，它每次可以向左，向右，向上，向下移动一格，
 *           但不能进入行坐标和列坐标的位数之和大于k的格子。例如：当k为18时，机器人能够进入方格（35,37），
 *           因为3+5+3+7 = 18；但它不能进入方格（35,38），因为3 + 5+3+8 = 19.请问该机器人最多能到达多少个格子？
 * 输入描述：请输入限制条件k:
 *           5
 *           请输入方格的行数m：
 *           10
 *           请输入方格的列数n:
 *           10
 * 程序输出： 矩阵能到达的方格数是：
 *           21
 * 问题分析：
 * 算法描述： 这个方格也可以看出一个m*n的矩阵。同样在这个矩阵中，除边界上的格子之外其他格子都有四个相邻的格子。
 *       　　机器人从坐标(0,0)开始移动。当它准备进入坐标为(i,j)的格子时，通过检查坐标的数位和来判断机器人是否能够进入。
 *           如果机器人能够进入坐标为(i,j)的格子，我们接着再判断它能否进入四个相邻的格子(i,j-1)、(i-1,j),(i,j+1)和(i+1,j)
 */
public class _13_RobotMovingCount {
    public static void main(String[] args){

        int count = movingCount(5, 10, 10);
        SOPrintUtil.println(count);
    }

    public static int movingCount(int threshold,int rows,int cols){
        if(threshold<0 || rows <= 0 || cols <= 0){
            return 0;
        }

        boolean[][] visited = new boolean[rows][cols];

        int count = movingCountCore(threshold,rows ,cols ,0,0,visited);
        return count;
    }

    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;

        if (row >=0 && col>=0 && row < rows && col<cols && !visited[row][col] && gitDigitSum(row)+ gitDigitSum(col)<=threshold){
            visited[row][col] = true;
            SOPrintUtil.println(row,col);

            count = 1+ movingCountCore(threshold, rows, cols, row+1, col, visited)+
                    movingCountCore(threshold, rows, cols, row, col-1, visited)+
                    movingCountCore(threshold, rows, cols, row-1, col, visited)+
                    movingCountCore(threshold, rows, cols, row, col+1, visited);

        }


        return count;
    }


    private static int gitDigitSum(int number){
        int sum = 0;
        while (number>0){
            sum += number%10;
            number/=10;
        }
        return sum;
    }


}
