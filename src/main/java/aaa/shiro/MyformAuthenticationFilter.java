package aaa.shiro;


import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class MyformAuthenticationFilter extends FormAuthenticationFilter
{
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception
    {
        String successUrl="/adminController/SuccessIndex";
        WebUtils.issueRedirect(request,response,successUrl);
        return false;
    }
}
