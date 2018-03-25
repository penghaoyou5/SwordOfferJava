import utils.SOPrintUtil;

import java.util.Random;

public class _11_sortPartition {

    public static void main(String[] args) throws Exception {
        int[] data = new int[]{3, 4, 5, 1, 2};
        int midIndex = sortPattition(data, 0, data.length - 1);
        SOPrintUtil.println(midIndex);

        SOPrintUtil.println(data);
    }


    /**
     * 排序算法  选一个中间把数组分为左右两部分 左边小右边大
     *
     * 这种思路好
     *
     * @param data
     * @param start
     * @param end
     * @return
     */
    public static int sortPattition(int data[],int start,int end) throws Exception {
        if(data==null || data.length == 0 || start < 0 || end <= start){
            throw  new Exception("canshuyichang");
        }
        int index = (int) (Math.random()*(end-start) + start);
        swapPosition(data, index, end);
        int small = start;

        for (index=start; index< end;index++){
            if(data[index]< data[end]){
                if(small!=index){
                    swapPosition(data,small ,index );
                }
                small++;
            }
        }

        swapPosition(data, small, end);
        return small;
    }

    public static void swapPosition(int[] data,int index1,int index2){
        if(data[index1] == data[index2]){
            return;
        }
        int tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }
}
