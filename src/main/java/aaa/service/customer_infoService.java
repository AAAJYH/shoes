package aaa.service;

import aaa.dao.customer_infoDao;
import aaa.entity.*;
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
public class customer_infoService
{
    @Resource
    private set_mealService set_mealservice;
    @Resource
    private customer_infoDao customer_infodao;
    @Resource
    private recharge_recordService recharge_recordservice;
    @Resource
    private adminService adminservice;
    @Resource
    private serviceService serviceservice;
    @Resource
    private expense_recordService expense_recordservice;
    /**
     * 新增客户信息
     * @param customerinfoName 客户名称
     * @param phone 手机号
     * @param rechargeAmount 充值金额
     * @return
     */
    public boolean insert_customer_info(String customerinfoName,String phone,double rechargeAmount)
    {
        customer_info customer_info=new customer_info();
        customer_info.setCustomerinfoId(Encryption.getUUID());
        String adminAccount=SecurityUtils.getSubject().getPrincipal().toString();
        admin admin=adminservice.find_adminByadminAccount(adminAccount);
        customer_info.setAdminId(admin.getAdminId());
        customer_info.setCustomerinfoName(customerinfoName);
        customer_info.setPhone(phone);
        customer_info.setRechargeAmount(rechargeAmount);
        set_meal set_meal=set_mealservice.find_set_mealBysetMealPricelessoreqAndstateIdOrderdesc(rechargeAmount,"66e75647-2b10-4553-a43d-2bb30fa33af7");
        if(null!=set_meal)
            customer_info.setBalance(rechargeAmount+set_meal.getGivenPrice());
        else
            customer_info.setBalance(rechargeAmount);
        customer_info.setUpdateDate(new Date());
        if(0<customer_infodao.insert_customer_info(customer_info))
        {
            recharge_record recharge_record=new recharge_record();
            recharge_record.setAdminId(customer_info.getAdminId());
            recharge_record.setCustomerinfoId(customer_info.getCustomerinfoId());
            recharge_record.setRechargeMoney(rechargeAmount);
            if(null!=set_meal)
            {
                recharge_record.setSetMealId(set_meal.getSetMealId());
                recharge_record.setSetMealPrice(set_meal.getSetMealPrice());
                recharge_record.setGivenPrice(set_meal.getGivenPrice());
            }
            if(recharge_recordservice.insert_recharge_record(recharge_record))
                return true;
            else
                return false;
        }
        else
            return  false;
    }

    /**
     * 通过手机号查询客户
     * @param phone
     * @return
     */
    public Map<String,Object> find_customer_infoByphone(String phone)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        customer_info customer_info=customer_infodao.find_customer_infoByphone(phone);
        if(null!=customer_info)
        {
            map.put("result",true);
            map.put("customer_info",customer_info);
        }
        else
            map.put("result",false);
        return map;
    }

    /**
     * 通过键输入,查询手机号符合或姓名符合的客户信息
     * @param pageIndex 第几页
     * @param pageSize 每页显示条数
     * @param keyValue 键值
     * @return
     */
    public Map<String,Object> find_customer_infoByphoneAndcustomerinfoNamelike(Integer pageIndex,Integer pageSize,String keyValue)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        List<customer_info> customer_infocount=customer_infodao.find_customer_infoByphoneAndcustomerinfoNamelike(keyValue);
        PageHelper.startPage(pageIndex,pageSize);
        List<customer_info> customer_infos=customer_infodao.find_customer_infoByphoneAndcustomerinfoNamelike(keyValue);
        map.put("currentIndex",pageIndex);
        if(null!=customer_infos&&0<customer_infos.size())
        {
            for (customer_info c:customer_infos)
                c.setAdmin(adminservice.find_adminByadminId(c.getAdminId()));
            map.put("customer_infos",customer_infos);
            map.put("result",true);
            Integer size=customer_infocount.size();
            Integer pageCount=0;
            if(size%pageSize>0)
                pageCount=size/pageSize+1;
            else
                pageCount=size/pageSize;
            map.put("pageCount",pageCount);
            map.put("size",size);
        }
        else
            map.put("result",false);
        return  map;
    }

    /**
     * 通过客户编号查询客户
     * @param customerinfoId
     * @return
     */
    public Map<String,Object> find_customer_infoBycustomerinfoId(String customerinfoId)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        customer_info customer_info=customer_infodao.find_customer_infoBycustomerinfoId(customerinfoId);
        if(null!=customer_info)
        {
            map.put("result",true);
            map.put("customer_info",customer_info);
        }
        else
            map.put("result",false);
        return map;
    }

    /**
     * 修改客户
     * @param customer_info
     * @return
     */
    public boolean update_customer_info(customer_info customer_info)
    {
        customer_info.setUpdateDate(new Date());
        if(0<customer_infodao.update_customer_info(customer_info))
            return true;
        else
            return false;
    }

    /**
     * 充值,并添加充值记录
     * @param customerinfoId
     * @param rechargeAmount
     * @return
     */
    public boolean update_customer_info_rechargeAmountAndbalanceBycustomerinfoId(String customerinfoId,double rechargeAmount)
    {
        customer_info customer_info=customer_infodao.find_customer_infoBycustomerinfoId(customerinfoId);
        if(null!=customer_info)
        {
            set_meal set_meal=set_mealservice.find_set_mealBysetMealPricelessoreqAndstateIdOrderdesc(rechargeAmount,"66e75647-2b10-4553-a43d-2bb30fa33af7");
            if(null!=set_meal)
                customer_info.setBalance(customer_info.getBalance()+rechargeAmount+set_meal.getGivenPrice());
            else
                customer_info.setBalance(customer_info.getBalance()+rechargeAmount);
            customer_info.setRechargeAmount(customer_info.getRechargeAmount()+rechargeAmount);
            if(update_customer_info(customer_info))//如果修改客户充值金额和剩余金额成功,新增充值记录
            {
                recharge_record recharge_record=new recharge_record();
                recharge_record.setCustomerinfoId(customer_info.getCustomerinfoId());
                String adminAccount= SecurityUtils.getSubject().getPrincipal().toString();
                admin admin=adminservice.find_adminByadminAccount(adminAccount);
                recharge_record.setAdminId(admin.getAdminId());
                recharge_record.setRechargeMoney(rechargeAmount);
                if(null!=set_meal)
                {
                    recharge_record.setSetMealId(set_meal.getSetMealId());
                    recharge_record.setSetMealPrice(set_meal.getSetMealPrice());
                    recharge_record.setGivenPrice(set_meal.getGivenPrice());
                }
                if(recharge_recordservice.insert_recharge_record(recharge_record))
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        else
            return false;
    }

    /**
     * 修改客户剩余金额,并新增消费记录
     * @param customerinfoId
     * @param serviceId
     * @return
     */
    public boolean update_customer_info_balance_expense_record(String customerinfoId,String serviceId)
    {
        service service=serviceservice.find_serviceByserviceId(serviceId);
        if(null!=service)
        {
            customer_info customer_info=customer_infodao.find_customer_infoBycustomerinfoId(customerinfoId);
            if(null!=customer_info)
            {
                customer_info.setCustomerinfoId(customerinfoId);
                customer_info.setUpdateDate(new Date());
                customer_info.setBalance(customer_info.getBalance()-service.getServicePrice());
                if(0<customer_infodao.update_customer_info(customer_info))
                {
                    expense_record expense_record=new expense_record();
                    String adminAccount=SecurityUtils.getSubject().getPrincipal().toString();
                    admin admin=adminservice.find_adminByadminAccount(adminAccount);
                    expense_record.setAdminId(admin.getAdminId());
                    expense_record.setServiceId(serviceId);
                    expense_record.setServiceName(service.getServiceName());
                    expense_record.setServicePrice(service.getServicePrice());
                    expense_record.setExpenseMoney(service.getServicePrice());
                    expense_record.setCustomerinfoId(customerinfoId);
                    if(expense_recordservice.insert_expense_record(expense_record))
                        return true;
                    else
                        return false;
                }
                else
                    return false;
            }
            else
                return false;
        }
        else
            return false;
    }
}
