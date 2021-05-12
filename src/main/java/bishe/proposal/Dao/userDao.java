package bishe.proposal.Dao;

import bishe.proposal.Entity.user;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface userDao extends CrudRepository<user, String>{
    public user findUserByIdAndUserPassword(String name, String password);
    public user findUserById(String Id);
    List<userDao> findUserByUserName(String name);
}
