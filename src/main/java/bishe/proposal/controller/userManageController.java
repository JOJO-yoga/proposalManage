package bishe.proposal.controller;

import bishe.proposal.Dao.userDao;
import bishe.proposal.Entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class userManageController {

    @Autowired
    private userDao userdao;

    @PostMapping("addUser")
    public String addUser(@RequestParam("id")String id,
                        @RequestParam("name")String name,
                        @RequestParam("identity")Integer identity,
                        @RequestParam("password")String password){
        user user1=new user(id,name,password,identity);
        userdao.save(user1);
        return "manager/classificationManagement";
    }
}
