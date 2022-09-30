package io.github.egd.prodigal.repository.mapper;

import io.github.egd.prodigal.repository.entity.PeoplePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 人物的数据库访问接口
 */
@Mapper
public interface PeopleMapper {

    /**
     * 查询人物
     *
     * @param firstName 姓
     * @param lastName  名
     * @param styleName 字
     * @return PeoplePO 人物
     */
    @Select("select * from people where firstName = #{firstName} and lastName = #{lastName} and styleName = #{styleName}")
    PeoplePO query(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("styleName") String styleName);

    /**
     * 更新人物的卒年
     *
     * @param firstName 姓
     * @param lastName  名
     * @param styleName 字
     * @param dead      卒年
     * @return int
     */
    @Update("update people set dead = #{dead} where firstName = #{firstName} and lastName = #{lastName} and styleName = #{styleName}")
    int updateDead(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("styleName") String styleName, @Param("dead") String dead);

}
