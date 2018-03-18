package cn.sjh.pattern.observer.subject;

import cn.sjh.pattern.observer.core.EventLisenter;

/**
 * 被观察者
 * Created  by songjh on 2018-03-19 07:35.
 */
public class Subject extends EventLisenter {

    //通常的话，采用动态里来实现监控，避免了代码侵入
    public void add(){
        System.out.println("调用添加的方法");
        trigger(SubjectEventType.ON_ADD);
    }

    public void remove(){
        System.out.println("调用删除的方法");
        trigger(SubjectEventType.ON_RMOVE);
    }


}
