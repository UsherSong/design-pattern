package cn.sjh.pattern.factory.func;


import cn.sjh.pattern.factory.Mengniu;
import cn.sjh.pattern.factory.Milk;

/**
 * Created by Tom on 2018/3/4.
 */
public class MengniuFactory implements  Factory {


    @Override
    public Milk getMilk() {
        return new Mengniu();
    }
}
