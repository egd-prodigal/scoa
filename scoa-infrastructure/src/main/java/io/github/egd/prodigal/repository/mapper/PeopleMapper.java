package io.github.egd.prodigal.repository.mapper;

import io.github.egd.prodigal.repository.entity.PeoplePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PeopleMapper {

    @Select("select * from people where firstName = #{firstName} and lastName = #{lastName} and styleName = #{styleName}")
    PeoplePO query(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("styleName") String styleName);

    @Update("update people set dead = #{dead} where firstName = #{firstName} and lastName = #{lastName} and styleName = #{styleName}")
    int updateDead(@Param("firstName") String firstName, @Param("lastName") String lastName,
                   @Param("styleName") String styleName, @Param("dead") String dead);

}
