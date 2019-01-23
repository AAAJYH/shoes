package aaa.service;

import aaa.dao.stateDao;
import aaa.entity.service;
import aaa.entity.state;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * state表业务层
 */
@Service
public class stateService {

    @Resource
    stateDao stateDao;

    /**
     * 查询全部状态
     * @return
     */
    public List<state> queryAll(){
        return  stateDao.queryAll();
    }

    /**
     * 通过状态编号查询
     * @param stateId
     * @return
     */
    public state find_stateBystateId(String stateId)
    {
        return stateDao.find_stateBystateId(stateId);
    }

}
