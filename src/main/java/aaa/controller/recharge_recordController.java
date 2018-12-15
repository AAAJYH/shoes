package aaa.controller;

import aaa.service.recharge_recordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("recharge_recordController")
public class recharge_recordController
{

    @Resource
    private recharge_recordService recharge_recordservice;

    /**
     * 查询所有充值记录或者根据键值和时间查询
     * @param pageIndex
     * @param keyValue
     * @param updateDate
     * @return
     */
    @ResponseBody
    @RequestMapping("find_recharge_recordBykeyValueorupdateDate")
    public Map<String,Object> find_recharge_recordBykeyValueorupdateDate(Integer pageIndex,String keyValue, String updateDate)
    {
        return recharge_recordservice.find_recharge_recordBykeyValueorupdateDate(pageIndex,10,keyValue,updateDate);
    }
}
