package com.houyao.fileTools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: houyao
 * @Description:筛选货币对 未完成，不能使用
 * @Date: Created in 17:35:31 2019/8/26
 */
public class ScreenCcyPair {
    public static void main(String[] args) throws IOException {
        String basepath = "C:\\Users\\houyao\\Desktop\\TEMP\\ccypair\\";
        File file1 = new File(basepath + "1.txt");
        File file2 = new File(basepath + "2.txt");
        File fileTHB = new File(basepath + "THB.txt");

        List<String> list2 = new ArrayList<String>();
        List<String> listTHB = new ArrayList<String>();

        FileInputStream fis=new FileInputStream(file1);
        InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        //简写如下
        //BufferedReader br = new BufferedReader(new InputStreamReader(
        //        new FileInputStream("E:/phsftp/evdokey/evdokey_201103221556.txt"), "UTF-8"));
        String line="";
        String[] arrs=null;
        while ((line=br.readLine())!=null) {
            if (line.contains("THB")){
                listTHB.add(line);
            } else {
                list2.add(line);
            }
        }
        br.close();
        isr.close();
        fis.close();

        //写入中文字符时解决中文乱码问题
        FileOutputStream fos=new FileOutputStream(fileTHB);
        OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter  bw=new BufferedWriter(osw);
        //简写如下：
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
        //        new FileOutputStream(new File("E:/phsftp/evdokey/evdokey_201103221556.txt")), "UTF-8"));

        for(String thb:listTHB){
            bw.write(thb+"\t\n");
        }

        //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
        bw.close();
        osw.close();
        fos.close();

        //写入中文字符时解决中文乱码问题
        FileOutputStream fos2=new FileOutputStream(file2);
        OutputStreamWriter osw2=new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter  bw2=new BufferedWriter(osw);
        //简写如下：
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
        //        new FileOutputStream(new File("E:/phsftp/evdokey/evdokey_201103221556.txt")), "UTF-8"));

        for(String ccypair2:list2){
            bw2.write(ccypair2+"\t\n");
        }

        //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
        bw2.close();
        osw2.close();
        fos2.close();


    }
}
