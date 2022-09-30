package io.github.egd.prodigal.app.service.impl;

import io.github.egd.prodigal.app.command.HistoryEventCmdExe;
import io.github.egd.prodigal.app.command.KillYanliangCmdExe;
import io.github.egd.prodigal.app.command.query.HistoryQueryExe;
import io.github.egd.prodigal.app.service.StoryService;
import io.github.egd.prodigal.model.vo.HistoryEventVO;
import io.github.egd.prodigal.repository.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 历史故事服务接口实现
 */
@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    PeopleMapper peopleMapper;

    @Autowired
    private KillYanliangCmdExe killYanliangCmdExe;

    @Autowired
    private HistoryQueryExe historyQueryExe;

    @Autowired
    private HistoryEventCmdExe historyEventCmdExe;

    /**
     * 演绎历史
     */
    @Override
    public void performs() {
        killYanliangCmdExe.kill();
    }

    /**
     * 重置历史
     */
    @Override
    public void reset() {
        historyEventCmdExe.reset();
    }

    /**
     * 查询历史
     *
     * @return HistoryEventVO
     */
    @Override
    public HistoryEventVO queryHistory() {
        return historyQueryExe.queryHistory();
    }

}
