package aaa.service;

import aaa.dao.adminDao;
import aaa.dao.serviceDao;
import aaa.entity.admin;
import aaa.entity.service;
import aaa.util.Encryption;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class serviceService {
    @Resource
    private serviceDao servicedao;
    @Resource
    private stateService stateservice;
    @Resource
    private adminService adminservice;
    /**
     * 查询全部服务或根据状态编号查询服务
     * @param stateId
     * @return
     */
    public Map<String,Object> find_service(String stateId)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        List<service> list=servicedao.find_service(stateId);
        if(null!=list&&0<list.size())
        {
            for(service service:list)
                service.setState(stateservice.find_stateBystateId(stateId));
            map.put("service",list);
            map.put("result",true);
        }
        else
            map.put("result",false);
        return map;
    }

    /**
     * 通过服务编号查询服务
     * @param serviceId
     * @return
     */
    public service find_serviceByserviceId(String serviceId)
    {
        return servicedao.find_serviceByserviceId(serviceId);
    }

    /**
     * 查询所有服务或根据服务名称和服务金额查询
     * @param pageIndex
     * @param pageSize
     * @param keyValue
     * @param stateId
     * @return
     */
    public Map<String,Object> find_serviceBykeyValueOrstateId(Integer pageIndex, Integer pageSize, String keyValue, String stateId)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        List<service> list=servicedao.find_serviceBykeyValueOrstateId(keyValue,stateId);
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
            List<service> service=servicedao.find_serviceBykeyValueOrstateId(keyValue,stateId);
            for(service s:service)
                s.setAdmin(adminservice.find_adminByadminId(s.getAdminId()));
            map.put("service",service);
            map.put("result",true);
        }
        else
            map.put("result",false);
        return map;
    }

    /**
     * 根据服务编号修改服务状态
     * @param serviceIds
     * @param stateId
     * @return
     */
    public boolean update_service_stateIdByserviceIds(String[]serviceIds,String stateId)
    {
        String adminAccount= SecurityUtils.getSubject().getPrincipal().toString();
        admin admin=adminservice.find_adminByadminAccount(adminAccount);
        if(0<servicedao.update_service_stateIdByserviceIds(serviceIds,stateId,admin.getAdminId(),new Date()))
            return true;
        else
            return false;
    }

    /**
     * 新增服务
     * @param serviceName
     * @param servicePrice
     * @return
     */
    public boolean insert_service(String serviceName,double servicePrice)
    {
        service service=new service();
        service.setServiceId(Encryption.getUUID());
        service.setServiceName(serviceName);
        service.setServicePrice(servicePrice);
        service.setUpdateDate(new Date());
        service.setStateId("66e75647-2b10-4553-a43d-2bb30fa33af7");
        String adminAccount= SecurityUtils.getSubject().getPrincipal().toString();
        admin admin=adminservice.find_adminByadminAccount(adminAccount);
        service.setAdminId(admin.getAdminId());
        if(0<servicedao.insert_service(service))
            return true;
        else
            return false;
    }
    /**
     * 修改服务
     * @param serviceName
     * @param servicePrice
     * @return
     */
    public boolean update_service(String serviceId,String serviceName,double servicePrice)
    {
        service service=new service();
        service.setServiceId(serviceId);
        service.setServiceName(serviceName);
        service.setServicePrice(servicePrice);
        service.setUpdateDate(new Date());
        String adminAccount= SecurityUtils.getSubject().getPrincipal().toString();
        admin admin=adminservice.find_adminByadminAccount(adminAccount);
        service.setAdminId(admin.getAdminId());
        if(0<servicedao.update_service(service))
            return true;
        else
            return false;
    }
}
