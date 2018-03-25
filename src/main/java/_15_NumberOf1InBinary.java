import utils.SOPrintUtil;

/**
 * 面试题15：二进制中1的个数
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * 例如把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 */
public class _15_NumberOf1InBinary {

    public static void main(String[] args){
        SOPrintUtil.println(numberOf1InBinaray(9));
    }

    public static int numberOf1InBinaray(int number){
        int count = 0;
        while (number!=0){
            number = number & (number-1);
            count++;
        }
        return count;
    }
}
