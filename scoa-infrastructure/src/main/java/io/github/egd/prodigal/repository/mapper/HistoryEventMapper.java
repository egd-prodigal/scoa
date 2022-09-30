package io.github.egd.prodigal.repository.mapper;

import io.github.egd.prodigal.repository.entity.HistoryEventPO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 历史事件数据库访问接口
 */
@Mapper
public interface HistoryEventMapper {

    /**
     * 记载历史
     *
     * @param po 历史事件对象
     * @return int
     */
    @Insert("insert into history (reign_title, history) values (#{reignTitle}, #{history})")
    int insert(HistoryEventPO po);

    /**
     * 删除全部记载
     *
     * @return int
     */
    @Delete("delete from history")
    int deleteAll();

    /**
     * 查询一条历史事件
     *
     * @return HistoryEventPO
     */
    @Select("select reign_title reignTitle, history history from history where rownum = 1")
    HistoryEventPO query();

}
