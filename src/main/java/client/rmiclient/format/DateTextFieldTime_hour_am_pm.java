/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.rmiclient.format;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

import client.layout.Date_Format;

/**
 *
 * @author foo
 */
public class DateTextFieldTime_hour_am_pm extends JTextField {

    public static String getFirstDay() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return Date_Format.Format_DayDMY(cal.getTime());

    }
    private DateTextFieldTime_hour_am_pm focusto = null;
    private String focusInitValue = "ini";
    //public static final String DATEINIT = "dd-mm-yyyy";
    //                                    "yyyy-mm-dd HH:mm:ss"
    public static final String DATEINIT = "00:00 am";

    @Override
    public String getText() {
        String text = super.getText();
        if (text.equalsIgnoreCase(DATEINIT)) {
            text = "";
        }

        return text;
    }

    public void resetValue() {
        setText(DATEINIT);
    }

    public String getFocusInitValue() {
        return focusInitValue;
    }

    public void setFocusInitValue(String focusInitValue) {
        this.focusInitValue = focusInitValue;

    }

    public DateTextFieldTime_hour_am_pm getFocusto() {
        return focusto;
    }

    public void setFocusto(DateTextFieldTime_hour_am_pm focusto) {
        this.focusto = focusto;
        focusInitValue = getFirstDay();
    }

    public DateTextFieldTime_hour_am_pm() {
        super();
        this.setDocument(new MyDocument(this));
        this.addFocusListener(new MyFocusListener(this));
        this.setText(DATEINIT);
    }

    class MyDocument extends javax.swing.text.PlainDocument {

        //int counter = 0;
        int datel = DATEINIT.length();

        public MyDocument(DateTextFieldTime_hour_am_pm pcomp, DateTextFieldTime_hour_am_pm pfocusto) {
            // comp = pcomp;
            focusto = pfocusto;
        }

        public MyDocument(JTextField pcomp) {
        }

        @Override
        public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
            String text = DateTextFieldTime_hour_am_pm.super.getText();
//            if(text.equalsIgnoreCase("")){
//                text = DATEINIT;
//            }
            //System.out.println(String.format("Offset [%d] text [%s]  length[%d]", (offset),text, datel));
            if (str.length() == datel) {
                if (text != null && text.length() > 0) {
                    super.remove(0, datel);
                }
                super.insertString(offset, str, a);
                return;
            }
            if (str.length() != 1) {
                if (str.length() != datel) {
                    return;
                } else {
                    super.insertString(offset, str, a);
                    return;
                }
            }
            char ch = str.charAt(0);
            switch (offset) {

                case 0:
                    if (ch == '0' || ch == '1') {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime_hour_am_pm.this.setText(str);
                        DateTextFieldTime_hour_am_pm.this.setCaretPosition(offset + 1);
                    }
                    break;
                case 1:
                    if (Character.isDigit(ch)) {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime_hour_am_pm.this.setText(str);
                        DateTextFieldTime_hour_am_pm.this.setCaretPosition(offset + 2);
                    }
                    break;
                case 2:
                    super.remove(0, datel);
                    str = text.substring(0, offset) + ":" + text.substring(offset + 1);
                    DateTextFieldTime_hour_am_pm.this.setText(str);
                    DateTextFieldTime_hour_am_pm.this.setCaretPosition(offset + 1);
                    break;
                case 3:
                    if (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5') {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime_hour_am_pm.this.setText(str);
                        DateTextFieldTime_hour_am_pm.this.setCaretPosition(offset + 1);
                    }
                    break;
                case 4:
                    if (Character.isDigit(ch)) {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime_hour_am_pm.this.setText(str);
                        DateTextFieldTime_hour_am_pm.this.setCaretPosition(offset + 2);
                    }
                    break;
                case 5:
                    super.remove(0, datel);
                    str = text.substring(0, offset) + " " + text.substring(offset + 1);
                    DateTextFieldTime_hour_am_pm.this.setText(str);
                    DateTextFieldTime_hour_am_pm.this.setCaretPosition(offset + 1);
                    break;
                case 6:
                    if (ch == 'a' || ch == 'p') {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime_hour_am_pm.this.setText(str);
                        DateTextFieldTime_hour_am_pm.this.setCaretPosition(offset + 1);
                    }
                    break;
                case 7:
                    super.remove(0, datel);
                    str = text.substring(0, offset) + "m" + text.substring(offset + 1);
                    DateTextFieldTime_hour_am_pm.this.setText(str);
                    DateTextFieldTime_hour_am_pm.this.setCaretPosition(offset + 1);
                    break;
//                 case 5:
//                    super.remove(0, datel);
//                    str = text.substring(0, offset)+" " + text.substring(offset+1);
//                    DateTextFieldTime_hour.this.setText(str);
//                    DateTextFieldTime_hour.this.setCaretPosition(offset+1);
//                    break;
//                     
//                case 6:
//                    if(ch == 'a' || ch == 'p'){
//                        super.remove(0, datel);
//                        str = text.substring(0, offset) + ch+ text.substring(offset+1);
//                        DateTextFieldTime_hour.this.setText(str);
//                        DateTextFieldTime_hour.this.setCaretPosition(offset+1);
//                    }
//                    break;
//                    
//                case 7:
//                    if(ch == 'm'){
//                        super.remove(0, datel);
//                        str = text.substring(0, offset) + ch+ text.substring(offset+1);
//                        DateTextFieldTime_hour.this.setText(str);
//                        DateTextFieldTime_hour.this.setCaretPosition(offset+1);
//                    }
//                    break;
                default:
                    return;
            }
        }

        @Override
        public void remove(int offs, int len) throws BadLocationException {
            DateTextFieldTime_hour_am_pm.this.setCaretPosition(offs);
        }
    }

    class MyFocusListener implements FocusListener {
        //  JTextField comp = null;

        public MyFocusListener(JTextField pcomp, String initValue) {
            // comp = pcomp;
        }

        public MyFocusListener(JTextField pcomp) {
            //comp = pcomp;
        }

        public MyFocusListener(String pinitValue) {
            // comp = pcomp;
            focusInitValue = pinitValue;
        }

        public void focusGained(FocusEvent e) {
            //System.out.println("focused gained");
            String ggg = DateTextFieldTime_hour_am_pm.super.getText();
            if (ggg.equalsIgnoreCase(DATEINIT) || ggg.equalsIgnoreCase("")) {
                if (focusInitValue.equalsIgnoreCase("ini")) {
                    focusInitValue = Date_Format.Format_Day_Time(new Date());
                }
                DateTextFieldTime_hour_am_pm.this.setText("");
                DateTextFieldTime_hour_am_pm.this.setText(focusInitValue);
                DateTextFieldTime_hour_am_pm.this.setCaretPosition(0);
            }
        }

        public void focusLost(FocusEvent e) {
        }
    }
}
