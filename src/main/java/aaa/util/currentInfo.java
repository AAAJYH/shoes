package aaa.util;

import aaa.entity.admin;
import aaa.service.adminService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class currentInfo {

    @Resource
    adminService adminService;

    public void getCurrentDateAndAdmin(admin admin){
        System.out.println(admin);
        //当前时间
        Date curremtnDate=new Date();
        admin.setUpdateDate(curremtnDate);
        //当前管理员ID
        String account= SecurityUtils.getSubject().getPrincipal().toString();
        admin curremtnAdmin= adminService.ByAccountQuery(account);
        System.out.println(curremtnAdmin);
        admin.setCreateadminId(curremtnAdmin.getAdminId());
    }

}
