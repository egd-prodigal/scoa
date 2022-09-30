package io.github.egd.prodigal.event;

import org.springframework.context.ApplicationEvent;

/**
 * 历史事件，通过Spring事件机制实现
 */
public class HistoryEvent extends ApplicationEvent {

    /**
     * 定义历史事件
     *
     * @param source 历史事件概述
     */
    public HistoryEvent(Object source) {
        super(source);
    }

}
