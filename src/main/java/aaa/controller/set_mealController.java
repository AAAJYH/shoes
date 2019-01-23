package aaa.controller;

import aaa.entity.set_meal;
import aaa.service.set_mealService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("set_mealController")
public class set_mealController
{
    @Resource
    private set_mealService set_mealservice;
    /**
     * 通过套餐金额和状态编号倒序查询最大金额
     * @return
     */
    @ResponseBody
    @RequestMapping("find_set_mealBysetMealPriceOrderdescAndStateId")
    public Map<String,Object> find_set_mealBysetMealPriceOrderdescAndStateId()
    {
        return set_mealservice.find_set_mealBysetMealPriceOrderdescAndStateId("66e75647-2b10-4553-a43d-2bb30fa33af7");
    }
    /**
     * 查询所有套餐或根据键值和状态查询
     * @param pageIndex
     * @param keyValue
     * @return
     */
    @ResponseBody
    @RequestMapping("find_set_mealBykeyValueOrstateId")
    public Map<String,Object> find_set_mealBykeyValueOrstateId(Integer pageIndex,String keyValue,String stateId)
    {
        return set_mealservice.find_set_mealBykeyValueOrstateId(pageIndex,10,keyValue,stateId);
    }
    /**
     * 根据套餐编号恢复套餐
     * @param setMealIds
     * @return
     */
    @ResponseBody
    @RequestMapping("recover_set_meal")
    public boolean recover_set_meal(String [] setMealIds)
    {
        return set_mealservice.update_set_meal_stateIdBysetMealIds(setMealIds,"66e75647-2b10-4553-a43d-2bb30fa33af7");
    }

    /**
     * 根据套餐编号恢复套餐
     * @param setMealIds
     * @return
     */
    @ResponseBody
    @RequestMapping("delete_set_meal")
    public boolean delete_set_meal(String [] setMealIds)
    {
        return set_mealservice.update_set_meal_stateIdBysetMealIds(setMealIds,"42e92020-10ad-4954-a94a-4e1f71673fda");
    }

    /**
     * 新增套餐
     * @param setMealName
     * @param setMealPrice
     * @param givenPrice
     * @return
     */
    @ResponseBody
    @RequestMapping("insert_set_meal")
    public boolean insert_set_meal(String setMealName,double setMealPrice,double givenPrice)
    {
        return set_mealservice.insert_set_meal(setMealName,setMealPrice,givenPrice);
    }

    /**
     * 修改套餐
     * @param setMealId
     * @param setMealName
     * @param setMealPrice
     * @param givenPrice
     * @return
     */
    @ResponseBody
    @RequestMapping("update_set_meal")
    public boolean update_set_meal(String setMealId,String setMealName,double setMealPrice,double givenPrice)
    {
        return set_mealservice.update_set_meal(setMealId,setMealName,setMealPrice,givenPrice);
    }

    /**
     * 根据套餐编号查询
     * @param setMealId
     * @return
     */
    @ResponseBody
    @RequestMapping("find_set_mealBysetMealId")
    public Map<String,Object> find_set_mealBysetMealId(String setMealId)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        set_meal set_meal=set_mealservice.find_set_mealBysetMealId(setMealId);
        if(null!=set_meal)
        {
            map.put("result",true);
            map.put("set_meal",set_meal);
        }
        else
            map.put("result",false);
        return map;
    }
}
