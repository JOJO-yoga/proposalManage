package bishe.proposal.service;

import bishe.proposal.Entity.user;

import java.util.List;

public interface userService {
    user findUserById(String Id);
    void delete(String Id);
    user save(user userinfo);
    user update(user userinfo);
    public List<user> findAll();
}
