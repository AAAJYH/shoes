package aaa.controller;

import aaa.service.recharge_recordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 根据充值记录编号查询充值记录
     * @param rechargeRecordId
     * @return
     */
    @ResponseBody
    @RequestMapping("find_recharge_recordByrechargeRecordId")
    public Map<String,Object> find_recharge_recordByrechargeRecordId(String rechargeRecordId)
    {
        return recharge_recordservice.find_recharge_recordByrechargeRecordId(rechargeRecordId);
    }

    /**
     * 修改充值记录
     * @param rechargeRecordId
     * @param errorCause
     * @return
     */
    @ResponseBody
    @RequestMapping("update_recharge_record")
    public boolean update_recharge_record(String rechargeRecordId,String errorCause)
    {
        return recharge_recordservice.update_recharge_record(rechargeRecordId,errorCause);
    }
}
