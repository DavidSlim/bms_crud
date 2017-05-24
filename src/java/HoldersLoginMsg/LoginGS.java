package HoldersLoginMsg;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class LoginGS implements java.io.Serializable {

    private Integer id;
    private String logName;
    private String logPass;
    private String department;
    private String status, searcher;
    private boolean loggedIn;

    public LoginGS() {
        this.logName = "";
        this.logPass = "";
        this.department = "";
        this.status = "";
        this.loggedIn = false;
        this.searcher = "";
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogName() {
        return this.logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogPass() {
        return this.logPass;
    }

    public void setLogPass(String logPass) {
        this.logPass = logPass;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getSearcher() {
        return searcher;
    }

    public void setSearcher(String searcher) {
        this.searcher = searcher;
    }

}
