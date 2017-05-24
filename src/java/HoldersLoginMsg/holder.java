package HoldersLoginMsg;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless 
public class holder implements Serializable {

    private int id_updt;
    private String msg, any, msgPop;
    private Date date;

    public holder() {
        this.id_updt = 0;
        this.msg = "";
        this.date = Date.from(Instant.now());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_updt() {
        return id_updt;
    }

    public void setId_updt(int id_updt) {
        this.id_updt = id_updt;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getAny() {
        return any;
    }

    public void setAny(String any) {
        this.any = any;
    }

    public String getMsgPop() {
        return msgPop;
    }

    public void setMsgPop(String msgPop) {
        this.msgPop = msgPop;
    }

    ////Nav Buttons
    public String getNext() {
        return "Next>";
    }

    public String getPrev() {
        return "<Prev";
    }

    public String getFirst() {
        return "|<<";
    }

    public String getLast() {
        return ">>|";
    }
}
