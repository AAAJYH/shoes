package aaa.service;

import aaa.dao.serviceDao;
import aaa.entity.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
}
