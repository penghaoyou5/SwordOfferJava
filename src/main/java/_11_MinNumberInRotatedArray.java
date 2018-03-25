import utils.SOPrintUtil;

/**
 * 面试题11：旋转数组的最小数字
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
 */
public class _11_MinNumberInRotatedArray {

    public static void main(String[] args){

        int[] data = new int[]{3, 4, 5, 1, 2};
        SOPrintUtil.println(findMinNumberInRotateArray(data));


        int[] data2 = new int[]{1, 0, 1, 1, 1};
        SOPrintUtil.println(findMinNumberInRotateArray(data2));
    }

    public static int findMinNumberInRotateArray(int[] datas){

        int startIndex = 0;
        int endIndex = datas.length - 1;

        int indexMid = startIndex;
        while (datas[startIndex] >= datas[endIndex]){
            if (endIndex-startIndex==1){
                indexMid = endIndex;
                break;
            }

            indexMid = (startIndex+endIndex)/2;

            if(datas[startIndex]==datas[endIndex] && datas[startIndex] == datas[indexMid]){
                return MinInOrder(datas, startIndex, endIndex);
            }

            if(datas[indexMid]>=datas[startIndex]){
                startIndex = indexMid;
            }else if(datas[indexMid]<=datas[endIndex]){
                endIndex = indexMid;
            }
        }
        return datas[indexMid];
    }


    public static int MinInOrder(int[] datas,int startIndex,int endIndex){
        int result = datas[startIndex];
        for(startIndex=startIndex+1;startIndex<=endIndex;startIndex++){
            if(result>datas[startIndex]){
                result = datas[startIndex];
            }
        }
        return result;

    }

}
