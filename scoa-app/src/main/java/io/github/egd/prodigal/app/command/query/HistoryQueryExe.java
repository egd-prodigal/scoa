package io.github.egd.prodigal.app.command.query;

import io.github.egd.prodigal.app.converter.HistoryEventConverter;
import io.github.egd.prodigal.model.vo.HistoryEventVO;
import io.github.egd.prodigal.repository.entity.HistoryEventPO;
import io.github.egd.prodigal.repository.mapper.HistoryEventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoryQueryExe {

    @Autowired
    HistoryEventMapper historyEventMapper;

    public HistoryEventVO queryHistory() {
        HistoryEventPO eventPO = historyEventMapper.query();
        return HistoryEventConverter.convert(eventPO);
    }


}
