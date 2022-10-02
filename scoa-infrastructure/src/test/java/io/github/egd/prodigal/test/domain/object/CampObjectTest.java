package io.github.egd.prodigal.test.domain.object;

import io.github.egd.prodigal.model.domain.Camp;
import io.github.egd.prodigal.model.domain.General;
import io.github.egd.prodigal.model.domain.Lord;
import io.github.egd.prodigal.model.factory.DomainObjectFactory;
import io.github.egd.prodigal.repository.entity.PeoplePO;
import io.github.egd.prodigal.test.starter.ScoaInfrastructureTestStarter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest(classes = ScoaInfrastructureTestStarter.class)
@RunWith(SpringRunner.class)
public class CampObjectTest {

    @Test
    public void generals() {
        PeoplePO people = new PeoplePO();
        people.setFirstName("曹");
        people.setLastName("操");
        Lord lord = Lord.fromPeople(people);
        Camp camp = DomainObjectFactory.create(Camp.class);
        camp.setLord(lord);
        List<General> generals = camp.getGenerals();
        Assert.notEmpty(generals, "generals is empty");
    }

}
