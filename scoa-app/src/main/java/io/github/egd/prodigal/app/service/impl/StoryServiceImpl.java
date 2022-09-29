package io.github.egd.prodigal.app.service.impl;

import io.github.egd.prodigal.app.command.HistoryEventCmdExe;
import io.github.egd.prodigal.app.command.KillYanliangCmdExe;
import io.github.egd.prodigal.app.command.query.HistoryQueryExe;
import io.github.egd.prodigal.app.converter.HistoryEventConverter;
import io.github.egd.prodigal.model.vo.HistoryEventVO;
import io.github.egd.prodigal.app.service.StoryService;
import io.github.egd.prodigal.model.domain.Camp;
import io.github.egd.prodigal.model.domain.General;
import io.github.egd.prodigal.model.domain.Lord;
import io.github.egd.prodigal.model.domain.Warrior;
import io.github.egd.prodigal.model.factory.DomainObjectFactory;
import io.github.egd.prodigal.repository.entity.HistoryEventPO;
import io.github.egd.prodigal.repository.mapper.HistoryEventMapper;
import io.github.egd.prodigal.repository.mapper.PeopleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryServiceImpl implements StoryService {

    private final Logger logger = LoggerFactory.getLogger(StoryServiceImpl.class);

    @Autowired
    PeopleMapper peopleMapper;

    @Autowired
    private KillYanliangCmdExe killYanliangCmdExe;

    @Autowired
    private HistoryQueryExe historyQueryExe;

    @Autowired
    private HistoryEventCmdExe historyEventCmdExe;

    @Override
    public void performs() {
        killYanliangCmdExe.kill();
    }

    @Override
    public void reset() {
        historyEventCmdExe.reset();
    }

    @Override
    public HistoryEventVO queryHistory() {
        return historyQueryExe.queryHistory();
    }

}
