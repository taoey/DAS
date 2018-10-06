package ProxyPattern.common;

/**
 * 用户验证器
 */
public class AccessValidator {
    public boolean validate(String uid){
        boolean reslut;
        if(uid.equals("黄为涛")){
            System.out.println("用户"+uid+"验证成功");
            reslut=true;
        }else{
            System.out.println("用户"+uid+"为无效用户！！！");
            reslut = false;
        }
        return reslut;
    }
}
