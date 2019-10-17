package com.houyao.xnet;

import com.erayt.utils.XStream;
import com.erayt.xnet4j.XNetCommand;
import com.erayt.xnet4j.XNetData;
import com.erayt.xnet4j.XNetSocket;

public class CommonTest {
    public static void main(String[] args) throws InterruptedException {

        XNetSocket xnetSocket = new XNetSocket("", "", "127.0.0.1", 43132, new Xhs(), 3000);
        System.out.println("启动XNET线程.....");
        xnetSocket.openwait();
        Thread.sleep(2000L);
        if (xnetSocket.isLoginOK()) {
            System.out.println("XNET 登录成功.....");
        }
        //DateTimeUtils.getSpecifiedTimeAfter("86400");
        XNetData data =new XNetData();
        XStream xs = new XStream();
        try {
            for (int i = 0; i < 100; i++) {
                xs.append("setname1");
                xs.append("SPOT#GBPUSD#SPOT=BOCX");
                xs.append("5");
                for (int j = 0; j < 70; j++) {
                    xs.append("1.44356");
                }
            }
            System.out.println("长度：" + xs.toString().length());
        } catch (Exception e) {

        }
        data.setData(xs.toString());
        data.setTitle("Price.Publisher1.ReqHeartBeatFS");
        data.setCommand(XNetCommand.TITLE);
        if(xnetSocket.isLoginOK()){
            xnetSocket.sendData(data);
        }
    }
}
