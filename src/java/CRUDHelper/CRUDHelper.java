package CRUDHelper;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;

/**
 *
 * @author DeadMeat
 * @since 2017
 */
public class CRUDHelper {

    private static SfUtil.SfUtil sf = new SfUtil.SfUtil();

    /**
     * An advanced form of Java subList
     *
     * @param <T>
     * @param list provide List to be subListed List can be from Collection or
     * any List
     * @param fromIndex provide index to begin at
     * @param toIndex provide end index size
     * @return returns SafeSubListed List
     * @since 2017
     */
    public static <T> List<T> safeSubList(List<T> list, int fromIndex, int toIndex) {
        int size = list.size();
        if (fromIndex >= size || toIndex <= 0 || fromIndex >= toIndex) {
            return Collections.emptyList();
        }
        fromIndex = Math.max(0, fromIndex);
        toIndex = Math.min(size, toIndex);
        return list.subList(fromIndex, toIndex);
    }

    /**
     * Insert record into database
     *
     * @param <T>
     * @param list List to be Inserted
     * @since 2017
     */
    public static <T> void dataInsert(List<T> list) {
        Session session = sf.SfUtil().openSession();
        session.beginTransaction();
        session.save(list);
        session.getTransaction().commit();
        session.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Record Inserted..."));
    }

    /**
     * Update database records
     *
     * @param list List to be Updated
     * @since 2017
     */
    public static <T> void dataUpdate(List<T> list) {
        Session session = sf.SfUtil().openSession();
        session.beginTransaction();
        session.update(list);
        session.getTransaction().commit();
        session.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Record Updated..."));
    }

    /**
     * Delete a database record
     *
     * @param col
     * @since 2017
     */
    public static void dataDelete(Collection col) {
        col col_gs = new col();
        Session session = sf.SfUtil().openSession();
        session.beginTransaction();
        session.delete(col_gs);
        session.getTransaction().commit();
        session.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Record Deleted..."));
    }

    private static class col {

        public col() {
        }
    }
}
