package DecoratorPattern.AbstractAndExtend;

import DecoratorPattern.AbstractAndExtend.component.Component;
import DecoratorPattern.AbstractAndExtend.component.Window;
import DecoratorPattern.AbstractAndExtend.decorator.BlackBorderDecorator;
import DecoratorPattern.AbstractAndExtend.decorator.ScrollBarDecorator;

/**
 * Created by tao on 2018/9/11.
 *  客户端启动方法类
 */
public class Main {
    public static void main(String[] args) {
        Component component = new Window();

        //两次装饰 生成了：黑色边框，带滚动条的窗体
        Component blackScrollComponent = new BlackBorderDecorator(new ScrollBarDecorator(component));

        //display调用过程：后封装的先调用
        blackScrollComponent.display();
    }
}
