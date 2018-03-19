package cn.sjh.pattern.factory.func;


import cn.sjh.pattern.factory.Milk;
import cn.sjh.pattern.factory.Sanlu;

/**
 * Created by Tom on 2018/3/4.
 */
public class SanluFactory implements  Factory {
    @Override
    public Milk getMilk() {
        return new Sanlu();
    }
}
