package TemplateMethod.Demo1;

abstract class Account {

    //模板方法
    public void handle(String name,String password){
        if(validate(name,password)){
            double interest = calculateInterest();
            display(interest);
        }
    }

    //具体方法 : 模拟用户登录
    public boolean validate(String name,String password){
        if(name.equals("tao") && password.equals("123456")){
            return true;
        }
        return false;
    }

    //抽象方法 ：计算用户利息
    public double calculateInterest(){
        return 0;
    }

    //钩子方法 ： 展示用户利息
    public void display(double interest){
        System.out.println(interest);
    }

}
