package cn.sjh.pattern.factory.func;


import cn.sjh.pattern.factory.Milk;
import cn.sjh.pattern.factory.Yili;

/**
 * Created by Tom on 2018/3/4.
 */
public class YiliFactory implements Factory {

    @Override
    public Milk getMilk() {
        return new Yili();
    }
}
