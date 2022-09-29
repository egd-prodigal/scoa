package io.github.egd.prodigal.app.converter;

import io.github.egd.prodigal.model.vo.HistoryEventVO;
import io.github.egd.prodigal.repository.entity.HistoryEventPO;

public class HistoryEventConverter {

    public static HistoryEventVO convert(HistoryEventPO po) {
        HistoryEventVO historyEventVO = new HistoryEventVO();
        historyEventVO.setEvent(String.format("%s，%s", po.getReignTitle(), po.getHistory()));
        return historyEventVO;
    }

}
