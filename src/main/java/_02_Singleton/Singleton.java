package _02_Singleton;

/**
 * 单例设计模式 按需创建
 *
 */
public class Singleton {
    private Singleton(){
        System.out.println("开始创建");
    }


    public static Singleton getInstance(){
        return Nested.singleton;
    }


    static class Nested{
        Nested(){}
        static Singleton singleton = new Singleton();
    }

}
