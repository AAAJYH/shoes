package aaa.service;

import aaa.dao.adminDao;
import aaa.dao.customer_infoDao;
import aaa.dao.expense_recordDao;
import aaa.entity.expense_record;
import aaa.entity.service;
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
public class expense_recordService
{
    @Resource
    private expense_recordDao expense_recorddao;
    @Resource
    private customer_infoDao customer_infodao;
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
}
