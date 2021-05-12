package bishe.proposal.controller;

import bishe.proposal.Dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class auditorInfoController {
    @Autowired
    private userDao userdao;
    @Autowired
    private bishe.proposal.Dao.emailDao emailDao;

    @RequestMapping(value = "/showAuditorDetails")
    public String currentUserName(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        int identity=userdao.findUserById(userDetails.getUsername()).getIdentity();
        String identityName="";
        if(identity==0){
            identityName="用户";
        }
        else if(identity==1){
            identityName="审核员";
        }
        else if(identity==2){
            identityName="管理员";
        }
        else {
            identityName="";
        }
        model.addAttribute("loginUser",userdao.findUserById(userDetails.getUsername()));
        model.addAttribute("identity",identityName);
        model.addAttribute("email",emailDao.findByPid(userDetails.getUsername()));
        return "auditor/personal";
    }
}
