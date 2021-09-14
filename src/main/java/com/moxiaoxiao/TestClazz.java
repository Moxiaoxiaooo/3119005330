package com.moxiaoxiao;

import org.ansj.domain.Term;
import org.ansj.splitWord.Analysis;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.junit.Test;

import java.util.List;

public class TestClazz {

    public static final String TEXT = "这是一句想要备份的话，我觉得狮白杜丹和Towa真的好可爱啊，我好喜欢她们，想和她们结婚，特别是Towa";

    @Test
    public void m1() {

        //get terms后循环每个terms进入map，key是词，value是词频，再通过词频计算值
        List<Term> terms = BaseAnalysis.parse(TEXT).getTerms();
        for (Term term : terms) {
            System.out.println(term.getName() + "  词性是  " + term.getNatureStr() + '\n');
        }
    }
}
