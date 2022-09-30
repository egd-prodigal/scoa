package io.github.egd.prodigal.domain.object;

import io.github.egd.prodigal.event.HistoryEvent;
import io.github.egd.prodigal.model.domain.General;
import io.github.egd.prodigal.repository.mapper.CampMapper;
import io.github.egd.prodigal.repository.mapper.PeopleMapper;
import io.github.egd.prodigal.util.YearUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 将领领域对象
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GeneralObject extends General {

    private final Logger logger = LoggerFactory.getLogger(GeneralObject.class);

    @Autowired
    private PeopleMapper peopleMapper;

    @Autowired
    private CampMapper campMapper;

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 杀敌方将领
     *
     * @param enemy 地方将领
     */
    @Override
    public void kill(General enemy) {
        // 地方阵营永远失去了一个将领
        campMapper.deadCampGenerals(enemy);
        // 本质上是给对方将领设置了卒年
        peopleMapper.updateDead(enemy.getFirstName(), enemy.getLastName(), enemy.getStyleName(), YearUtils.getCurrentReignTitle());
        // 发布历史事件
        applicationContext.publishEvent(new HistoryEvent("关羽于万军丛中取颜良首级"));
    }

    /**
     * 将领于两军阵前的一席话语
     *
     * @param words 话语
     */
    @Override
    public void speak(String words) {
        logger.info("{}曰：{}", getStyleName(), words);
    }

}
