package biz_type;

import javax.ejb.Stateless;
import javax.inject.Named;
import org.apache.commons.lang3.text.WordUtils;

@Named
@Stateless
public class biztype_getset implements java.io.Serializable {

    private Integer id;
    private String biz_type;

    public biztype_getset() {
        this.biz_type = "";
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBiz_type() {
        return this.biz_type;
    }

    public void setBiz_type(String biz_type) {
        this.biz_type = WordUtils.capitalizeFully(biz_type);
    }

}
