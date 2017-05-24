package Validators;

import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.input.KeyEvent;
import javax.ejb.Stateless;
import javax.inject.Named;

@Named("val")
@Stateless
public class validators {

    public void numOnly(KeyEvent e) {
        String c = e.getCharacter();
        if ("0123456789".contains(c)) {
        } else {
            e.consume();
        }
    }

    public void NumDot(KeyEvent e) {
        String c = e.getCharacter();
        if ("0123456789.".contains(c)) {
        } else {
            e.consume();
        }
    }

    public void numPh(KeyEvent e) {
        String tt = "0123456789+-";
        String c = e.getCharacter();
        if (tt.contains(c)) {
        } else {
            e.consume();
        }
    }

    public void others(KeyEvent e) {
        String c = e.getCharacter();
        if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.\'- /".contains(c)) {
        } else {
            e.consume();
        }
    }

    public static boolean pin_val(String kraPin) {

        boolean status = true;

        String kraPinPattern = "[A-Z]{1}[0-9]{9}[A-Z]{1}$";
        Matcher mat1 = Pattern.compile(kraPinPattern).matcher(kraPin);
        status = mat1.matches();

        return status;
    }
    
    public String pin_val() {
        return "[A-Z]{1}[0-9]{9}[A-Z]{1}$";
    }

    /**
     *
     * @param email
     * @param text
     * @return
     */
    public static boolean email_val(String email) {

        boolean status = false;

        String EMAIL_PATTERN = "^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$";
        String EMAIL_PATTERN2 = "^[a-zA-Z0-9]{1,20}.[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$";

        String EMAIL_PATTERNa = "^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}.[a-zA-Z]{2,3}$";
        String EMAIL_PATTERN2a = "^[a-zA-Z0-9]{1,20}.[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}.[a-zA-Z]{2,3}$";

        String EMAIL_PATTERNb0 = "^[a-zA-Z0-9]{1,20}_[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$";
        String EMAIL_PATTERNb1 = "^[a-zA-Z0-9]{1,20}_[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}.[a-zA-Z]{2,3}$";
        String EMAIL_PATTERNb2 = "^[a-zA-Z0-9]{1,20}_[a-zA-Z0-9]{1,20}.[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}.[a-zA-Z]{2,3}$";
        String EMAIL_PATTERNb3 = "^[a-zA-Z0-9]{1,20}_[a-zA-Z0-9]{1,20}.[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$";
        String EMAIL_PATTERNb4 = "^[a-zA-Z0-9]{1,20}.[a-zA-Z0-9]{1,20}_[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}.[a-zA-Z]{2,3}$";
        String EMAIL_PATTERNb5 = "^[a-zA-Z0-9]{1,20}.[a-zA-Z0-9]{1,20}_[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$";

        Matcher mat1 = Pattern.compile(EMAIL_PATTERN).matcher(email);
        Matcher mat2 = Pattern.compile(EMAIL_PATTERN2).matcher(email);
        Matcher mat3 = Pattern.compile(EMAIL_PATTERNa).matcher(email);
        Matcher mat4 = Pattern.compile(EMAIL_PATTERN2a).matcher(email);
        Matcher mat5 = Pattern.compile(EMAIL_PATTERNb0).matcher(email);
        Matcher mat6 = Pattern.compile(EMAIL_PATTERNb1).matcher(email);
        Matcher mat7 = Pattern.compile(EMAIL_PATTERNb2).matcher(email);
        Matcher mat8 = Pattern.compile(EMAIL_PATTERNb3).matcher(email);
        Matcher mat9 = Pattern.compile(EMAIL_PATTERNb4).matcher(email);
        Matcher mat10 = Pattern.compile(EMAIL_PATTERNb5).matcher(email);

        status = mat1.matches() || mat2.matches() || mat3.matches() || mat4.matches() || mat5.matches()
                || mat6.matches() || mat7.matches() || mat8.matches() || mat9.matches() || mat10.matches();
        return status;
    }

    public static boolean web_val(String web) {

        boolean status = false;

        String WEB_PATTERN1 = "^[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$";
        String WEB_PATTERN2 = "^[a-zA-Z0-9]{1,3}.[a-zA-Z]{2,3}.[a-zA-Z]{2,3}$";
        String WEB_PATTERN3 = "^[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}.[a-zA-Z]{2,3}$";
        String WEB_PATTERN4 = "^[a-zA-Z0-9]{1,3}.[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}.[a-zA-Z]{2,3}$";

        Matcher mat1 = Pattern.compile(WEB_PATTERN1).matcher(web);
        Matcher mat2 = Pattern.compile(WEB_PATTERN2).matcher(web);
        Matcher mat3 = Pattern.compile(WEB_PATTERN3).matcher(web);
        Matcher mat4 = Pattern.compile(WEB_PATTERN4).matcher(web);

        status = mat1.matches() || mat2.matches() || mat3.matches() || mat4.matches();
        return status;
    }

    public String capFirstLetter(String text) {
        try {
            int i = 0;
            StringBuilder sb = new StringBuilder(text);
            if (text == null) {
                sb.toString();
            } else {
                do {
                    sb.replace(i, i + 1, sb.substring(i, i + 1).toUpperCase());
                    i = sb.indexOf(" ", i) + 1;
                } while (i > 0 && i < sb.length());
                return sb.toString();
            }

        } catch (Exception e) {
        }
        return null;
    }

    public String capAllLetters(String text) {
        try {
            if (text == null) {
            } else {
                return text.toUpperCase();
            }
        } catch (Exception e) {
        }
        return null;
    }

    public TextFormatter<String> textToUpperCase() {
        UnaryOperator<Change> filter = getFilterUpper();
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        return textFormatter;
    }

    private UnaryOperator<Change> getFilterUpper() {
        return change -> {
            String original_txt = change.getText();
            String upper_case = original_txt.toUpperCase();
            change.setText(upper_case);
            return change;
        };
    }

    public TextFormatter<String> textToLowerCase() {
        UnaryOperator<Change> filter = getFilterLower();
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        return textFormatter;
    }

    private UnaryOperator<Change> getFilterLower() {
        return change -> {
            String original_txt = change.getText();
            String lower_case = original_txt.toLowerCase();
            change.setText(lower_case);
            return change;
        };
    }

    public TextFormatter<String> textToCamelCase() {
        UnaryOperator<Change> filter = getFilterCamel();
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        return textFormatter;
    }

    private UnaryOperator<Change> getFilterCamel() {
        return change -> {
            change.setText(capFirstLetter(change.getText()));
            return change;
        };
    }

}
