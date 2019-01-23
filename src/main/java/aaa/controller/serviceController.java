package aaa.controller;

import aaa.entity.service;
import aaa.service.serviceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
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

    /**
     * 查询所有服务或根据服务名称和服务金额查询
     * @param pageIndex
     * @param keyValue
     * @param stateId
     * @return
     */
    @ResponseBody
    @RequestMapping("find_serviceBykeyValueOrstateId")
    public Map<String,Object> find_serviceBykeyValueOrstateId(Integer pageIndex,String keyValue, String stateId)
    {
        return serviceservice.find_serviceBykeyValueOrstateId(pageIndex,10,keyValue,stateId);
    }

    /**
     * 根据服务编号恢复服务
     * @param serviceIds
     * @return
     */
    @ResponseBody
    @RequestMapping("recover_service")
    public boolean recover_service(String [] serviceIds)
    {
        return serviceservice.update_service_stateIdByserviceIds(serviceIds,"66e75647-2b10-4553-a43d-2bb30fa33af7");
    }

    /**
     * 根据服务编号恢复服务
     * @param serviceIds
     * @return
     */
    @ResponseBody
    @RequestMapping("delete_service")
    public boolean delete_service(String [] serviceIds)
    {
        return serviceservice.update_service_stateIdByserviceIds(serviceIds,"42e92020-10ad-4954-a94a-4e1f71673fda");
    }

    /**
     * 新增服务
     * @param serviceName
     * @param servicePrice
     * @return
     */
    @ResponseBody
    @RequestMapping("insert_service")
    public boolean insert_service(String serviceName,double servicePrice)
    {
        return serviceservice.insert_service(serviceName,servicePrice);
    }

    /**
     * 修改服务
     * @param serviceId
     * @param serviceName
     * @param servicePrice
     * @return
     */
    @ResponseBody
    @RequestMapping("update_service")
    public boolean update_service(String serviceId,String serviceName,double servicePrice)
    {
        return serviceservice.update_service(serviceId,serviceName,servicePrice);
    }

    /**
     * 根据服务编号查询
     * @param serviceId
     * @return
     */
    @ResponseBody
    @RequestMapping("find_serviceByserviceId")
    public Map<String,Object> find_serviceByserviceId(String serviceId)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        service service=serviceservice.find_serviceByserviceId(serviceId);
        if(null!=service)
        {
            map.put("result",true);
            map.put("service",service);
        }
        else
            map.put("result",false);
        return map;
    }
}
