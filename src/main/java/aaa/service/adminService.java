package aaa.service;

import aaa.dao.adminDao;
import aaa.entity.admin;
import aaa.entity.paging;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class adminService
{
    @Resource
    private adminDao admindao;

    /**
     * 根据账号查询当前管理员是否存在，并且为正常状态
     * @param Account
     * @return
     */
    public admin ByAccountQuery(String Account){
        return admindao.ByAccountQuery(Account);
    }

    /**
     * 多条件分页查询
     * @param stateId
     * @param condition
     * @return
     */
    public paging<admin> PageQuery(Integer page,Integer rows,String stateId, String condition){
        Integer total=admindao.PageQuery(stateId,condition).size();
        PageHelper.startPage(page,rows);
        List<Map<String,Object>> adminList=admindao.PageQuery(stateId,condition);
        return new paging((int) Math.ceil((double)total/(double)rows),adminList);
    }


    /**
     * 修改管理员状态
     * @param admin
     * @return
     */
    @Transactional
    public int ByAdminIdUpdateState(admin admin){
        return admindao.ByAdminIdUpdateState(admin);
    }

    /**
     * 新增
     * @param admin
     * @return
     */
    @Transactional
    public int add( admin admin){
        return admindao.add(admin);
    }

    /**
     * 修改
     * @param admin
     * @return
     */
    @Transactional
    public int update(admin admin){
        return admindao.update(admin);
    }

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

    /**
     * 修改密码
     * @param adminAccount
     * @param adminPassword
     * @return
     */
    @Transactional
    public int updateAdminPassword(String adminAccount,String adminPassword){
        return admindao.updateAdminPassword(adminAccount,adminPassword);
    }

}
