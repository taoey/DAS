package DecoratorPattern.AbstractAndExtend.decorator;

import DecoratorPattern.AbstractAndExtend.component.Component;

/**
 * Created by tao on 2018/9/11.
 * 具体装饰类：滚动条装饰
 */
public class ScrollBarDecorator extends ComponentDecorator{

    //因为继承了ComponentDecorator，所以必须要实现该构造方法
    public ScrollBarDecorator(Component component) {
        super(component);
    }

    //重新构造方法
    @Override
    public void display(){
        this.setScorllBar();
        super.display();
    }

    //一个装饰方法，设置一个滚动条
    public void setScorllBar(){
        System.out.println("添加了一个滚动条");
    }

}
