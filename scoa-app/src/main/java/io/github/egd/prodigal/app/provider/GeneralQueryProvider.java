package io.github.egd.prodigal.app.provider;

import io.github.egd.prodigal.app.command.query.GeneralQueryExe;
import io.github.egd.prodigal.client.api.GeneralQueryClient;
import io.github.egd.prodigal.client.dto.GeneralInfoDTO;
import io.github.egd.prodigal.model.domain.General;
import io.github.egd.prodigal.model.domain.People;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 将领信息查询客户端实现
 */
public class GeneralQueryProvider implements GeneralQueryClient {
    @Autowired
    private GeneralQueryExe generalQueryExe;

    /**
     * 查询将领信息
     *
     * @param firstName 姓
     * @param lastName  名
     * @param styleName 字
     * @return 将领
     */
    @Override
    public GeneralInfoDTO queryGeneral(String firstName, String lastName, String styleName) {
        General general = generalQueryExe.queryByName(firstName, lastName, styleName);
        GeneralInfoDTO dto = new GeneralInfoDTO();
        dto.setName(general.getFirstName() + general.getLastName());
        dto.setBirthAndDead("生于" + (People.BIRTH_DEAD_NOT_RECORD.equals(general.getBirth()) ? "不详" : general.getBirth())
                + "卒于" + general.getDead());
        return dto;
    }

}
