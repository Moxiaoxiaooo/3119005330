package org.moxiaoxiao;

import static org.junit.Assert.assertTrue;

import com.moxiaoxiao.AnalysisUtils;
import com.moxiaoxiao.FileReaderUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testGetTermsAndCounts() throws IOException {
        String path = "log.log";
        String context= FileReaderUtils.readFileToString(path);
        Map<String,Integer> map   = AnalysisUtils.getTermsAndCounts(context);
        System.out.println(map);
    }
}
