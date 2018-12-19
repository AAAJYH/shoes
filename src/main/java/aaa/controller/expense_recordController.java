package aaa.controller;

import aaa.service.expense_recordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("expense_recordController")
public class expense_recordController
{
    @Resource
    private expense_recordService expense_recordservice;

    /**
     * 查询所有消费记录或根据键值和时间查询
     * @param pageIndex
     * @param keyValue
     * @param updateDate
     * @return
     */
    @ResponseBody
    @RequestMapping("find_expense_recordBykeyValueorupdateDate")
    public Map<String,Object> find_expense_recordBykeyValueorupdateDate(Integer pageIndex, String keyValue, String updateDate)
    {
        return expense_recordservice.find_expense_recordBykeyValueorupdateDate(pageIndex,10,updateDate,keyValue);
    }
    /**
     * 根据消费记录编号查询消费记录
     * @param expenseRecordId
     * @return
     */
    @ResponseBody
    @RequestMapping("find_expense_recordByexpenseRecordId")
    public Map<String,Object> find_expense_recordByexpenseRecordId(String expenseRecordId)
    {
        return expense_recordservice.find_expense_recordByexpenseRecordId(expenseRecordId);
    }

    /**
     * 消费记录纠错
     * @param expenseRecordId
     * @param errorCause
     * @return
     */
    @ResponseBody
    @RequestMapping("update_expense_record")
    public boolean update_expense_record(String expenseRecordId,String errorCause)
    {
        return expense_recordservice.update_expense_record(expenseRecordId,errorCause,"42e92020-10ad-4954-a94a-4e1f71673fda");
    }
}
