package _03_FindRepetition;

import utils.SOPrintUtil;

/**
 * 要记住每种算法，并且反复斟酌算法思路
 *
 * 面试题3（二）：不修改数组找出重复的数字
 * 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
 * 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
 * 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
 * 输出是重复的数字2或者3
 *
 * 1.找一个长度为n的辅助数组，像第一种的解决办法，时间复杂度O（n）  空间复杂度 O(n)   空间复杂度试计算所需辅助空间的大小
 *
 * 2.空间复杂度O(1) 情况下要求的算法
 */
public class _2FindRepetitionlnArray {

    public static void main(String[] args){
        int[] data = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        int result = findRepetitionSpace1(data);
        SOPrintUtil.println(result);
    }

    /**
     * 求空间复杂度是1的情况下找
     * @param datas
     * @return
     */
    public static int findRepetitionSpace1(int[] datas){
        //排除意外情况
        if(datas==null || datas.length==0){
            return  -1;
        }

        //开始遍历进行二分法查找
        int start=1,end = datas.length-1;
        while (end>=start){
            int middle = (start+end)>>1;
            int countRange = 0;
            for (int dataItem: datas) {
                if (dataItem>=start && dataItem<=middle){
                    countRange++;
                }
            }

            SOPrintUtil.println(datas);
            SOPrintUtil.println(start + "  " + end);

            if(start==end && countRange>1){
                return start;
            }

            if (countRange> middle -start +1){
                end = middle;
            }else {
                start = middle;
            }

        }

        return -1;
    }

}
