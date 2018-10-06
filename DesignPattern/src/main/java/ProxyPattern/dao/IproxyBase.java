package ProxyPattern.dao;

import java.util.Map;

/**
 * 代理器抽象类
 */
public interface IproxyBase {
    public Map preRequest();
    public void postRequest();
}
