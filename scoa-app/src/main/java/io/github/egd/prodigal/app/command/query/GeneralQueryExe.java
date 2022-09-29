package io.github.egd.prodigal.app.command.query;

import io.github.egd.prodigal.model.domain.General;
import io.github.egd.prodigal.model.factory.DomainObjectFactory;
import io.github.egd.prodigal.repository.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneralQueryExe {

    @Autowired
    private PeopleMapper peopleMapper;

    public General queryByName(String firstName, String lastName, String styleName) {
        return DomainObjectFactory.create(General.class, g -> {
            g.setPeople(peopleMapper.query("关", "羽", "云长"));
        });
    }

}
