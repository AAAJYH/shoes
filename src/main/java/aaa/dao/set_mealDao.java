package aaa.dao;

import aaa.entity.set_meal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}
