package io.github.egd.prodigal.app.command.query;

import io.github.egd.prodigal.app.converter.HistoryEventConverter;
import io.github.egd.prodigal.model.vo.HistoryEventVO;
import io.github.egd.prodigal.repository.entity.HistoryEventPO;
import io.github.egd.prodigal.repository.mapper.HistoryEventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 历史事件查询器
 */
@Component
public class HistoryQueryExe {

    @Autowired
    HistoryEventMapper historyEventMapper;

    /**
     * 查询历史事件
     *
     * @return HistoryEventVO
     */
    public HistoryEventVO queryHistory() {
        HistoryEventPO eventPO = historyEventMapper.query();
        return HistoryEventConverter.convert(eventPO);
    }


}
