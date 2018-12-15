package aaa.dao;

import aaa.entity.recharge_record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface recharge_recordDao
{
    /**
     * 添加充值记录
     * @param recharge_record
     * @return
     */
    @Insert({"<script>insert into recharge_record(rechargeRecordId,customerinfoId<if test=\"null!=setMealId and ''!=setMealId\">,setMealId</if>,setMealPrice,givenPrice,rechargeMoney,adminId,updateDate) values(#{rechargeRecordId},#{customerinfoId}<if test=\"null!=setMealId and ''!=setMealId\">,#{setMealId}</if><choose><when test=\"null!=setMealPrice and ''!=setMealPrice\">,#{setMealPrice}</when><otherwise>,0</otherwise></choose><choose><when test=\"null!=givenPrice and ''!=givenPrice\">,#{givenPrice}</when><otherwise>,0</otherwise></choose>,#{rechargeMoney},#{adminId},#{updateDate})</script>"})
    public Integer insert_recharge_record(recharge_record recharge_record);

    /**
     * 查询所有充值记录或者根据键值和时间查询
     * @param keyValue
     * @param updateDate
     * @return
     */
    @Select({"<script>select r.* from recharge_record as r inner join customer_info c on r.customerinfoId=c.customerinfoId where 1=1 <if test=\"null!=updateDate and ''!=updateDate\"> and r.updateDate like concat('%',#{updateDate},'%')</if><if test=\"null!=keyValue and ''!=keyValue\"> and (c.customerinfoName like concat('%',#{keyValue},'%') or c.phone like concat('%',#{keyValue},'%'))</if> order by r.updateDate desc</script>"})
    public List<recharge_record> find_recharge_recordBykeyValueorupdateDate(@Param("keyValue") String keyValue,@Param("updateDate") String updateDate);
}
