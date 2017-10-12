/**
 * Description : TODO
 * Created By Polar on 2017/9/8
 */
public class Singleton {
    // 饿汉式
    // 并发请求getInstance时或产生多个对象
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton != null) {
            singleton = new Singleton();
        }
        return singleton;

    }

}

class HttpIO {
    // 静态内部类 既保证懒汉式又保证线程安全
    // 在调用getInstance时才会加载静态内部类
    private HttpIO() {}

    private static class Inner {
        private static HttpIO httpIO = new HttpIO();
    }

    public static HttpIO getInstance() {
        return Inner.httpIO;
    }


}


class FileIO {

    // 饿汉式  线程安全的
    private static FileIO fileIO = new FileIO();

    private FileIO() {
    }

    public static FileIO getInstance() {
        return fileIO;
    }
}
