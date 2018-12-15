package aaa.dao;

import aaa.entity.admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface adminDao
{
    /**
     * 通过管理员账号获取管理员
     * @param adminAccount
     * @return
     */
    @Select("select * from admin where adminAccount=#{adminAccount}")
    public admin find_adminByadminAccount(@Param("adminAccount")String adminAccount);

    /**
     * 通过管理员编号查询管理员
     * @param adminId
     * @return
     */
    @Select("select * from admin where adminId=#{adminId}")
    public admin find_adminByadminId(@Param("adminId")String adminId);
}
