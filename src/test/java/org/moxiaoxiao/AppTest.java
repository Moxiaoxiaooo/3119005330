package org.moxiaoxiao;

import static org.junit.Assert.assertTrue;

import com.moxiaoxiao.AnalysisUtils;
import com.moxiaoxiao.App;
import com.moxiaoxiao.FileUtils;
import com.moxiaoxiao.MathUtils;
import com.moxiaoxiao.exception.FileEmptyException;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class AppTest {

    @Test
    public void testReadFileToString() throws IOException {
        String path = "log.log";
        String context = FileUtils.readFileToString(path);
        System.out.println(context);
    }

    @Test
    public void testGetTermsAndCounts() throws IOException, FileEmptyException {
        String path = "log.log";
        String context = FileUtils.readFileToString(path);
        Map<String, Integer> map = AnalysisUtils.getTermsAndCounts(context);
        System.out.println(map);
    }

    @Test
    public void testGetRepeatRate() throws IOException, FileEmptyException {
        String path = "log.log";
        String path2 = "2.log";
        String context = FileUtils.readFileToString(path);
        Map<String, Integer> map = AnalysisUtils.getTermsAndCounts(context);
        String context2 = FileUtils.readFileToString(path2);
        Map<String, Integer> map2 = AnalysisUtils.getTermsAndCounts(context2);
        System.out.println(MathUtils.getRepeatRate(map, map2));
    }
    @Test
    public void testWriteAns() throws IOException, FileEmptyException {
        String path = "log.log";
        String path2 = "2.log";
        String context = FileUtils.readFileToString(path);
        Map<String, Integer> map = AnalysisUtils.getTermsAndCounts(context);
        String context2 = FileUtils.readFileToString(path2);
        Map<String, Integer> map2 = AnalysisUtils.getTermsAndCounts(context2);
        Double rate = MathUtils.getRepeatRate(map, map2);
        FileUtils.writeAns("ans.txt", path, path2, rate);
    }

    @Test
    public void testEmptyMain() throws Exception{
        String[] args = {"", "",""};
        App.main(args);
    }

    @Test
    public void testMain() throws Exception{
        String[] args = {"orig.txt", "orig.txt",""};
        App.main(args);
    }

}
