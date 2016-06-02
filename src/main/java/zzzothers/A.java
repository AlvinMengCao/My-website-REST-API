package zzzothers;

/**
 * Created by alvin on 6/2/16.
 */
public class A {
    public static B b;
    static {
        b = new B();
        System.out.println("我在静态代码块里面啦");
    }
}
