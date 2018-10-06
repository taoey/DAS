package ProxyPattern;

import ProxyPattern.common.ProxyDaoFactoryImpI;
import ProxyPattern.dao.IstudentDao;
import ProxyPattern.dao.ProxyDaoHandler;
import ProxyPattern.dao.StudentDaoImpI;
import ProxyPattern.dao.StudentDaoProxyImpI;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by tao on 2018/10/5.
 */
public class Client {
    @Test
    public void oldClient(){
        IstudentDao studentDao = new StudentDaoImpI();
        studentDao.add(1);
        studentDao.del(1);
    }

    @Test
    public void newClient(){
        IstudentDao studentDao = new StudentDaoProxyImpI("tao");
        studentDao.add(1);

        IstudentDao studentDao2 = new StudentDaoProxyImpI("黄为涛");
        studentDao2.add(1);
    }

    @Test
    public void newClient2(){
        InvocationHandler handler = new ProxyDaoHandler(new StudentDaoImpI(),"tao");
        IstudentDao dao = (IstudentDao) Proxy.newProxyInstance(IstudentDao.class.getClassLoader(), new Class[]{IstudentDao.class}, handler);
        dao.add(1);

        System.out.println("---------------");
        InvocationHandler handler2 = new ProxyDaoHandler(new StudentDaoImpI(),"黄为涛");
        IstudentDao dao2 = (IstudentDao) Proxy.newProxyInstance(IstudentDao.class.getClassLoader(), new Class[]{IstudentDao.class}, handler2);
        dao2.add(1);

    }
    @Test
    public void newClient3(){
        //可以看出我们在使用时隐藏了大多数细节
        ProxyDaoFactoryImpI daoFactory = new ProxyDaoFactoryImpI();
        IstudentDao studentDao = daoFactory.getStudentDao("tao");

        if(studentDao!=null){
            studentDao.add(1);
        }

        IstudentDao studentDao2 = daoFactory.getStudentDao("黄为涛");
        if(studentDao2!=null){
            studentDao2.add(1);
        }
    }




}
