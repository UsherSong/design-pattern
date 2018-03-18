package cn.sjh.pattern.observer.mouse;

import cn.sjh.pattern.observer.core.Event;

/**
 * 观察者
 * Created  by songjh on 2018-03-19 07:52.
 */
public class MouseEventCallback {

    public void onClick(Event e){
        System.out.println("这是鼠标单击以后要执行的逻辑");
        System.out.println("=======触发鼠标单击事件========\n" + e);
    }
    public void onDoubleClick(Event e){
        System.out.println("这是鼠标双击以后要执行的逻辑");
        System.out.println("=======触发双标单击事件========\n" + e);
    }
}
