package bishe.proposal.service;

import bishe.proposal.Entity.user;

public interface loginService {
    public user getUser(String username, String password);
    public void insertUser(user user);
}
