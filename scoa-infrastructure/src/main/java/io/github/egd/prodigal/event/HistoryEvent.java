package io.github.egd.prodigal.event;

import org.springframework.context.ApplicationEvent;

public class HistoryEvent extends ApplicationEvent {

    public HistoryEvent(Object source) {
        super(source);
    }

}
