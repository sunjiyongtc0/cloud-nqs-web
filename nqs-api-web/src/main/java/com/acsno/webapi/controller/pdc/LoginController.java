package com.acsno.webapi.controller.pdc;

import com.acsno.ext.kit.Ret;
import com.acsno.webapi.shiro.ShiroUtils;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private Producer producer;


    @RequestMapping("/in")
    public  String index(){
        return "login";
    }

    @RequestMapping("captcha.jpg")
    public void captcha(HttpServletResponse response)throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }




    @ResponseBody
    @PostMapping("/into")
    public Ret Into(String userName,String userPass,String type,String captcha){
        try{
            Subject subject = ShiroUtils.getSubject();
            //游客模式
            if("1".equals(type)){
                UsernamePasswordToken token = new UsernamePasswordToken("asd", "asd");
                subject.login(token);
            //超管模式
            }else if("2".equals(type)){
                UsernamePasswordToken token = new UsernamePasswordToken("admin", "admin");
                subject.login(token);
            }else {
                //判断验证码是否正确
                String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
                if (!captcha.equals(kaptcha)) {
                    return Ret.fail("msg", "验证码不正确！");
                }
                UsernamePasswordToken token = new UsernamePasswordToken(userName, userPass);
                subject.login(token);
            }
        }catch (UnknownAccountException e) {
            return Ret.fail("msg",e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return Ret.fail("msg","账号或密码不正确");
        }catch (LockedAccountException e) {
            return Ret.fail("msg","账号已被锁定,请联系管理员");
        }catch (AuthenticationException e) {
            return Ret.fail("msg","账户验证失败");
        }
        return Ret.ok("code",0);
    }

    @RequestMapping(value = {"/", "home.html"})
    public String home(){
        return "redirect:/home/index";
    }


    @GetMapping("loginout")
    @ResponseBody
    public Ret loginout(){
        ShiroUtils.logout();
        return Ret.ok();
    }

}
