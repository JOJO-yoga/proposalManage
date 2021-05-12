package bishe.proposal.service;

import bishe.proposal.Dao.userDao;
import bishe.proposal.Entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class loginServiceImpl implements loginService{
    @Autowired
    private bishe.proposal.Dao.userDao userDao;
    @Override
    public user getUser(String ID, String password) {
        return userDao.findUserByIdAndUserPassword(ID,password);
    }

    @Override
    public void insertUser(user user) {
        userDao.save(user);
    }
}
