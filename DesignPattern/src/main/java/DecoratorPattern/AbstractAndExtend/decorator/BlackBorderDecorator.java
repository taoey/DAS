package DecoratorPattern.AbstractAndExtend.decorator;

import DecoratorPattern.AbstractAndExtend.component.Component;

/**
 * Created by tao on 2018/9/11.
 * 具体装饰类：黑色边框
 */
public class BlackBorderDecorator extends ComponentDecorator {
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        this.setBlackBorder();
        super.display();
    }

    public void setBlackBorder(){
        System.out.println("添加了黑色边框");
    }
}
