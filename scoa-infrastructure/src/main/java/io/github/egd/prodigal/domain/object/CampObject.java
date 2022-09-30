package io.github.egd.prodigal.domain.object;

import io.github.egd.prodigal.model.domain.Camp;
import io.github.egd.prodigal.model.domain.General;
import io.github.egd.prodigal.repository.entity.CampPO;
import io.github.egd.prodigal.repository.entity.PeoplePO;
import io.github.egd.prodigal.repository.mapper.CampMapper;
import io.github.egd.prodigal.repository.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 阵营领域对象
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CampObject extends Camp {

    @Autowired
    private CampMapper campMapper;

    @Autowired
    private PeopleMapper peopleMapper;

    /**
     * 查看阵营的将领们
     *
     * @return java.util.List
     */
    @Override
    public List<General> getGenerals() {
        if (super.generals == null) {
            List<CampPO> campPOS = campMapper.queryCampGenerals(getLord());
            setGenerals(campPOS.stream().map(camp -> {
                General general = new GeneralObject();
                PeoplePO peoplePO = peopleMapper.query(camp.getFirstName(), camp.getLastName(), camp.getStyleName());
                general.setPeople(peoplePO);
                general.setCamp(this);
                return general;
            }).collect(Collectors.toList()));
        }
        return super.generals;
    }

}
