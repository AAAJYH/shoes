package aaa.service;

import aaa.dao.adminDao;
import aaa.dao.customer_infoDao;
import aaa.dao.expense_recordDao;
import aaa.entity.admin;
import aaa.entity.customer_info;
import aaa.entity.expense_record;
import aaa.entity.service;
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
public class expense_recordService
{
    @Resource
    private expense_recordDao expense_recorddao;
    @Resource
    private customer_infoDao customer_infodao;
    @Resource
    private adminService adminservice;
    @Resource
    private adminDao admindao;
    /**
     * 添加消费记录
     * @param expense_record
     * @return
     */
    public boolean insert_expense_record(expense_record expense_record)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        expense_record.setExpenseRecordId(Encryption.getUUID());
        expense_record.setUpdateDate(new Date());
        expense_record.setStateId("66e75647-2b10-4553-a43d-2bb30fa33af7");
        if(0<expense_recorddao.insert_expense_record(expense_record))
            return true;
        else
            return false;
    }

    /**
     * 查询所有消费记录或根据键值和时间查询
     * @param keyValue
     * @param updateDate
     * @return
     */
    public Map<String,Object> find_expense_recordBykeyValueorupdateDate(Integer pageIndex,Integer pageSize,String keyValue,String updateDate)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        List<expense_record> list=expense_recorddao.find_expense_recordBykeyValueorupdateDate(keyValue,updateDate);
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
            List<expense_record>expense_record=expense_recorddao.find_expense_recordBykeyValueorupdateDate(keyValue,updateDate);
            for(expense_record e:expense_record)
            {
                e.setCustomer_info(customer_infodao.find_customer_infoBycustomerinfoId(e.getCustomerinfoId()));
                e.setAdmin(admindao.find_adminByadminId(e.getAdminId()));
            }
            map.put("expense_record",expense_record);
            map.put("result",true);
        }
        else
            map.put("result",false);
        return map;
    }

    /**
     * 根据消费记录编号查询消费记录
     * @param expenseRecordId
     * @return
     */
    public Map<String,Object> find_expense_recordByexpenseRecordId(String expenseRecordId)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        expense_record expense_record=expense_recorddao.find_expense_recordByexpenseRecordId(expenseRecordId);
        if(null!=expense_record)
        {
            map.put("result",true);
            expense_record.setCustomer_info(customer_infodao.find_customer_infoBycustomerinfoId(expense_record.getCustomerinfoId()));
            expense_record.setAdmin(admindao.find_adminByadminId(expense_record.getAdminId()));
            map.put("expense_record",expense_record);
        }
        else
            map.put("result",false);
        return map;
    }

    /**
     * 消费记录纠错
     * @param expenseRecordId
     * @param errorCause
     * @param stateId
     * @return
     */
    public boolean update_expense_record(String expenseRecordId,String errorCause,String stateId)
    {
        expense_record expense_record=expense_recorddao.find_expense_recordByexpenseRecordId(expenseRecordId);
        if(null!=expense_record)
        {
            expense_record.setErrorCause(errorCause);
            String recoverstateId=expense_record.getStateId();
            expense_record.setStateId(stateId);
            String adminAccount= SecurityUtils.getSubject().getPrincipal().toString();
            admin admin=adminservice.find_adminByadminAccount(adminAccount);
            expense_record.setAdminId(admin.getAdminId());
            expense_record.setUpdateDate(new Date());
            if(0<expense_recorddao.update_expense_record(expense_record))
            {
                customer_info customer_info=customer_infodao.find_customer_infoBycustomerinfoId(expense_record.getCustomerinfoId());
                if(null!=customer_info)
                {
                    customer_info.setBalance(expense_record.getExpenseMoney()+customer_info.getBalance());
                    if(0<customer_infodao.update_customer_info(customer_info))
                        return true;
                    else
                    {
                        expense_record.setStateId(recoverstateId);
                        expense_recorddao.update_expense_record(expense_record);
                        return false;
                    }
                }
                else
                {
                    expense_record.setStateId(recoverstateId);
                    expense_recorddao.update_expense_record(expense_record);
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
