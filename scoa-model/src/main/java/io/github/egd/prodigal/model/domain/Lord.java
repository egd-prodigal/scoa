package io.github.egd.prodigal.model.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * 主公领域模型
 */
public class Lord extends People implements Warrior {

    private final Logger logger = LoggerFactory.getLogger(Lord.class);

    /**
     * 主公源于人物
     * 王侯将相宁有种乎？
     */
    public static Lord fromPeople(People people) {
        Lord lord = new Lord();
        BeanUtils.copyProperties(people, lord);
        return lord;
    }

    /**
     * 焉有主公亲自上阵杀敌之说
     *
     * @param enemy 地方将领
     */
    @Override
    public void kill(General enemy) {
        throw new UnsupportedOperationException("主公不上阵杀敌");
    }

    /**
     * 主公鼓舞士气
     *
     * @param words 话语
     */
    @Override
    public void speak(String words) {
        logger.info("{}曰：{}", getLastName(), words);
    }
}
