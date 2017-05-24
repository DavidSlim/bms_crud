package HoldersLoginMsg;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class TrueFalse implements Serializable {

    private boolean disabledColLoad, disabler_false, disabler_true, disabledColDel, disabledTF, disabledDel, disabledEdit, disabledSave, disabledListItem;

    public TrueFalse() {
        this.disabledColLoad = false;
        this.disabledColDel = true;
        this.disabledTF = false;
        this.disabledDel = false;
        this.disabledEdit = false;
        this.disabledSave = false;
        this.disabledListItem = false;
        this.disabler_false = false;
        this.disabler_true = false;
    }

    public boolean isDisabledColLoad() {
        return disabledColLoad;
    }

    public void setDisabledColLoad(boolean disabledColLoad) {
        this.disabledColLoad = disabledColLoad;
    }

    public boolean isDisabledColDel() {
        return disabledColDel;
    }

    public void setDisabledColDel(boolean disabledColDel) {
        this.disabledColDel = disabledColDel;
    }

    public boolean isDisabledTF() {
        return disabledTF;
    }

    public void setDisabledTF(boolean disabledTF) {
        this.disabledTF = disabledTF;
    }

    public boolean isDisabledDel() {
        return disabledDel;
    }

    public void setDisabledDel(boolean disabledDel) {
        this.disabledDel = disabledDel;
    }

    public boolean isDisabledEdit() {
        return disabledEdit;
    }

    public void setDisabledEdit(boolean disabledEdit) {
        this.disabledEdit = disabledEdit;
    }

    public boolean isDisabledSave() {
        return disabledSave;
    }

    public void setDisabledSave(boolean disabledSave) {
        this.disabledSave = disabledSave;
    }

    public boolean isDisabledListItem() {
        return disabledListItem;
    }

    public void setDisabledListItem(boolean disabledListItem) {
        this.disabledListItem = disabledListItem;
    }

    public boolean isDisabler_false() {
        return disabler_false;
    }

    public void setDisabler_false(boolean disabler_false) {
        this.disabler_false = disabler_false;
    }

    public boolean isDisabler_true() {
        return disabler_true;
    }

    public void setDisabler_true(boolean disabler_true) {
        this.disabler_true = disabler_true;
    }

}
