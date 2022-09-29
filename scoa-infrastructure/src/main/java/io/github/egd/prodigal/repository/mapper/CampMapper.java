package io.github.egd.prodigal.repository.mapper;

import io.github.egd.prodigal.model.domain.People;
import io.github.egd.prodigal.repository.entity.CampPO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CampMapper {

    @Select("select * from camp where lord = #{firstName} || #{lastName}")
    List<CampPO> queryCampGenerals(People lord);

    @Delete("delete from camp where firstName = #{firstName} and lastName = #{lastName} and styleName = #{styleName}")
    int deadCampGenerals(People general);

}
