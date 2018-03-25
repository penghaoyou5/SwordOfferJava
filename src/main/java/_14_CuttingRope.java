import utils.SOPrintUtil;

/**
 * 面试题14：剪绳子
 * 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘积是多少？
 * 例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
 *
 *
 * 这个还是不是很清楚呀
 */
public class _14_CuttingRope {
    public static void main(String[] args){
        SOPrintUtil.println(countRope(8));
        SOPrintUtil.println(maxProductByDynamicRules(8));

        SOPrintUtil.println(maxProductByGreedAlgorithm(8));
    }

    //首先用递归的思路解决问题
    public static int countRope(int length){
        if(length==2)return 1;
        if(length==3)return 2;
        if(length==4)return 4;
        if(length==5)return 6;

        int result = 0;
        for (int tmp=1;tmp<length;tmp++){
            int tmpResult = tmp * countRope(length-tmp);
            result = result>tmpResult?result:tmpResult;
        }
        return result;
    }


    /**
     * 动态规划
     * @param length
     * @return
     */
    public static int maxProductByDynamicRules(int length){
        if(length<2){
            return 0;
        }else if(length==2){
            return 1;
        }else if(length==3){
            return 2;
        }else if(length==4){
            return 4;
        }


        int[] results = new int[length+1];
        results[0] = 0;
        results[1] = 1;
        results[2] = 2;
        results[3] = 3;
        results[4] = 4;

        for (int i=4;i<=length;i++){
            int max = 0;

            /**
             * 这里之所以要除以2是因为 过了之后左右乘又一样了。
             */
            for (int j=1;j<=i/2;++j){
                int product =results[j] * results[i-j];
                if(max<product){
                    max=product;
                }
                results[i] = max;
            }
        }

        return results[length];
    }


    /**
     * 首先要知道一个已经被证明了的结论
     * 当n>=5时
     * 2（n-2）>n  => n>4
     * 3(n-3)>n  =>  2n>9
     *
     * 并且3（n-3）> 2(n-2)  => n >1
     * @param length
     * @return
     */
    public static int maxProductByGreedAlgorithm(int length) {
            if(length<2){
                return 0;
            }else if(length==2){
                return 1;
            }else if(length==3){
                return 2;
            }else if(length==4){
                return 4;
            }

            //尽可能多的剪长度为3的绳子
            int  timesOf3 = length/3;

            int timesOf2 = (length - timesOf3*3) / 2;

            return (int) (Math.pow(3,timesOf3 ) * Math.pow(2, timesOf2));


    }
}
