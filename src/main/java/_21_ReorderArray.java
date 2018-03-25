import utils.SOPrintUtil;

/**
 * 面试题21：调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 遍历数组一个找符合前面条件的数字 一个找符合后面条件的
 */
public class _21_ReorderArray {

    public static void main(String[] args){
        int[] data = new int[]{1,2,3,4,5};
        Reorder(data);
        SOPrintUtil.println(data);
    }

    public static void Reorder(int[] data){

        if(data==null||data.length==1){
            return;
        }

        int preIndex = 0;
        int behindIndex = data.length-1;
        while (preIndex<behindIndex){

            //前面找事是偶数的  但是基数的时候指针后移
            while (preIndex< behindIndex && isEvent(data[preIndex])){
                preIndex++;
            }

            //后面找的是奇数 当时偶数的时候指针前移
            while (preIndex<behindIndex && !isEvent(data[behindIndex]) ){
                behindIndex--;
            }

            if (preIndex<behindIndex){
                int tmpNum= data[preIndex];
                data[preIndex] = data[behindIndex];
                data[behindIndex] = tmpNum;
            }

        }
    }

    //最后要让前面的事件符合条件 这是考虑廓镇
    private static boolean isEvent(int item){
        return (item&1) == 1;
    }
}
