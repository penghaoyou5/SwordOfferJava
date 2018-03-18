package _03_FindRepetition;

import utils.SOPrintUtil;

/**
 * 马上理解不了这种写法的完全思路 先背过去吧
 *
 *
 * 面试题3（一）：找出数组中重复的数字
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，那么对应的输出是重复的数字2或者3。
 */
public class _1FindRepetionInArray {


    public static void main(String[] args){
        int[] data = new int[]{2, 3, 1, 0, 2, 5, 3};
        int result = new _1FindRepetionInArray().findRepetition(data);
        System.out.println(result);
    }

    /**
     * 既然给了 数字范围和数组范围的关系以及数字的不重复性，那么就以此为思路写
     *
     * 如果刚好没有重复的  那么数组的每个数字都会在自己的位置上，所以有了思路利用这个信息，从前到后把各个数字放在自己应该放的位置
     *
     * 同时要考虑到各种情况
     * @param datas
     * @return
     */
    public int findRepetition(int[] datas){
        //判断 数组是否符合要求 是否为空
        if(datas==null || datas.length == 0){
            return -1;
        }

        //判断 数组是否符合题干要求
        for (int num:datas) {
            if(num<0 || num > datas.length-1){
                return -1;
            }
        }

        //核心代码
        for (int i=0;i<datas.length;i++){
            while (datas[i]!=i){
                int temp = datas[i];
                if (temp==datas[temp]){
                    SOPrintUtil.println(datas);
                    return temp;
                }
                datas[i] = datas[temp];
                datas[temp] = temp;
            }
        }
        return -1;
    }

}
