/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateTime;

import java.time.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("dt")
@RequestScoped
public class date_time {

    public String time() {
        String time = LocalTime.now().toString();
        return time.substring(0, time.length() - 4);
    }

    public String date() {
        String date = (LocalDate.now()).toString();
        return date;
    }

    public String year() {
        String year = String.valueOf((LocalDate.now().getYear()));
        return year;
    }

    public String month() {
        int month = Month.valueOf(LocalDate.now().getMonth().toString()).getValue();
        return String.format("%01d", month);
    }

    public String timePrint() {
        String time_print = String.valueOf((LocalDate.now())) + " % " + time();
        return time_print;
    }

}
