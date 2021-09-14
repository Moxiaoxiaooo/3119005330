package org.moxiaoxiao;

import static org.junit.Assert.assertTrue;

import com.moxiaoxiao.FileReaderUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testReadFileToString() throws IOException {
        String path = "log.log";
        String context= FileReaderUtils.readFileToString(path);
        System.out.println(context);
    }
}
