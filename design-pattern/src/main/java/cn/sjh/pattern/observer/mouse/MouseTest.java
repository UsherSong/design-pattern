package cn.sjh.pattern.observer.mouse;

import cn.sjh.pattern.observer.core.Event;

import java.lang.reflect.Method;

public class MouseTest {

    public static void main(String[] args) {

        /*
        * var input = document.getElementById("username");
        * input.addLisenter("click",function(){
        *
        *     alert("鼠标点击了这个文本框");
        *
        * });
        *
        *
        * */

        //观察者和被观察者之间没有必然联系
        //注册的时候，才产生联系


        //解耦


        try {
            MouseEventCallback callback = new MouseEventCallback();
            Method onClick = MouseEventCallback.class.getMethod("onClick", Event.class);


            //人为的调用鼠标的单击事件
            Mouse mouse = new Mouse();
            mouse.addLisenter(MouseEventType.ON_CLICK, callback,onClick);

            mouse.onClick();
            mouse.onDoubleClick();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}