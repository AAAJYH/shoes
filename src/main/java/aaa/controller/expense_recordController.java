package aaa.controller;

import aaa.entity.expense_record;
import aaa.service.expense_recordService;
import aaa.util.doubleSum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
     * 消费金额
     * @return
     */
    @RequestMapping("/currentDayExpense")
    @ResponseBody
    public double currentDayExpense(String date){
        double d=0.0;
        List<expense_record> expense_recordList=expense_recordservice.currentDayExpense(date);
        for (expense_record e:expense_recordList) {
            d= doubleSum.sum(d,e.getExpenseMoney());
        }
        return d;
    }

}
