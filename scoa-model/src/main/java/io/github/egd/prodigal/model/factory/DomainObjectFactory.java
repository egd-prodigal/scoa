package io.github.egd.prodigal.model.factory;

import io.github.egd.prodigal.model.domain.Camp;
import io.github.egd.prodigal.model.domain.General;
import io.github.egd.prodigal.model.domain.People;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * 领域对象工厂，此处的方法应由公共依赖提供，此处的这个类应该是提供具体的创建对象的方法，见{@link #letUsSeeGuanyu(People, Camp)}
 */
@Component
public class DomainObjectFactory implements ApplicationContextAware {

    /**
     * Spring上下文
     */
    private static ApplicationContext context;

    /**
     * 创建领域对象
     *
     * @param type 类型
     * @return 领域模型对象
     */
    public static <T> T create(Class<T> type) {
        return context.getBean(type);
    }

    /**
     * 创建领域对象
     *
     * @param type           类型
     * @param initAttributes 初始化动作
     * @return 领域模型对象
     */
    public static <T> T create(Class<T> type, Consumer<T> initAttributes) {
        if (initAttributes == null) {
            return create(type);
        }
        T bean = context.getBean(type);
        initAttributes.accept(bean);
        return bean;
    }

    /**
     * 让我们一睹关二爷真容
     *
     * @param people 人物
     * @param camp   阵营
     * @return General
     */
    public static General letUsSeeGuanyu(People people, Camp camp) {
        General guanyu = context.getBean(General.class);
        guanyu.setPeople(people);
        guanyu.setCamp(camp);
        return guanyu;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DomainObjectFactory.context = applicationContext;
    }
}
