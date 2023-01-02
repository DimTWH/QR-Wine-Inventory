package com.QRwineinventory.qrWineInventory.controllers;

import com.QRwineinventory.qrWineInventory.exceptions.PasswordConfirmationException;
import com.QRwineinventory.qrWineInventory.models.User;
import com.QRwineinventory.qrWineInventory.services.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("")
@RestController
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView goToIndex(){
        ModelAndView model = new ModelAndView();
        model.addObject("search", "");
        model.setViewName("redirect:inventory/wine/index");
        return model;
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }

    @GetMapping("/user/profile")
//    public ModelAndView getProfilePage(@RequestParam(value = "id", required = false) int id) {
    public ModelAndView getProfilePage() {
        ModelAndView model = new ModelAndView();
        model.addObject("search", "");
        model.setViewName("userProfile");
        return model;
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage() {
        return new ModelAndView("register");
    }
    @PostMapping("/registerUser")
    public ModelAndView registerUser(User user, @RequestParam("confirmPassword") String confirmingPassword) throws PasswordConfirmationException {
        System.out.println("conf passwd: "+confirmingPassword);
        ModelAndView model = new ModelAndView();
        try {
            userService.insertUser(user, confirmingPassword);
            model.setViewName("redirect:inventory/wine/index");
        } catch (PasswordConfirmationException e){
            model.setViewName("register");
            throw new PasswordConfirmationException("Password is not confirmed correctly c");
        }
        return model;
    }
}
