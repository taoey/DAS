public class SingletonLazy {
    private SingletonLazy() {}  //私有构造函数
    private static SingletonLazy instance = null;  //单例对象
    //静态工厂方法
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
