package aaa.dao;

import aaa.entity.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

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

    /**
     * 根据账号查询当前管理员是否存在，并且为正常状态
     * @param Account
     * @return
     */
    @Select("select * from admin where adminAccount=#{Account} and stateId='66e75647-2b10-4553-a43d-2bb30fa33af7'")
    public admin ByAccountQuery(@Param("Account") String Account);

    /**
     * 多条件分页查询
     * @param stateId
     * @param condition
     * @return
     */
    @Select("<script>" +
            "select admin.adminId,a2.adminName admin2Name,admin.adminName adminName,admin.adminAccount,admin.createadminId,admin.updateDate,admin.adminAuthority,state.stateName from admin,state,admin a2 where admin.stateId=state.stateId and a2.adminId=admin.createadminId " +
            "<if test=\"stateId!=''\">and admin.stateId=#{stateId}</if> " +
            "<if test=\"condition!=''\">and (admin.adminName like concat('%',#{condition},'%') or admin.adminAccount like concat('%',#{condition},'%') )</if>" +
            "order by updateDate desc</script>")
    public List<Map<String,Object>> PageQuery(@Param("stateId") String stateId, @Param("condition") String condition);

    /**
     * 修改管理员状态
     * @param admin
     * @return
     */
    @Update("update admin set stateId=#{a.stateId},createadminId=#{a.createadminId},updateDate=#{a.updateDate} where adminId=#{a.adminId}")
    public int ByAdminIdUpdateState(@Param("a") admin admin);

    /**
     * 新增
     * @param admin
     * @return
     */
    @Insert("insert into admin(adminId,adminName,adminAccount,adminPassword,createadminId,stateId,adminAuthority,updateDate) values(#{a.adminId},#{a.adminName},#{a.adminAccount},#{a.adminPassword},#{a.createadminId},#{a.stateId},#{a.adminAuthority},#{a.updateDate})")
    public int add(@Param("a") admin admin);

    /**
     * 修改
     * @param admin
     * @return
     */
    @Update("update admin set adminAuthority=#{a.adminAuthority},adminName=#{a.adminName},updateDate=#{a.updateDate},createadminId=#{a.createadminId} where adminId=#{a.adminId}")
    public int update(@Param("a") admin admin);

}
