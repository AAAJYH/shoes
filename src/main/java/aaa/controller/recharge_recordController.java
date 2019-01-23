package aaa.controller;

import aaa.entity.paging;
import aaa.entity.recharge_record;
import aaa.service.recharge_recordService;
import aaa.util.doubleSum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("recharge_recordController")
public class recharge_recordController {

    @Resource
    private recharge_recordService recharge_recordservice;

    /**
     * 查询所有充值记录或者根据键值和时间查询
     *
     * @param pageIndex
     * @param keyValue
     * @param updateDate
     * @return
     */
    @ResponseBody
    @RequestMapping("find_recharge_recordBykeyValueorupdateDate")
    public Map<String, Object> find_recharge_recordBykeyValueorupdateDate(Integer pageIndex, String keyValue, String updateDate) {
        return recharge_recordservice.find_recharge_recordBykeyValueorupdateDate(pageIndex, 10, keyValue, updateDate);
    }

    /**
     * 消费金额
     *
     * @return
     */
    @RequestMapping("/currentDayIncome")
    @ResponseBody
    public double currentDayIncome(String date) {
        double d = 0.0;
        List<recharge_record> recharge_recordList = recharge_recordservice.currentDayIncome(date);
        for (recharge_record r : recharge_recordList) {
            d = doubleSum.sum(d, r.getRechargeMoney());
        }
        return d;
    }

    /**
     * 充值统计
     * @param page 第一页
     * @param rows 每页显示的数量
     * @param customName 客户姓名
     * @return
     */
    @RequestMapping("/rechargeStatistics")
    @ResponseBody
    public paging<Map<String, Object>> rechargeStatistics(Integer page, Integer rows, String customName) {
        return recharge_recordservice.rechargeStatistics(page, rows, customName);
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
