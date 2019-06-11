package com.houyao.fileTools;

import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author: houyao
 * @Description:解压文件的类
 * @Date: Created in 17:47:05 2019/6/10
 */
public class UnzipFile {

    public static void main(String[] args) throws IOException{
        unZipGzFile();
    }

    /**
    * @Description: 解压gz的文件
    * @auther: houyao
    * @date: 17:48:12 2019/6/10
    * @param: []
    * @return: void
    *
    */
    public static void unZipGzFile() throws IOException{
        //被解压的文件
       String compressedFilePath ="D:\\test.gz";
       //解压的目标文件
        String targetFilePath = "D:\\test.txt";
        InputStream fin = null;
        BufferedInputStream in = null;
        OutputStream out = null;
        GzipCompressorInputStream gcis = null;
        try {
            out = Files.newOutputStream(Paths.get(targetFilePath));
            fin = Files.newInputStream(Paths.get(compressedFilePath));
            in = new BufferedInputStream(fin);
            gcis = new GzipCompressorInputStream(in);
            final byte[] buffer = new byte[1024];
            int n = 0;
            while (-1 != (n = gcis.read(buffer))) {
                out.write(buffer, 0, n);
            }
        }finally {
            if(gcis != null){
                gcis.close();
            }
            if(in != null){
                in.close();
            }
            if(fin != null){
                fin.close();
            }
            if(out != null){
                out.close();
            }
        }
    }
}
