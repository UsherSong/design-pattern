package cn.sjh.pattern.factory.func;


import cn.sjh.pattern.factory.Milk;
import cn.sjh.pattern.factory.Telunsu;

/**
 * 事情变得越来越专业
 * Created by Tom on 2018/3/4.
 */
public class TelunsuFactory implements Factory {

    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
