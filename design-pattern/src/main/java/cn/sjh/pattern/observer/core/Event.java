package cn.sjh.pattern.observer.core;

import java.lang.reflect.Method;

/**
 * Created  by songjh on 2018-03-19 07:07.
 */
public class Event {

    //事件源
    private Object source;
    //通知目标
    private Object target;
    //回调
    private Method callback;
    //触发
    private String trigger;

    private long time;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }


    public Object getSource() {
        return source;
    }


    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    @Override
    public String toString() {
        return "Event{" +
                "\n\t source=" + source + ",\n" +
                "\t target=" + target + ",\n" +
                "\t callback=" + callback + ",\n" +
                "\t trigger='" + trigger + '\'' + "\n" +
                '}';
    }

    public long getTime() {
        return time;
    }

    Event setTime(long time) {
        this.time = time;
        return this;
    }

    Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }


}
