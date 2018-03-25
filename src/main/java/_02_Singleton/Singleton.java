package _02_Singleton;

import utils.SOPrintUtil;

/**
 * 单例设计模式 按需创建
 *
 */
public class Singleton {
    private Singleton(){
        System.out.println("开始创建");
    }

    public static void testClassLoad(){
        Singleton singleton = Nested.singleton;
    }


    public static Singleton getInstance(){
        return Nested.singleton;
    }


    static class Nested{
        Nested(){
            SOPrintUtil.println(" Nested creat");
        }
        static Singleton singleton = new Singleton();
    }

}
