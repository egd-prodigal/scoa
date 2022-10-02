package io.github.egd.prodigal.test.domain.object;

import io.github.egd.prodigal.model.domain.Camp;
import io.github.egd.prodigal.model.domain.General;
import io.github.egd.prodigal.model.domain.People;
import io.github.egd.prodigal.model.domain.Warrior;
import io.github.egd.prodigal.model.factory.DomainObjectFactory;
import io.github.egd.prodigal.repository.entity.PeoplePO;
import io.github.egd.prodigal.test.starter.ScoaInfrastructureTestStarter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ScoaInfrastructureTestStarter.class)
@RunWith(SpringRunner.class)
public class GeneralObjectTest {

    @Test
    public void kill() {
        People people = new PeoplePO();
        people.setFirstName("关");
        people.setLastName("羽");
        people.setStyleName("云长");
        Camp camp = DomainObjectFactory.create(Camp.class);
        Warrior guanyu = DomainObjectFactory.letUsSeeGuanyu(people, camp);
        General yanliang = DomainObjectFactory.create(General.class, g -> {
            PeoplePO yanliangPeople = new PeoplePO();
            yanliangPeople.setFirstName("颜");
            yanliangPeople.setLastName("良");
            yanliangPeople.setStyleName("文恒");
            g.setPeople(yanliangPeople);
        });
        guanyu.kill(yanliang);
    }

}
