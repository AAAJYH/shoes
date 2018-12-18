package aaa.controller;

import aaa.service.serviceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("serviceController")
public class serviceController
{
    @Resource
    private serviceService serviceservice;

    /**
     * 通过状态编号查询服务
     * @return
     */
    @ResponseBody
    @RequestMapping("find_serviceBystateId")
    public Map<String,Object> find_serviceBystateId()
    {
        return serviceservice.find_service("66e75647-2b10-4553-a43d-2bb30fa33af7");
    }
}
