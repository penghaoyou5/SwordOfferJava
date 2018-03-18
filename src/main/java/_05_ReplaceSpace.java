import utils.SOPrintUtil;

/**
 * 面试题5：替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
 * 则输出“We%20are%20happy.”。
 *
 * 虽然Java中有自带的 replaceAll 方法，但是这里还是要自定义的
 *
 *
 * 合并替换之类的 数组从后往前 减少次数 一次到位
 */
public class _05_ReplaceSpace {
    public static void main(String[] args){



        String str = "We are happy";
        String result = replaceSpace(str);
        SOPrintUtil.println(result);


        //这里说明了 ++ 是传入方法然后再自加
        /**
         *   ++a：如果++在前就会先把a+1。
         a++：如果++在后就会先a然后在执行++的操作。
         */
        int num = 9;
        SOPrintUtil.println(testAdd(num++));
        SOPrintUtil.println(num);
    }

    public static int testAdd(int num){
        SOPrintUtil.println(num);
        return num;
    }


    public static String replaceSpace(String str){
        if(str==null || str.length()==0){
            return str;
        }

        char[] chars = str.toCharArray();
        int spaceCount = 0;
        for (char charItem:chars) {
            if (charItem == ' '){
                spaceCount++;
            }
        }

        if(spaceCount==0){return str;}

        //核心代码   获得新字符长度 然后循环替换即可    看其他代码用的是while循环
        char[] newChars = new char[chars.length + spaceCount*2];
        int newPos = 0;
        for (char charItem:chars) {
            if (charItem == ' '){
                newChars[newPos++] = '%';
                newChars[newPos++] = '2';
                newChars[newPos++] = '0';
            }else {
                newChars[newPos++] = charItem;
            }
        }
        return new String(newChars);
    }

}
