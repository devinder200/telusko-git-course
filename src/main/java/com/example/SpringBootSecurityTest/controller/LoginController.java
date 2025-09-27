package com.example.SpringBootSecurityTest.controller;

import com.example.SpringBootSecurityTest.config.MyUserDetails;
import com.example.SpringBootSecurityTest.modal.Users;
import com.example.SpringBootSecurityTest.service.MyUserDetailsService;
import com.example.SpringBootSecurityTest.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.AuthenticationException;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(){
        return "register";
    }

    @GetMapping("/home")
    public String getHome(){
        return "home";
    }


    @PostMapping("/registerUser")
    public ModelAndView registerUser(@ModelAttribute("user") Users user){
            String message = userService.register(user);
            ModelAndView mv = new ModelAndView("register");
            mv.addObject("message", message);
            return mv;

    }


    @PostMapping("/doLogin")
    public void login(@ModelAttribute("user") Users user, HttpServletResponse response , RedirectAttributes redirectAttributes) throws IOException {
        try{
            String jwtToken = userService.verify(user);

            //setting token in Http Cookie so that it can handle further requests.
            Cookie cookie = new Cookie("jwtToken", jwtToken);
            cookie.setHttpOnly(true); // prevent JS access
            cookie.setSecure(false); //set true if running on HTTPS
            cookie.setPath("/"); //available to whole app
            cookie.setMaxAge(60 * 30); //30 min
            response.addCookie(cookie);

            // redirect user to home/dashboard
            response.sendRedirect("/home");
        }catch(Exception e){
            // Failure → redirect with custom param
            response.sendRedirect("/login?loginError=true");
        }
    }

}
