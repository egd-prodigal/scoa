package io.github.egd.prodigal.facade.web;

import io.github.egd.prodigal.model.vo.HistoryEventVO;
import io.github.egd.prodigal.app.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;

    @RequestMapping("/story")
    public HistoryEventVO performs() {
        storyService.reset();
        storyService.performs();
        return storyService.queryHistory();
    }

}
