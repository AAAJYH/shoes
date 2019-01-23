package aaa.dao;

import aaa.entity.service;
import org.apache.ibatis.annotations.*;

import java.util.Date;
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

    /**
     * 查询所有服务或根据服务名称和服务金额查询
     * @param keyValue
     * @param stateId
     * @return
     */
    @Select({"<script>select * from service where 1=1 <if test=\"null!=stateId and ''!=stateId\">and stateId=#{stateId}</if> <if test=\"null!=keyValue and ''!=keyValue\">and (serviceName like concat('%',#{keyValue},'%') or servicePrice like concat('%',#{keyValue},'%'))</if> order by updateDate desc</script>"})
    public List<service> find_serviceBykeyValueOrstateId(@Param("keyValue")String keyValue,@Param("stateId")String stateId);

    /**
     * 根据服务编号修改服务状态
     * @param serviceIds
     * @param stateId
     * @param adminId
     * @param updateDate
     * @return
     */
    @Update({"<script>update service set stateId=#{stateId},adminId=#{adminId},updateDate=#{updateDate} where serviceId in <foreach collection='serviceIds' item='serviceId' open='(' separator=',' close=')'>#{serviceId}</foreach></script>"})
    public Integer update_service_stateIdByserviceIds(@Param("serviceIds")String[]serviceIds, @Param("stateId")String stateId, @Param("adminId")String adminId, @Param("updateDate")Date updateDate);

    /**
     * 添加服务
     * @param service
     * @return
     */
    @Insert("insert into service values(#{serviceId},#{serviceName},#{servicePrice},#{adminId},#{updateDate},#{stateId})")
    public Integer insert_service(service service);

    /**
     * 修改服务
     * @param service
     * @return
     */
    @Update({"<script>update service set serviceId=serviceId<if test=\"null!=serviceName and ''!=serviceName\">,serviceName=#{serviceName}</if><if test=\"null!=servicePrice and ''!=servicePrice\">,servicePrice=#{servicePrice}</if><if test=\"null!=adminId and ''!=adminId\">,adminId=#{adminId}</if><if test=\"null!=updateDate\">,updateDate=#{updateDate}</if><if test=\"null!=stateId and ''!=stateId\">,stateId=#{stateId}</if> where serviceId=#{serviceId}</script>"})
    public Integer update_service(service service);
}
