package ProxyPattern.common;

import ProxyPattern.dao.IstudentDao;

/**
 * dao 代理对象工厂接口
 */
public interface IProxyDaoFactory {
    public IstudentDao getStudentDao(String uid);
    //public ITeacherDao getTeacherDao(String sid);
}
