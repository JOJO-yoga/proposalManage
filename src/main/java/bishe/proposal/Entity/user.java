package bishe.proposal.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="user")

public class user {
    @Id
    private String id;

    private String Name;

    private String password;

    private int identity;

    public String getId() {
        return id;
    }

    public void setId(String employeeNumber) {
        this.id = employeeNumber;
    }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }
}
