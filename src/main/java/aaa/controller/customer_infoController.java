package aaa.controller;

import aaa.service.customer_infoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("customer_infoController")
public class customer_infoController
{
    @Resource
    private customer_infoService customer_infoservice;
    /**
     * 新增客户信息
     * @param customerinfoName
     * @param phone
     * @param rechargeAmount
     * @return
     */
    @ResponseBody
    @RequestMapping("insert_customer_info")
    public boolean insert_customer_info(String customerinfoName,String phone,double rechargeAmount)
    {
        return customer_infoservice.insert_customer_info(customerinfoName,phone,rechargeAmount);
    }

    /**
     * 通过手机号查询客户
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping("find_customer_infoByphone")
    public Map<String,Object> find_customer_infoByphone(String phone)
    {
        return customer_infoservice.find_customer_infoByphone(phone);
    }

    /**
     * 通过键输入,查询手机号符合或姓名符合的客户信息
     * @param pageIndex 第几页
     * @param keyValue 键值
     * @return
     */
    @ResponseBody
    @RequestMapping("find_customer_infoByphoneAndcustomerinfoNamelike")
    public Map<String,Object> find_customer_infoByphoneAndcustomerinfoNamelike(Integer pageIndex,String keyValue)
    {
        return customer_infoservice.find_customer_infoByphoneAndcustomerinfoNamelike(pageIndex,10,keyValue);
    }
    /**
     * 通过客户编号查询客户
     * @param customerinfoId
     * @return
     */
    @ResponseBody
    @RequestMapping("find_customer_infoBycustomerinfoId")
    public Map<String,Object> find_customer_infoBycustomerinfoId(String customerinfoId)
    {
        return customer_infoservice.find_customer_infoBycustomerinfoId(customerinfoId);
    }

    /**
     * 充值,并添加充值记录
     * @param customerinfoId
     * @param rechargeAmount
     * @return
     */
    @ResponseBody
    @RequestMapping("update_customer_info_rechargeAmountAndbalanceBycustomerinfoId")
    public boolean update_customer_info_rechargeAmountAndbalanceBycustomerinfoId(String customerinfoId,double rechargeAmount)
    {
        return customer_infoservice.update_customer_info_rechargeAmountAndbalanceBycustomerinfoId(customerinfoId,rechargeAmount);
    }

    /**
     * 修改客户剩余金额,并新增消费记录
     * @param customerinfoId
     * @param serviceId
     * @return
     */
    @ResponseBody
    @RequestMapping("update_customer_info_balance_expense_record")
    public boolean update_customer_info_balance_expense_record(String customerinfoId,String serviceId)
    {
        return  customer_infoservice.update_customer_info_balance_expense_record(customerinfoId,serviceId);
    }
}
