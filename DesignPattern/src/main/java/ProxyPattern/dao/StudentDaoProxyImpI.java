package ProxyPattern.dao;

import ProxyPattern.common.AccessValidator;
import ProxyPattern.common.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用静态代理的方式实现日志
 */
public class StudentDaoProxyImpI implements IstudentDao,IproxyBase {
    private AccessValidator accessValidator= new AccessValidator();
    private IstudentDao  studentDao = new StudentDaoImpI();
    private Logger logger  = new Logger();
    private String uid;


    /**
     * 构造参数必须传入一个uid来判断用户的身份
     * @param uid
     */
    public StudentDaoProxyImpI(String uid){
        this.uid =  uid;
    }


    @Override
    public void add(Integer student) {
        Map map = preRequest();
        Boolean access = (Boolean) map.get("access");
        if(access){
            studentDao.add(student);
            postRequest();
        }
    }

    @Override
    public void del(Integer sid) {
        Map map = preRequest();
        Boolean access = (Boolean) map.get("access");
        if(access){
            studentDao.del(sid);
            postRequest();
        }
    }

    /**
     * 把执行结果放到一个map中，简化了代码
     * @return
     */
    @Override
    public Map preRequest() {
        Map<String,Object> map = new HashMap<>();
        boolean result = accessValidator.validate(this.uid);
        map.put("access",result);
        return map;
    }


    @Override
    public void postRequest() {
        logger.log(this.uid);
    }
}
