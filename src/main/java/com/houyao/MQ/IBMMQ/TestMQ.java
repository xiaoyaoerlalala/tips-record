package com.houyao.MQ.IBMMQ;

import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;

public class TestMQ {
    static MQQueueManager qMgr;
    static int CCSID = 1381;
    static String queueString = "MUREX_RET";

    public static void connect() throws MQException {
        /**
         * 设置环境:
         * MQEnvironment中包含控制MQQueueManager对象中的环境的构成的静态变量
         * MQEnvironment的值的设定会在MQQueueManager的构造函数加载的时候起作用
         * 因此必须在建立MQQueueManager对象之前设定MQEnvironment中的值.
         */
        MQEnvironment.hostname = "127.0.0.1";
        MQEnvironment.channel = "CONNECT_CHL";
        MQEnvironment.port = 1414;
        //服务器MQ服务使用的编码1381代表GBK、1208代表UTF-8
        MQEnvironment.CCSID = CCSID;
        //MQ中拥有权限的用户名
        MQEnvironment.userID = "admin";
        //用户名对应的密码
        MQEnvironment.password = "123456";
        //定义并初始化队列管理器对象并连接
        //MQQueueManager 可以被多线程共享，但是从MQ 获取信息的时候是同步的，任何时候只有一个线程可以和MQ 通信。
        qMgr = new MQQueueManager("QM_FMIP_MX ");

    }

    public static void sendMsg(String msgStr) {
        //设置将要连接的队列属性
        int openOptions = MQC.MQOO_INPUT_AS_Q_DEF | MQC.MQOO_OUTPUT | MQC.MQOO_INQUIRE;
        MQQueue queue = null;
        try {
            // 建立Q1通道的连接，连接队列
            queue = qMgr.accessQueue(queueString, openOptions, null, null, null);
            MQMessage msg = new MQMessage();// 要写入队列的消息
            msg.format = MQC.MQFMT_STRING;
            msg.characterSet = CCSID;
            msg.encoding = CCSID;
            // msg.writeObject(msgStr); //将消息写入消息对象中
            msg.writeString(msgStr);
            //设置写入消息的属性（默认属性）
            MQPutMessageOptions pmo = new MQPutMessageOptions();
            msg.expiry = -1; // 设置消息用不过期
            queue.put(msg, pmo);// 将消息放入队列
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (queue != null) {
                try {
                    queue.close();
                } catch (MQException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从队列中取消息
     */
    public static void receiveMsg() {
        //设置将要连接的队列属性
        int openOptions = MQC.MQOO_INPUT_AS_Q_DEF | MQC.MQOO_OUTPUT | MQC.MQOO_INQUIRE;
        MQQueue queue = null;
        try {
            queue = qMgr.accessQueue(queueString, openOptions, null, null, null);
            System.out.println("该队列当前的深度为:" + queue.getCurrentDepth());
            System.out.println("===========================");
            int depth = queue.getCurrentDepth();
            // 将队列的里的消息读出来
            while (depth-- > 0) {
                MQMessage msg = new MQMessage();// 要读的队列的消息
                MQGetMessageOptions gmo = new MQGetMessageOptions();
                queue.get(msg, gmo);
                System.out.println("消息的大小为：" + msg.getDataLength());
                System.out.println("消息的内容：\n" + msg.readStringOfByteLength(msg.getDataLength()));
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (queue != null) {
                try {
                    queue.close();
                } catch (MQException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws MQException {
        connect();
        sendMsg("我来测试一下");
        receiveMsg();
    }
}
