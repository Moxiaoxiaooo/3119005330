package com.moxiaoxiao.exception;

/**
 * 文件内容空白异常
 */
public class FileEmptyException extends Exception {
    public FileEmptyException() {
    }

    public FileEmptyException(String message) {
        super(message);
    }
}
