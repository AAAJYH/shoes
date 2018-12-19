package aaa.controller;

import aaa.dao.stateDao;
import aaa.entity.state;
import aaa.service.stateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * state表控制层
 */
@Controller
@RequestMapping("/stateController")
public class stateController {

    @Resource
    stateService stateService;

    /**
     * 查询全部状态
     * @return
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public List<state> queryAll(){
        return  stateService.queryAll();
    }

}
