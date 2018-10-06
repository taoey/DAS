package ProxyPattern.dao;


import ProxyPattern.common.AccessValidator;
import ProxyPattern.common.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ProxyDaoHandler implements InvocationHandler,IproxyBase{
    private Object object; //要代理的具体对象
    private AccessValidator accessValidator= new AccessValidator();
    private Logger logger  = new Logger();
    private String uid;


    public ProxyDaoHandler(Object obj,String uid) {
        this.uid = uid;
        this.object = obj;
    }

    @Override
    public Map preRequest(){
        Map<String,Object> map = new HashMap<>();
        boolean result = accessValidator.validate(this.uid);
        map.put("access",result);
        return map;
    }
    @Override
    public void postRequest(){
        logger.log(this.uid);
    }

    //主要的处理方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Map map = preRequest();
        Boolean access = (Boolean) map.get("access");
        Object result =null;
        if(access){
            result = method.invoke(object,args);
            postRequest();
        }
        return result;
    }
}
