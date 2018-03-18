package cn.sjh.pattern.observer.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *  事件的注册和监听
 * Created  by songjh on 2018-03-19 07:20.
 */
public class EventLisenter {

    protected Map<Enum,Event> events = new HashMap<>();


    public void addLisenter(Enum eventType,Object target,Method callBack){
        //注册事件
        //用反射调用这个方法
        events.put(eventType,new Event(target,callBack));
    }


    private void trigger(Event e){
        e.setSource(this);
        e.setTime(System.currentTimeMillis());
        try {
            e.getCallback().invoke(e.getTarget(),e);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
    }


    protected void trigger(Enum eventType){
        if(!this.events.containsKey(eventType)){
            return;
        }
        Event event = this.events.get(eventType);
        event.setTrigger(eventType.name());
        trigger(event);
    }



}
