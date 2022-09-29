package io.github.egd.prodigal.app.command;

import io.github.egd.prodigal.repository.entity.HistoryEventPO;
import io.github.egd.prodigal.repository.mapper.HistoryEventMapper;
import io.github.egd.prodigal.util.YearUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoryEventCmdExe {

    private final Logger logger = LoggerFactory.getLogger(HistoryEventCmdExe.class);

    @Autowired
    HistoryEventMapper historyEventMapper;

    public void reset() {
        logger.info("时光来到了建安五年，曹操举兵攻打袁绍，路遇袁绍强将颜良所带兵马，双方即将开始一场遭遇战");
        historyEventMapper.deleteAll();
    }

    public void record(String reginTitle, String history) {
        HistoryEventPO po = new HistoryEventPO();
        po.setReignTitle(reginTitle);
        po.setHistory(history);
        logger.info("历史记载：{}，{}", reginTitle, history);
        historyEventMapper.insert(po);
    }

}
