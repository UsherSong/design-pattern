package cn.sjh.pattern.observer.mouse;

import cn.sjh.pattern.observer.core.EventLisenter;

/**
 *
 * 被观察者
 * Created  by songjh on 2018-03-19 07:48.
 */
public class Mouse extends EventLisenter{

    public void onClick(){
        System.out.println("鼠标点击");
        trigger(MouseEventType.ON_CLICK);
    }

    public void onDoubleClick(){
        System.out.println("鼠标双击");
        trigger(MouseEventType.ON_DOUBLE_CLICK);
    }

}
