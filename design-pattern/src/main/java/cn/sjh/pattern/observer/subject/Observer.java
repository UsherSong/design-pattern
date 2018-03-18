package cn.sjh.pattern.observer.subject;

import cn.sjh.pattern.observer.core.Event;

/**
 * 观察者
 * Created  by songjh on 2018-03-19 07:06.
 */
public class Observer {

    public void advice(Event e){
        System.out.println("=========触发事件，打印日志========\n" + e);

    }

}
