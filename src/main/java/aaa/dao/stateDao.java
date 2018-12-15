package aaa.dao;

import aaa.entity.state;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface stateDao
{
    /**
     * 通过状态编号查询
     * @param stateId
     * @return
     */
    @Select("select * from state where stateId=#{stateId}")
    public state find_stateBystateId(@Param("stateId") String stateId);
}
