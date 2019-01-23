package aaa.dao;

import aaa.entity.set_meal;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface set_mealDao
{
    /**
     * 通过套餐金额和状态编号倒序查询
     * @param stateId
     * @return
     */
    @Select("select * from set_meal where stateId=#{stateId} order by setMealPrice desc")
    public set_meal find_set_mealBysetMealPriceOrderdescAndStateId(@Param("stateId") String stateId);

    /**
     * 通过充值金额小于等于套餐金额和状态获取套餐
     * @param setMealPrice
     * @param stateId
     * @return
     */
    @Select("select * from set_meal where setMealPrice<=#{setMealPrice} and stateId=#{stateId} order by setMealPrice desc")
    public set_meal find_set_mealBysetMealPricelessoreqAndstateIdOrderdesc(@Param("setMealPrice")double setMealPrice,@Param("stateId") String stateId);

    /**
     * 通过套餐编号获取套餐
     * @param setMealId
     * @return
     */
    @Select("select * from set_meal where setMealId=#{setMealId}")
    public set_meal find_set_mealBysetMealId(@Param("setMealId")String setMealId);

    /**
     * 查询所有套餐或根据键值和状态查询
     * @param keyValue
     * @param stateId
     * @return
     */
    @Select({"<script>select * from set_meal where 1=1 <if test=\"null!=stateId and ''!=stateId\">and stateId=#{stateId}</if> <if test=\"null!=keyValue and ''!=keyValue\">and (setMealName like concat('%',#{keyValue},'%') or setMealPrice like concat('%',#{keyValue},'%'))</if> order by updateDate desc</script>"})
    public List<set_meal> find_set_mealBykeyValueOrstateId(@Param("keyValue")String keyValue,@Param("stateId")String stateId);

    /**
     * 根据套餐编号修改状态
     * @param setMealIds
     * @param stateId
     * @param adminId
     * @param updateDate
     * @return
     */
    @Update({"<script>update set_meal set stateId=#{stateId},adminId=#{adminId},updateDate=#{updateDate} where setMealId in <foreach collection='setMealIds' item='setMealId' open='(' separator=',' close=')'>#{setMealId}</foreach></script>"})
    public Integer update_set_meal_stateIdBysetMealIds(@Param("setMealIds")String[]setMealIds, @Param("stateId")String stateId, @Param("adminId")String adminId, @Param("updateDate")Date updateDate);

    /**
     * 新增套餐
     * @param set_meal
     * @return
     */
    @Insert("insert into set_meal values(#{setMealId},#{setMealName},#{setMealPrice},#{givenPrice},#{adminId},#{updateDate},#{stateId})")
    public Integer insert_set_meal(set_meal set_meal);

    /**
     * 修改套餐
     * @param set_meal
     * @return
     */
    @Update({"<script>update set_meal set setMealId=setMealId<if test=\"null!=setMealName and ''!=setMealName\">,setMealName=#{setMealName}</if><if test=\"null!=setMealPrice and ''!=setMealPrice\">,setMealPrice=#{setMealPrice}</if><if test=\"null!=givenPrice and ''!=givenPrice\">,givenPrice=#{givenPrice}</if><if test=\"null!=adminId and ''!=adminId\">,adminId=#{adminId}</if><if test=\"null!=updateDate\">,updateDate=#{updateDate}</if><if test=\"null!=stateId and ''!=stateId\">,stateId=#{stateId}</if> where setMealId=#{setMealId}</script>"})
    public Integer update_set_meal(set_meal set_meal);
}
