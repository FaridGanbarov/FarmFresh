package finalproject.az.farmfresh.controller;

import finalproject.az.farmfresh.dtos.authdtos.RegisterDto;
import finalproject.az.farmfresh.models.UserEntity;
import finalproject.az.farmfresh.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    @GetMapping("/register")
    public String register()
    {
        return "register";
    }
    @PostMapping("/register")
    public String register(RegisterDto registerDto)
    {
        boolean res=userService.register(registerDto);
        if(res==false){
            return "register";
        }
        return "redirect:/";
    }
    @GetMapping("auth/confirm")
    public String confirm(String email, String token)
    {
        boolean res = userService.confirmEmail(email,token);
        return "redirect:/login";
    }

}
