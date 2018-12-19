package aaa.shiro;

import aaa.entity.admin;
import aaa.service.adminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class customRealm extends AuthorizingRealm{

    @Resource
    adminService adminService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String Account=principalCollection.getPrimaryPrincipal().toString();
        admin admin= adminService.ByAccountQuery(Account);
        String permission =admin.getAdminAuthority();
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(permission);
        System.out.println(permission);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String Account=authenticationToken.getPrincipal().toString();
        admin admin=adminService.ByAccountQuery(Account);
        if(admin==null){
            throw new UnknownAccountException();
        }else{
            return new SimpleAuthenticationInfo(Account,admin.getAdminPassword(),getName());
        }
    }

}
