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
}
