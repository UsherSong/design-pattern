package cn.sjh.pattern.adapter.passport;


import cn.sjh.pattern.adapter.Member;
import cn.sjh.pattern.adapter.ResultMsg;

/**
 * Created by Tom on 2018/3/14.
 */
public class SiginService {

    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password){
        return  new ResultMsg(200,"注册成功",new Member());
    }


    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password){
        return null;
    }

}
