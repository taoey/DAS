package ProxyPattern.common;


import ProxyPattern.dao.ProxyDaoHandler;
import ProxyPattern.dao.IstudentDao;
import ProxyPattern.dao.StudentDaoImpI;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理工厂接口实现类
 */
public class ProxyDaoFactoryImpI implements IProxyDaoFactory {
    IstudentDao istudentDao = new StudentDaoImpI();

    public IstudentDao getStudentDao(String uid){
        InvocationHandler handler = new ProxyDaoHandler(istudentDao,uid);
        IstudentDao proxy = (IstudentDao) Proxy.newProxyInstance
                (IstudentDao.class.getClassLoader(),new Class[]{IstudentDao.class},handler);
        return proxy;
    }
}
