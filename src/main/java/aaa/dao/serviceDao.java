package aaa.dao;

import aaa.entity.service;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface serviceDao
{
    /**
     * 查询全部服务或根据状态编号查询服务
     * @param stateId
     * @return
     */
    @Select({"<script>select * from service <if test=\"null!=stateId and ''!=stateId\">where stateId=#{stateId}</if></script>"})
    public List<service> find_service(@Param("stateId")String stateId);

    /**
     * 通过服务编号查询服务
     * @param serviceId
     * @return
     */
    @Select("select * from service where serviceId=#{serviceId}")
    public service find_serviceByserviceId(@Param("serviceId")String serviceId);
}
