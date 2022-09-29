package io.github.egd.prodigal.app.service;

import io.github.egd.prodigal.model.vo.HistoryEventVO;

public interface StoryService {

    void performs();

    void reset();

    HistoryEventVO queryHistory();

}
