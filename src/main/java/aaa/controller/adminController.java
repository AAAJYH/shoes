package aaa.controller;

import aaa.entity.admin;
import aaa.entity.paging;
import aaa.service.adminService;
import aaa.util.currentInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * admin控制层
 */
@Controller
@RequestMapping("/adminController")
public class adminController {

    @Resource
    adminService adminService;

    @Resource
    currentInfo currentInfo;

    /**
     * 登陆页面
     * @return
     */
    @RequestMapping("/loginIndex")
    public String loginIndex(){
        return "login";
    }

    /**
     * 登陆失败要执行的方法
     * @return 登陆页面
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        Object exception=request.getAttribute("shiroLoginFailure");
        String msg="";
        if(null!=exception){
            if(UnknownAccountException.class.getName().equals(exception.toString())){
                msg="账号错误或账号被禁用";
            }else if(IncorrectCredentialsException.class.getName().equals(exception.toString())){
                msg="密码不正确";
            }else{
                msg="登陆失败，请前检查账户和密码!";
            }
        }
        request.getSession().setAttribute("msg",msg);
        return "login";
    }

    /**
     * index页面
     * @return
     */
    @RequestMapping("/SuccessIndex")
    public String SuccessIndex(){
        return "index";
    }

    /**
     * 退出登陆
     * @return 跳转登陆页面
     */
    @RequestMapping("/Exit")
    public String Exit(){
        SecurityUtils.getSubject().logout();
        return "login";
    }

    /**
     * 管理员管理页面
     * @return
     */
    @RequestMapping("/AdminManageIndex")
    public String AdminManageIndex(){
        return "adminManage";
    }

    /**
     * 多条件分页查询
     * @param page 当前页
     * @param rows 每页显示的行数
     * @param stateId 状态id
     * @param condition 共同的条件
     * @return paging对象
     */
    @RequestMapping("/PageQuery")
    @ResponseBody
    public paging<admin> PageQuery(Integer page,Integer rows,String stateId,String condition){
        paging<admin> paging=adminService.PageQuery(page, rows, stateId, condition);
        System.out.println(paging.getRows());
        return paging;
    }

    /**
     * 修改管理员状态
     * @param admin
     * @return
     */
    @RequestMapping("/ByAdminIdUpdateState")
    @ResponseBody
    public int ByAdminIdUpdateState(admin admin){
        //设置修改时间和管理员
        currentInfo.getCurrentDateAndAdmin(admin);
        return adminService.ByAdminIdUpdateState(admin);
    }

    /**
     * 新增
     * @param admin
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public int add(admin admin){
        currentInfo.getCurrentDateAndAdmin(admin);
        //设置状态为正常
        admin.setStateId("66e75647-2b10-4553-a43d-2bb30fa33af7");
        //设置id
        admin.setAdminId(UUID.randomUUID().toString());
        return adminService.add(admin);
    }

      /** 修改
     * @param admin
     * @return
             */
      @RequestMapping("/update")
      @ResponseBody
    public int update(admin admin){
       //设置修改时间和管理员
        currentInfo.getCurrentDateAndAdmin(admin);
        return adminService.update(admin);
    }

}
