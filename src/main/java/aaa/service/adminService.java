package aaa.service;

import aaa.dao.adminDao;
import aaa.entity.admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class adminService
{
    @Resource
    private adminDao admindao;
    /**
     * 通过管理员账号获取管理员
     * @param adminAccount
     * @return
     */
    public admin find_adminByadminAccount(String adminAccount)
    {
       return admindao.find_adminByadminAccount(adminAccount);
    }

    /**
     * 通过管理员编号查询管理员
     * @param adminId
     * @return
     */
    public admin find_adminByadminId(String adminId)
    {
        return admindao.find_adminByadminId(adminId);
    }
}
