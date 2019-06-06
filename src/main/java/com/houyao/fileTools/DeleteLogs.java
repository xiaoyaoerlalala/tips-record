package com.houyao.fileTools;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * @Author: houyao
 * @Description:日志文件夹中仅保留30天的日志，删除最后修改时间大于30天的日志文件
 * @Date: Created in 14:28:16 2019/6/6
 */
public class DeleteLogs {
    private final static String dirPathLog = "D:\\config\\hkbet_interface\\trade";    //日志文件夹

    public static void main(String[] args) {
        File file = new File(dirPathLog);
        if(file.exists()){
            if(file.isDirectory()){
                //获得文件夹里所有文件（夹）名，保存在files数组中
                File[] files = file.listFiles();
                //遍历每一个文件(夹)
                for(File f:files){
                    //获取文件（夹）的绝对路径
                    File absFile = f.getAbsoluteFile();

                    //计算时间
                    long day = 5;
                    long hour = 24;
                    long minute = 60;
                    long second = 60;
                    long mmcond = 1000;

                    //获取当前时间
                    long currentTime = System.currentTimeMillis();
                    //获取文件（夹）最后一次被修改的时间
                    long lastTime = absFile.lastModified();
                    //时间差
                    long diffen = currentTime - lastTime;
                    //日志保留的毫秒数
                    long keepMillis = day * hour * minute * second * mmcond;

                    //判断是否删除
                    if(diffen >= keepMillis){
                        absFile.delete();
                        long delTime = System.currentTimeMillis();   //删除文件（夹）的时间--毫秒数
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
                        String formatTime = sdf.format(delTime);
                        String strDel = "删除该文件的时间是：" + "\t"+formatTime+"\t" + "\t删除的文件是：" + absFile.getAbsolutePath(); //absFile.getAbsolutePath()获得你要删除文件的绝对路径
                        System.out.println(strDel);
                    }

                }

            }else{
                System.out.println("dirPathLog is not a directory");
            }
        }else{
            System.out.println("dirPathLog is not exists");
        }
    }
}
