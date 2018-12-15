package aaa.dao;

import aaa.entity.customer_info;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface customer_infoDao
{
    /**
     * 添加客户信息
     * @param customer_info
     * @return
     */
    @Insert("insert into customer_info values(#{customerinfoId},#{customerinfoName},#{phone},#{rechargeAmount},#{balance},#{adminId},#{updateDate})")
    public Integer insert_customer_info(customer_info customer_info);

    /**
     * 通过手机号查询客户
     * @param phone
     * @return
     */
    @Select("select * from customer_info where phone=#{phone}")
    public customer_info find_customer_infoByphone(@Param("phone")String phone);

    /**
     * 通过键输入,查询手机号符合或姓名符合的客户信息
     * @param keyValue
     * @return
     */
    @Select({"<script>select * from customer_info <if test=\"null!=keyValue and ''!=keyValue\">where phone like concat('%',#{keyValue},'%') or customerinfoName like concat('%',#{keyValue},'%')</if> order by updateDate desc</script>"})
    public List<customer_info> find_customer_infoByphoneAndcustomerinfoNamelike(@Param("keyValue")String keyValue);

    /**
     * 通过客户编号查询客户
     * @param customerinfoId
     * @return
     */
    @Select("select * from customer_info where customerinfoId=#{customerinfoId}")
    public customer_info find_customer_infoBycustomerinfoId(@Param("customerinfoId")String customerinfoId);

    /**
     * 修改客户
     * @param customer_info
     * @return
     */
    @Update({"<script>update customer_info set customerinfoId=customerinfoId<if test=\"null!=customerinfoName and ''!=customerinfoName\">,customerinfoName=#{customerinfoName}</if><if test=\"null!=phone and ''!=phone\">,phone=#{phone}</if><if test=\"null!=rechargeAmount and ''!=rechargeAmount\">,rechargeAmount=#{rechargeAmount}</if><if test=\"null!=balance and ''!=balance\">,balance=#{balance}</if><if test=\"null!=adminId and ''!=adminId\">,adminId=#{adminId}</if><if test=\"null!=updateDate\">,updateDate=#{updateDate} where customerinfoId=#{customerinfoId}</if></script>"})
    public Integer update_customer_info(customer_info customer_info);
}
