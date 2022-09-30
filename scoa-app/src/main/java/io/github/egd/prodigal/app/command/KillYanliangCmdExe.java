package io.github.egd.prodigal.app.command;

import io.github.egd.prodigal.model.domain.Camp;
import io.github.egd.prodigal.model.domain.General;
import io.github.egd.prodigal.model.domain.Lord;
import io.github.egd.prodigal.model.domain.Warrior;
import io.github.egd.prodigal.model.factory.DomainObjectFactory;
import io.github.egd.prodigal.repository.mapper.PeopleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 关羽诛颜良执行器
 */
@Component
public class KillYanliangCmdExe {

    private final Logger logger = LoggerFactory.getLogger(KillYanliangCmdExe.class);

    @Autowired
    PeopleMapper peopleMapper;

    /**
     * 诛颜良
     */
    public void kill() {
        // 曹操与曹操阵营
        Lord caocao = Lord.fromPeople(peopleMapper.query("曹", "操", "孟德"));
        Camp caocaoCamp = DomainObjectFactory.create(Camp.class);
        caocaoCamp.setLord(caocao);
        List<General> generals = caocaoCamp.getGenerals();
        logger.info("曹操阵营站了{}个人", generals.size());
        caocao.speak("河北人马，如此雄壮");
        // 关云长
        Warrior guanyu = DomainObjectFactory.letUsSeeGuanyu(peopleMapper.query("关", "羽", "云长"), caocaoCamp);
        guanyu.speak("以吾关之如土鸡瓦犬尔");
        caocao.speak("麾盖之下，绣袍金甲，持刀立马者，乃颜良也");
        guanyu.speak("吾观颜良，如插标卖首耳！");
        caocao.speak("未可轻视");
        guanyu.speak("某虽不才，愿去万军中取其首级，来献丞相");
        // 颜良上线
        General yanliang = DomainObjectFactory.create(General.class, g ->
                g.setPeople(peopleMapper.query("颜", "良", "文恒"))
        );
        guanyu.kill(yanliang);
    }

}
