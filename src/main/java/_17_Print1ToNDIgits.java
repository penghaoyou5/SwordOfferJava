import utils.SOPrintUtil;

/**
 * 输入数字n，按顺序打印出从1到最大值得n位十进制数
 *
 * 这种看似简单的题最害怕跳进陷阱
 *
 * 这里我也不知道有啥坑呢？  这里全排列呗  不过递归实现的这种思路还是挺好的
 *
 * 字符数组全排列   要记住每一道题呀  java里面还是用 byte数组吧 占的空间还小
 *
 * 完全for循环也可以  这样可以
 */
public class _17_Print1ToNDIgits {

    public static void main(String[] args){
            Print1ToMaxOfNDIgits(20);
    }


    public static void Print1ToMaxOfNDIgits(int n){
        if (n<=0)return;

        byte[] number = new byte[n];

        for (byte i=0;i<10;i++){
            number[0] = i;
            Print1ToMaxOfNDIgitsRecursively(number,n,1);
        }
    }


    public static void Print1ToMaxOfNDIgitsRecursively(byte[] number,int length,int index){
        if(index==length ){
            //打印
            PrintNumber(number);
//            SOPrintUtil.println("退出");
            return;
//            SOPrintUtil.println("tuohule ");
        }



        for (byte i=0;i<10;i++){
            number[index] = i;
//            Print1ToMaxOfNDIgitsRecursively(number,length,++index);//这个直接导致了 数组角标越界异常  传递给下一个方法之后返回来还对本个方法起作用？？？
            Print1ToMaxOfNDIgitsRecursively(number,length,index+1);
        }

    }

    public static void PrintNumber(byte[] number){
        boolean isBigingingO = true; //现在是以0开始吗？  默认是true
        for (int i = 0;i< number.length;i++){
            if(isBigingingO && number[i] != 0){
                isBigingingO = false;
            }

            if(!isBigingingO){
                System.out.print(number[i]);

            }
        }
        if (!isBigingingO)
            System.out.println();
    }
}
