package bishe.proposal.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "proposal",schema = "public")
public class proposal {
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUpid() {
        return upid;
    }

    public void setUpid(String upId) {
        this.upid = upId;
    }

    public byte[] getProposal() {
        return proposal;
    }

    public void setProposal(byte[] proposal) {
        this.proposal = proposal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }


    @Id
    @Column(name="pid")
    private String pid;
    @Column(name="upid")
    private String upid;
    @Column(name="proposal")
    private byte[] proposal;
    @Column(name="status")
    private String status;
    @Column(name="checkid")
    private String checkId;
    @Column(name="upday")
    private Date date;
    public proposal() {

    }
    @Override
    public String toString() {
        return "proposal{" +
                "pid='" + pid + '\'' +
                ", upId='" + upid + '\'' +
                ", proposal='" + proposal + '\'' +
                ", status='" + status + '\'' +
                ", checkId='" + checkId + '\'' +
                ",date='"+date+ '\'' +
                '}';
    }

}
