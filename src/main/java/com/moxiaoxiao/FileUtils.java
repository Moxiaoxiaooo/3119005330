package com.moxiaoxiao;


import com.moxiaoxiao.exception.FileFoundedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    /**
     * 通过文件路径获取文件并将内容转换为String
     *
     * @param filePath 文件路径
     * @return 文件内容字符串
     */
    public static String readFileToString(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        FileReader fileReader = new FileReader(file);
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = new char[512];
        int size = 0;
        while ((size = fileReader.read(chars)) != -1) {
            stringBuilder.append(new String(chars, 0, size));
        }
        fileReader.close();
        return stringBuilder.toString();
    }


    public static Boolean writeAns(String filePath, String sourceFileName, String targetFileName, Double repeatRate) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            //处理文件存在异常
            throw new FileFoundedException();
        }
        FileWriter fileWriter = new FileWriter(file);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("原文：").append(sourceFileName)
                .append("\n抄袭版论文的文件：").append(targetFileName)
                .append("\n重复率：").append(repeatRate);
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
        return true;
    }
}
