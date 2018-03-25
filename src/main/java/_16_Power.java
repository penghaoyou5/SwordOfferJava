import utils.SOPrintUtil;

/**
 * 面试题16：数值的整数次方
 * 题目：实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * 这里尤其要注意可能出现导致崩溃的异常问题
 *
 * 尤其是对这种题要全面高效的考虑
 *
 * 这里有考虑问题的周全度等多种能力
 */
public class _16_Power {


    public static boolean InvalidInput  = false;

    public static void main(String[] args){
        SOPrintUtil.println(Power(2, -3));
        SOPrintUtil.println(Power(0,0 ));//这个边界值要和面试官说清楚
//        SOPrintUtil.println(Power(, ));
    }

    public static double Power(double base,int exponent){
        //判断非法输入
        if (0.0 == base && exponent < 0){
            InvalidInput = true;
            return 0.0;
        }
        int abxExponent  = Math.abs(exponent);
        double result = PowerWithUnsignedExponent(base, abxExponent);
        if(exponent<0){
            result = 1.0/result;
        }
        return result;
    }




    public static double PowerWithUnsignedExponent(double base,int exponent){
        if(exponent==0){
            return 1;
        }
        if (base==1){
            return base;
        }

        double result = PowerWithUnsignedExponent(base, exponent>>1);
        result *= result;
        if((exponent & 1) == 1){
            result *= base;
        }

        return result;

    }

}
