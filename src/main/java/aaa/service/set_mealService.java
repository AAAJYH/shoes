package aaa.service;

import aaa.dao.adminDao;
import aaa.dao.set_mealDao;
import aaa.entity.admin;
import aaa.entity.customer_info;
import aaa.entity.set_meal;
import aaa.util.Encryption;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.SecurityUtils;
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

    /**
     * 查询所有套餐或根据键值和状态查询
     * @param pageIndex
     * @param pageSize
     * @param keyValue
     * @param stateId
     * @return
     */
    public Map<String,Object> find_set_mealBykeyValueOrstateId(Integer pageIndex,Integer pageSize,String keyValue,String stateId)
    {
        Map<String,Object> map=new HashMap<>();
        List<set_meal> list=set_mealdao.find_set_mealBykeyValueOrstateId(keyValue,stateId);
        if(null!=list&&0<list.size())
        {
            Integer size=list.size();
            map.put("size",size);
            Integer pageCount=0;
            if(0<size%pageSize)
                pageCount=size/pageSize+1;
            else
                pageCount=size/pageSize;
            map.put("pageCount",pageCount);
            map.put("currentIndex",pageIndex);
            PageHelper.startPage(pageIndex,pageSize);
            List<set_meal> set_meal=set_mealdao.find_set_mealBykeyValueOrstateId(keyValue,stateId);
            for(set_meal s:set_meal)
                s.setAdmin(adminservice.find_adminByadminId(s.getAdminId()));
            map.put("set_meal",set_meal);
            map.put("result",true);
        }
        else
            map.put("result",false);
        return map;
    }
    /**
     * 根据套餐编号修改状态
     * @param setMealIds
     * @param stateId
     * @return
     */
    public boolean update_set_meal_stateIdBysetMealIds(String[]setMealIds,String stateId)
    {
        String adminAccount= SecurityUtils.getSubject().getPrincipal().toString();
        admin admin=adminservice.find_adminByadminAccount(adminAccount);
        if(0<set_mealdao.update_set_meal_stateIdBysetMealIds(setMealIds,stateId,admin.getAdminId(),new Date()))
            return true;
        else
            return false;
    }

    /**
     * 新增套餐
     * @param setMealName
     * @param setMealPrice
     * @param givenPrice
     * @return
     */
    public boolean insert_set_meal(String setMealName,double setMealPrice,double givenPrice)
    {
        set_meal set_meal=new set_meal();
        set_meal.setSetMealId(Encryption.getUUID());
        set_meal.setSetMealName(setMealName);
        set_meal.setSetMealPrice(setMealPrice);
        set_meal.setGivenPrice(givenPrice);
        String adminAccount= SecurityUtils.getSubject().getPrincipal().toString();
        admin admin=adminservice.find_adminByadminAccount(adminAccount);
        set_meal.setAdminId(admin.getAdminId());
        set_meal.setUpdateDate(new Date());
        set_meal.setStateId("66e75647-2b10-4553-a43d-2bb30fa33af7");
        if(0<set_mealdao.insert_set_meal(set_meal))
            return true;
        else
            return false;
    }

    /**
     * 修改套餐
     * @param setMealName
     * @param setMealPrice
     * @param givenPrice
     * @return
     */
    public boolean update_set_meal(String setMealId,String setMealName,double setMealPrice,double givenPrice)
    {
        set_meal set_meal=new set_meal();
        set_meal.setSetMealId(setMealId);
        set_meal.setSetMealName(setMealName);
        set_meal.setSetMealPrice(setMealPrice);
        set_meal.setGivenPrice(givenPrice);
        String adminAccount= SecurityUtils.getSubject().getPrincipal().toString();
        admin admin=adminservice.find_adminByadminAccount(adminAccount);
        set_meal.setAdminId(admin.getAdminId());
        set_meal.setUpdateDate(new Date());
        if(0<set_mealdao.update_set_meal(set_meal))
            return true;
        else
            return false;
    }
}
