package com.moxiaoxiao.exception;

import java.io.IOException;

/**
 * 文件已经存在异常
 */
public class FileFoundedException extends IOException {

    public FileFoundedException() {
    }

    public FileFoundedException(String message) {
        super(message);
    }
}
