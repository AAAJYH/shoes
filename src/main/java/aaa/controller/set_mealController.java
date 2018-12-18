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

}
