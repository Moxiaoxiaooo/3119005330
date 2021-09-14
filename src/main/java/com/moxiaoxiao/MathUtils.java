package com.moxiaoxiao;

import java.util.Map;

public class MathUtils {
    /**
     * 通过两个Map里的关键词和词频，用TF-IDF的余弦相似性进行重复率的计算
     *
     * @param source 原文
     * @param target 被比较的文章
     * @return 重复率
     */
    public static Double getRepeatRate(Map<String, Integer> source, Map<String, Integer> target) {
        //先循环两个map，有互相不包含的就size++
        int arraySize = source.size();
        for (Map.Entry<String, Integer> targetTemp : target.entrySet()) {
            if (!source.containsKey(targetTemp.getKey())) {
                arraySize++;
            }
        }
        int[] sourceLine = new int[arraySize];
        int[] targetLine = new int[arraySize];
        int i = 0;
        //先存source的词频进入数组
        for (Map.Entry<String, Integer> sourceTemp : source.entrySet()) {
            sourceLine[i] = sourceTemp.getValue();
            //如果target也有这个词，则存入同样位置
            if (target.containsKey(sourceTemp.getKey())) {
                targetLine[i] = target.get(sourceTemp.getKey());
            }
            i++;
        }
        //再存target的词频进入数组
        for (Map.Entry<String, Integer> targetTemp : target.entrySet()) {
            if (source.containsKey(targetTemp.getKey())) {
                //在上面已经存过了
                continue;
            }
            targetLine[i] = targetTemp.getValue();
            i++;
        }
        return calculateRepeatRate(sourceLine, targetLine);
    }


    /**
     * 通过词频数组计算重复率
     *
     * @param source 原文词频数组
     * @param target 比较文词频数组
     * @return 重复率
     */
    public static Double calculateRepeatRate(int[] source, int[] target) {
        if (source.length != target.length) {
            return null;
        }
        //分子 a[i]*b[i] + ...
        Double molecular = 0.0;
        //分母 sqrt(a[i]^2 + a[i+1]^2 + .. ) * sqrt(b[i]^2 + b[i+1]^2 + ..)
        Double denominator = 0.0;
        //被开方数
        Double sourceRoot = 0.0;
        Double targetRoot = 0.0;
        for (int i = 0; i < source.length; i++) {
            molecular += source[i] * target[i];
            sourceRoot += Math.pow(source[i], 2);
            targetRoot += Math.pow(target[i], 2);
        }
        denominator += Math.sqrt(sourceRoot) * Math.sqrt(targetRoot);
        return molecular / denominator;
    }
}
