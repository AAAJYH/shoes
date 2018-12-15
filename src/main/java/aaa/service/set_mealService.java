package aaa.service;

import aaa.dao.adminDao;
import aaa.dao.set_mealDao;
import aaa.entity.admin;
import aaa.entity.customer_info;
import aaa.entity.set_meal;
import aaa.util.Encryption;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class set_mealService
{
    @Resource
    private set_mealDao set_mealdao;
    @Resource
    private adminService adminservice;
    /**
     * 通过套餐金额和状态编号倒序查询最大金额
     * @param stateId
     * @return
     */
    public Map<String,Object> find_set_mealBysetMealPriceOrderdescAndStateId(String stateId)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        PageHelper.startPage(1,1);
        set_meal set_meal=set_mealdao.find_set_mealBysetMealPriceOrderdescAndStateId(stateId);
        if(null!=set_meal)
        {
            map.put("set_meal",set_meal);
            map.put("result",true);
        }
        else
            map.put("result",false);
        return map;
    }

    /**
     * 通过充值金额小于等于套餐金额和状态获取套餐
     * @param setMealPrice
     * @param stateId
     * @return
     */
    public set_meal find_set_mealBysetMealPricelessoreqAndstateIdOrderdesc(double setMealPrice,String stateId)
    {
        PageHelper.startPage(1,1);
        return set_mealdao.find_set_mealBysetMealPricelessoreqAndstateIdOrderdesc(setMealPrice,stateId);
    }

    /**
     * 通过套餐编号获取套餐
     * @param setMealId
     * @return
     */
    public set_meal find_set_mealBysetMealId(String setMealId)
    {
        return set_mealdao.find_set_mealBysetMealId(setMealId);
    }
}
