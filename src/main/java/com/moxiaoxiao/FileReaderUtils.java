package com.moxiaoxiao;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

public class FileReaderUtils {

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
        StringBuffer stringBuffer = new StringBuffer();
        char[]chars = new char[512];
        int size = 0;
        while ((size = fileReader.read(chars)) != -1) {
            stringBuffer.append(new String(chars,0,size));
        }
        return stringBuffer.toString();
    }
}
