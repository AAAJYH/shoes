package aaa.controller;

import aaa.util.verifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("verificationCodeController")
public class verificationCodeController
{
    /**
     * 生成图片验证码并返回给前台
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/generate_verifyCode")
    public void generate_verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        //String path = ResourceUtils.getURL("src/main/resources/static/verifyCodeImages").getPath();
        String path = ClassUtils.getDefaultClassLoader().getResource("static/verifyCodeImages").getPath();//获取到绝对路径
        path=path.replace("%20"," ");
        int w = 120, h = 40;
        String verifyCode = verifyCodeUtils.generateVerifyCode(4);
        //将生成的验证码图片保存在服务器
        File file = new File(path+"/"+verifyCode + ".jpg");
        verifyCodeUtils.outputImage(w, h, file, verifyCode);
        //将验证码保存在cookie中
        Cookie cookie=new Cookie("verifyCode",verifyCode);
        cookie.setMaxAge(60*5);
        response.addCookie(cookie);
        //获取验证码图片返回给前台显示
        FileInputStream fis=null;
        OutputStream os=null;
        try
        {
            fis=new FileInputStream(path+"/"+verifyCode+".jpg");
            os=response.getOutputStream();
            int count=0;
            byte[]buffer=new byte[1024*8];
            while((count=fis.read(buffer))!=-1)
            {
                os.write(buffer,0,count);
                os.flush();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                fis.close();//必须在上面,之后要进行删除图片操作,删除之前关闭,删除图片不能被其他进程所使用
                os.close();
                if(file.exists())
                {
                    file.delete();
                }
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * 检验验证码是否正确
     * @param verificationCode
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("check_verificationCode")
    public boolean check_verifyCode(String verificationCode,HttpServletRequest request)
    {
        Cookie [] cookies=request.getCookies();
        if(null!=cookies&&0<cookies.length)
        {
            for(Cookie cookie:cookies)
            {
                if("verifyCode".equals(cookie.getName()))
                {
                    if(verificationCode.toUpperCase().equals(cookie.getValue()))
                        return true;
                    else
                        return false;
                }
            }
            return false;
        }
        else
            return false;
    }
}
