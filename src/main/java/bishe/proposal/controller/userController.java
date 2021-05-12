package bishe.proposal.controller;

import bishe.proposal.Dao.userDao;
import bishe.proposal.Entity.user;
import bishe.proposal.Entity.email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("listUser")
public class userController {

    @Autowired
    private userDao userdao;
    @Autowired
    private bishe.proposal.Dao.emailDao emailDao;


    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam("id")String id){
        userdao.deleteById(id);
        return "redirect:/listUser/displayUser";
    }


    @RequestMapping("displayUser")
    public String displayUser(Model model){
        model.addAttribute("users",userdao.findAll());
        return "manager/UserManagement";
    }

    @RequestMapping("modify")
    public String modify(Model model ){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String id=userDetails.getUsername();
//      个人信息
        model.addAttribute("userINFO",userdao.findUserById(id));
        model.addAttribute("emailINFO",emailDao.findByPid(id));
        return "user/modify";
    }

    @RequestMapping("modifySave")
    public String modifySave(@RequestParam("name")String name,
                             @RequestParam("password")String password,
                             @RequestParam("email")String email){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String id=userDetails.getUsername();
        // 修改个人信息
        user user1=userdao.findUserById(id);
        user1.setName(name);
        user1.setPassword(password);
        userdao.save(user1);
        // 修改邮箱
        email email1=emailDao.findByPid(id);
        email1.setAddress(email);
        emailDao.save(email1);

        return "redirect:/showDetails";
    }
 }
