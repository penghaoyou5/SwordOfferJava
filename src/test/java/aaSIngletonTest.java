import _02_Singleton.Singleton;

public class aaSIngletonTest   {
    public static void main(String[] args){
        new aaSIngletonTest().testMain();
    }


    void testMain(){
        testSingleton();
    }



    public void testSingleton(){
        Singleton singleton3 = null;
        Singleton.testClassLoad();

        StringBuffer sb = new StringBuffer();
        sb.append(100);

//        Singleton singleton = Singleton.getInstance();
//        Singleton singleton2 = Singleton.getInstance();
    }

}
