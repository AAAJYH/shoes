package aaa.dao;

import aaa.entity.state;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * state表数据库访问层
 */
@Mapper
public interface stateDao {

    /**
     * 查询全部状态
     * @return
     */
    @Select("select * from state")
    public List<state> queryAll();

    /**
     * 通过状态编号查询
     * @param stateId
     * @return
     */
    @Select("select * from state where stateId=#{stateId}")
    public state find_stateBystateId(@Param("stateId") String stateId);
}
