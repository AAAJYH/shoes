package aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateDate; //修改日期
    private String stateId; //状态id（正常/删除）
    private String adminPhone; //手机号

}
