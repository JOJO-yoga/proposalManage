package bishe.proposal.service;

import bishe.proposal.Dao.userDao;
import bishe.proposal.Entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class userServiceImp implements userService{
    @Autowired
    private userDao userdao;

    @Override
    public user findUserById(String Id) {
        return userdao.findUserById(Id);
    }

    @Override
    public void delete(String Id) {
        userdao.deleteById(Id);
    }

    @Override
    public user save(user userinfo) {
        return userdao.save(userinfo);
    }

    @Override
    public user update(user userinfo) {
        return userdao.save(userinfo);
    }

    @Override
    public List<user> findAll() {
        return userdao.findAll();
    }
}



