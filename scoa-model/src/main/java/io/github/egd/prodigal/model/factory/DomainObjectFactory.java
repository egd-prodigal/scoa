package io.github.egd.prodigal.model.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class DomainObjectFactory implements ApplicationContextAware {

    private static ApplicationContext context;

    public static <T> T create(Class<T> type) {
        return context.getBean(type);
    }

    public static <T> T create(Class<T> type, Consumer<T> afterCreate) {
        if (afterCreate == null) {
            return create(type);
        }
        T bean = context.getBean(type);
        afterCreate.accept(bean);
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DomainObjectFactory.context = applicationContext;
    }
}
