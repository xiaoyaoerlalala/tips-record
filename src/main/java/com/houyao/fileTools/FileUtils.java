package com.houyao.fileTools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FileUtils {
    public static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    private FileUtils() {}

    /**
     * 读取配置文件
     * SPOT_FXSPOT_USDSEK=8.66870;4;100;Y;
     * @param path
     */
    public static List<String> readConfig(String path){
        List<String> list = new ArrayList<String>();
        BufferedReader reader = null;
        try {
            File file = new File(path);
            if(!file.exists()){
                logger.info("文件不存在" + path);
                return Collections.emptyList() ;
            }
            //读取配置文件
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
            String tempString = null;

            //一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                list.add(tempString);
            }
            logger.info("读取结束：" + path);
        } catch(IOException e) {
            logger.error("读取文本IO异常：" + e.getMessage());
        } catch(Exception e) {
            logger.error("读取文本异常：" + e.getMessage());
        }finally {
            try {
                reader.close();
            } catch (IOException ex) {
                logger.error("关闭写出流异常：" + ex.getMessage());
            } catch (Exception ex) {
                logger.error("关闭写出流异常：" + ex.getMessage());
            }
        }
        return list;
    }
}
