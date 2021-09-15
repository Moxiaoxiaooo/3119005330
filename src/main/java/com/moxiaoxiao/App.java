package com.moxiaoxiao;

import com.moxiaoxiao.exception.FileEmptyException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        //args[0]：原文文件  args[1]：抄袭版论文的文件 args[2]：答案文件.3
        if (args.length != 3) {
            System.out.println("请确保参数个数正确");
        } else {
            try {
                String sourceText = FileUtils.readFileToString(args[0]);
                String targetText = FileUtils.readFileToString(args[1]);
                Map<String, Integer> sourceMap = AnalysisUtils.getTermsAndCounts(sourceText);
                Map<String, Integer> targetMap = AnalysisUtils.getTermsAndCounts(targetText);
                Double rate = MathUtils.getRepeatRate(sourceMap, targetMap);
                FileUtils.writeAns(args[2], args[0], args[1], rate);
                System.out.println("已将结果输出至：" + args[2]);
            } catch (FileNotFoundException e) {
                System.out.println("原论文与抄袭论文不存在！");
            } catch (FileEmptyException e) {
                System.out.println("答案文件已存在，请使用新路径以避免覆盖！");
            } catch (IOException e) {
                System.out.println("文件读取有异常！");
            }

        }
    }
}
