package DecoratorPattern.AbstractAndExtend.decorator;

import DecoratorPattern.AbstractAndExtend.component.Component;

/**
 * Created by tao on 2018/9/11.
 * 组件装饰抽象类
 *
 * 通过注入的方式，对抽象组件类实现了进一步的包装
 */
public class ComponentDecorator extends Component {
    private Component component;

    //注入抽象构件类型的对象
    public ComponentDecorator(Component component){
        this.component = component;
    }


    //继承组件抽象类的方法
    public void display() {
        component.display();
    }
}
