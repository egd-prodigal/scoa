package io.github.egd.prodigal.test.service;

import io.github.egd.prodigal.app.service.StoryService;
import io.github.egd.prodigal.model.vo.HistoryEventVO;
import io.github.egd.prodigal.test.starter.ScoaAppStarter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ScoaAppStarter.class)
@RunWith(SpringRunner.class)
public class StoryServiceTest {

    private final Logger logger = LoggerFactory.getLogger(StoryServiceTest.class);

    @Autowired
    private StoryService storyService;

    @Test
    public void kill() {
        storyService.reset();
        storyService.performs();
        HistoryEventVO historyEventVO = storyService.queryHistory();
        Assert.assertNotNull(historyEventVO);
        logger.info("查询史书: {}", historyEventVO.getEvent());
    }

}
