import utils.SOPrintUtil;


// 面试题10：斐波那契数列
// 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
public class _10_Fibonacci {

    public static void main(String[] args){
        SOPrintUtil.println(fibonacci(0));
        SOPrintUtil.println(fibonacci(1));
        SOPrintUtil.println(fibonacci(2));
        SOPrintUtil.println(fibonacci(3));
        SOPrintUtil.println(fibonacci(4));
        SOPrintUtil.println(fibonacci(5));
        SOPrintUtil.println(fibonacci(6));
        SOPrintUtil.println(fibonacci(7));
        SOPrintUtil.println(fibonacci(8));


    }


    public static int fibonacci(int n){
        if(n<2){return n;}

        int fibonOne = 0;
        int fibonTwo = 1;

        int fibon = 0;

        for (int i=2;i<=n;i++){
            fibon = fibonOne + fibonTwo;
            fibonOne = fibonTwo;
            fibonTwo = fibon;
        }

        return fibon;
    }
}
