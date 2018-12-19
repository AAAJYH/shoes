package aaa.service;

import aaa.dao.stateDao;
import aaa.entity.state;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class stateService
{
    @Resource
    private stateDao statedao;
    /**
     * 通过状态编号查询
     * @param stateId
     * @return
     */
    public state find_stateBystateId(String stateId)
    {
        return statedao.find_stateBystateId(stateId);
    }

    /**
     * 查询全部状态
     * @return
     */
    public List<state> queryAll(){
        return  stateDao.queryAll();
    }

}
