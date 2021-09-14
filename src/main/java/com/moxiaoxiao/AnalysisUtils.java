package com.moxiaoxiao;


import com.moxiaoxiao.exception.FileEmptyException;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.BaseAnalysis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnalysisUtils {

    /**
     * 分析text获取所有单词与对应的词频并返回map
     *
     * @param text 要被分析的文本
     * @return 文本的单词词频map，key：单词，value：词频
     */
    public static Map<String, Integer> getTermsAndCounts(String text) throws FileEmptyException {
        if (text == null || "".equals(text)) {
            throw new FileEmptyException();
        }
        List<Term> terms = BaseAnalysis.parse(text).getTerms();
        Map<String, Integer> resultMap = new HashMap<>();
        Set<String> ignoreNatureStrSet = new HashSet<String>() {
            {
                //要忽略单词的词性
                add("w");//标点符号
                add("null");//回车，空格
            }
        };
        for (Term term : terms) {
            //词性在忽略列表里
            if (ignoreNatureStrSet.contains(term.getNatureStr())) {
                continue;
            }
            Integer counts = resultMap.get(term.getName());
            if (counts == null || counts == 0) {
                //不存在于map
                resultMap.put(term.getName(), 1);
            } else {
                //存在于map
                resultMap.put(term.getName(), counts + 1);
            }
        }
        return resultMap;
    }
}
