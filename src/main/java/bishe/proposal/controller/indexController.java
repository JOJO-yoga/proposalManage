package bishe.proposal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    @RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }

    @RequestMapping("/user/userManage")
    public String jumpLogin(){
        return "manager/UserManagement";
    }

    @RequestMapping("/auditor/managePage")
    public String jumpOrder(){
        return "auditor/OrderManagement";
    }
    @RequestMapping("/user/Classification")
    public String jumpClassification(){
        return "manager/classificationManagement";
    }

    @RequestMapping("/user/Product")
    public String jumpProduct(){
        return "user/ProductManagement";
    }

    @RequestMapping("/user/Register")
    public String jumpRegister(){
        return "register";
    }

    @RequestMapping("/user/upload")
    public String jumpUpload(){
        return "user/upload";
    }

    @RequestMapping("/user/personalPage")
    public String jumpPersonalPage(){
        return "user/personalPage";
    }

}
