package utils;

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

}
