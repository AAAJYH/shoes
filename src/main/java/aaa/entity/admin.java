package aaa.entity;

import lombok.Data;

import java.util.Date;

/**
 * 管理员实体
 */
@Data
public class admin {

    private String adminId; //id
    private String adminName; //管理员姓名
    private String adminAccount; //管理员账号
    private String adminPassword; //管理员密码
    private String createadminId; //创建管理员id
    private String adminAuthority; //管理员权限（写固定值）
    private Date updateDate; //修改日期
}
