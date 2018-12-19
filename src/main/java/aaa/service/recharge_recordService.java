package aaa.service;

import aaa.dao.customer_infoDao;
import aaa.dao.recharge_recordDao;
import aaa.entity.admin;
import aaa.entity.customer_info;
import aaa.entity.recharge_record;
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
public class recharge_recordService
{
    @Resource
    private recharge_recordDao recharge_recorddao;
    @Resource
    private adminService adminservice;
    @Resource
    private customer_infoDao customer_infodao;
    @Resource
    private set_mealService set_mealservice;
    /**
     * 添加充值记录
     * @param recharge_record
     * @return
     */
    public boolean insert_recharge_record(recharge_record recharge_record)
    {
        recharge_record.setRechargeRecordId(Encryption.getUUID());
        recharge_record.setUpdateDate(new Date());
        recharge_record.setStateId("66e75647-2b10-4553-a43d-2bb30fa33af7");
        if(0<recharge_recorddao.insert_recharge_record(recharge_record))
            return true;
        else
            return false;
    }

    /**
     * 查询所有充值记录或者根据键值和时间查询
     * @param keyValue
     * @param updateDate
     * @return
     */
    public Map<String,Object> find_recharge_recordBykeyValueorupdateDate(Integer pageIndex,Integer pageSize,String keyValue, String updateDate)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        List<recharge_record> list=recharge_recorddao.find_recharge_recordBykeyValueorupdateDate(keyValue,updateDate);
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
            List<recharge_record> recharge_record=recharge_recorddao.find_recharge_recordBykeyValueorupdateDate(keyValue,updateDate);
            for(recharge_record r:recharge_record)
            {
                r.setAdmin(adminservice.find_adminByadminId(r.getAdminId()));
                r.setCustomer_info(customer_infodao.find_customer_infoBycustomerinfoId(r.getCustomerinfoId()));
                if(null!=r&&null!=r.getSetMealId()&&!"".equals(r.getSetMealId()))
                    r.setSet_meal(set_mealservice.find_set_mealBysetMealId(r.getSetMealId()));
            }
            map.put("recharge_record",recharge_record);
            map.put("result",true);
        }
        else
            map.put("result",false);
        return map;
    }

    /**
     * 通过充值记录编号查询充值记录
     * @param rechargeRecordId
     * @return
     */
    public Map<String,Object> find_recharge_recordByrechargeRecordId(String rechargeRecordId)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        recharge_record recharge_record=recharge_recorddao.find_recharge_recordByrechargeRecordId(rechargeRecordId);
        if(null!=recharge_record)
        {
            recharge_record.setAdmin(adminservice.find_adminByadminId(recharge_record.getAdminId()));
            recharge_record.setCustomer_info(customer_infodao.find_customer_infoBycustomerinfoId(recharge_record.getCustomerinfoId()));
            if(null!=recharge_record.getSetMealId()&&!"".equals(recharge_record.getSetMealId()))
                recharge_record.setSet_meal(set_mealservice.find_set_mealBysetMealId(recharge_record.getSetMealId()));
            map.put("recharge_record",recharge_record);
            map.put("result",true);
        }
        else
            map.put("result",false);
        return map;
    }

    /**
     * 修改充值记录
     * @param rechargeRecordId
     * @param errorCause
     * @return
     */
    public boolean update_recharge_record(String rechargeRecordId,String errorCause)
    {
        recharge_record recharge_record=recharge_recorddao.find_recharge_recordByrechargeRecordId(rechargeRecordId);
        if(null!=recharge_record)
        {
            String recoverstateId=recharge_record.getStateId();
            recharge_record.setStateId("42e92020-10ad-4954-a94a-4e1f71673fda");
            recharge_record.setErrorCause(errorCause);
            String adminAccount= SecurityUtils.getSubject().getPrincipal().toString();
            admin admin=adminservice.find_adminByadminAccount(adminAccount);
            recharge_record.setAdminId(admin.getAdminId());
            recharge_record.setUpdateDate(new Date());
            if(0<recharge_recorddao.update_recharge_record(recharge_record))
            {
                customer_info customer_info=customer_infodao.find_customer_infoBycustomerinfoId(recharge_record.getCustomerinfoId());
                if(null!=customer_info)
                {
                    customer_info.setBalance(customer_info.getBalance()-recharge_record.getRechargeMoney()-recharge_record.getGivenPrice());
                    customer_info.setRechargeAmount(customer_info.getRechargeAmount()-recharge_record.getRechargeMoney());
                    if(0<customer_infodao.update_customer_info(customer_info))
                        return true;
                    else
                    {
                        recharge_record.setStateId(recoverstateId);
                        recharge_record.setErrorCause("");
                        recharge_recorddao.update_recharge_record(recharge_record);
                        return false;
                    }
                }
                else
                {
                    recharge_record.setStateId(recoverstateId);
                    recharge_record.setErrorCause("");
                    recharge_recorddao.update_recharge_record(recharge_record);
                    return false;
                }
            }
            else
                return false;
        }
        else
            return false;
    }
}
