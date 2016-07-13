/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.rmiclient.format;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

import client.layout.Date_Format;

/**
 *
 * @author foo
 */
public class DateTextFieldTime extends JTextField {

    public static String getFirstDay() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return Date_Format.Format_DayDMY(cal.getTime());

    }
    private DateTextFieldTime focusto = null;
    private String focusInitValue = "ini";
    //public static final String DATEINIT = "dd-mm-yyyy";
    //                                    "yyyy-mm-dd HH:mm:ss"
    public static final String DATEINIT = "yyyy-mm-dd HH:mm:ss";

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

    public DateTextFieldTime getFocusto() {
        return focusto;
    }

    public void setFocusto(DateTextFieldTime focusto) {
        this.focusto = focusto;
        focusInitValue = getFirstDay();
    }

    public DateTextFieldTime() {
        super();
        this.setDocument(new MyDocument(this));
        this.addFocusListener(new MyFocusListener(this));
        this.setText(DATEINIT);
    }

    class MyDocument extends javax.swing.text.PlainDocument {

        //int counter = 0;
        int datel = DATEINIT.length();

        public MyDocument(DateTextFieldTime pcomp, DateTextFieldTime pfocusto) {
            // comp = pcomp;
            focusto = pfocusto;
        }

        public MyDocument(JTextField pcomp) {
        }

        @Override
        public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
            String text = DateTextFieldTime.super.getText();
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
                    if (Character.isDigit(ch)) {
                        super.remove(0, datel);
                        str = ch + text.substring(offset + 1);
                        DateTextFieldTime.this.setText(str);
                        DateTextFieldTime.this.setCaretPosition(offset + 1);
                    }
                    break;
                case 1:
                    if (Character.isDigit(ch)) {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime.this.setText(str);
                        DateTextFieldTime.this.setCaretPosition(offset + 1);
                    }
                    break;
                case 2:
                    if (Character.isDigit(ch)) {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime.this.setText(str);
                        DateTextFieldTime.this.setCaretPosition(offset + 1);
                    }
                    break;
                case 3:
                    if (Character.isDigit(ch)) {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime.this.setText(str);
                        DateTextFieldTime.this.setCaretPosition(offset + 2);
//                        
                    }
                    break;
                case 4:
                    super.remove(0, datel);
                    str = text.substring(0, offset) + "-" + text.substring(offset + 1);
                    DateTextFieldTime.this.setText(str);
                    DateTextFieldTime.this.setCaretPosition(offset + 1);
                    break;
                case 5:
                    if (ch == '0' || ch == '1') {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime.this.setText(str);
                        DateTextFieldTime.this.setCaretPosition(offset + 1);
                    }
                    break;
                case 6:
                    if (Character.isDigit(ch)) {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime.this.setText(str);
                        DateTextFieldTime.this.setCaretPosition(offset + 2);
                    }
                    break;
                case 7:
                    super.remove(0, datel);
                    str = text.substring(0, offset) + "-" + text.substring(offset + 1);
                    DateTextFieldTime.this.setText(str);
                    DateTextFieldTime.this.setCaretPosition(offset + 1);
                    break;
                case 8:
                    if (ch == '0' || ch == '1' || ch == '2' || ch == '3') {
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        super.remove(0, datel);
                        //comp.setText(str);
                        //comp.setCaretPosition(1);
                        DateTextFieldTime.this.setText(str);
                        DateTextFieldTime.this.setCaretPosition(offset + 1);
                    }
                    break;
                case 9:
                    if (Character.isDigit(ch)) {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime.this.setText(str);
                        DateTextFieldTime.this.setCaretPosition(offset + 2);

                    }

                    break;
                case 10:
                    super.remove(0, datel);
                    str = text.substring(0, offset) + " " + text.substring(offset + 1);
                    DateTextFieldTime.this.setText(str);
                    DateTextFieldTime.this.setCaretPosition(offset + 1);
                    break;
                case 11:
                    if (ch == '0' || ch == '1' || ch == '2') {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime.this.setText(str);
                        DateTextFieldTime.this.setCaretPosition(offset + 1);
                    }
                    break;
                case 12:
                    if (Character.isDigit(ch)) {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime.this.setText(str);
                        DateTextFieldTime.this.setCaretPosition(offset + 2);
                    }
                    break;
                case 13:
                    super.remove(0, datel);
                    str = text.substring(0, offset) + ":" + text.substring(offset + 1);
                    DateTextFieldTime.this.setText(str);
                    DateTextFieldTime.this.setCaretPosition(offset + 1);
                    break;
                case 14:
                    if (ch == '0' || ch == '1' || ch == '2' || ch == '4' || ch == '5' || ch == '3') {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime.this.setText(str);
                        DateTextFieldTime.this.setCaretPosition(offset + 1);
                    }
                    break;
                case 15:
                    if (Character.isDigit(ch)) {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime.this.setText(str);
                        DateTextFieldTime.this.setCaretPosition(offset + 2);
                    }
                    break;
                case 16:
                    super.remove(0, datel);
                    str = text.substring(0, offset) + ":" + text.substring(offset + 1);
                    DateTextFieldTime.this.setText(str);
                    DateTextFieldTime.this.setCaretPosition(offset + 1);
                    break;
                case 17:
                    if (ch == '0' || ch == '1' || ch == '2' || ch == '4' || ch == '5' || ch == '3') {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime.this.setText(str);
                        DateTextFieldTime.this.setCaretPosition(offset + 1);
                    }
                    break;
                case 18:
                    if (Character.isDigit(ch)) {
                        super.remove(0, datel);
                        str = text.substring(0, offset) + ch + text.substring(offset + 1);
                        DateTextFieldTime.this.setText(str);
                        DateTextFieldTime.this.setCaretPosition(offset + 1);
                    }
                    if (focusto != null) {
                        focusto.requestFocus();
                        //focusto.setText(str);
                    }
                    break;
                default:
                    return;
            }
        }

        @Override
        public void remove(int offs, int len) throws BadLocationException {
            DateTextFieldTime.this.setCaretPosition(offs);
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
            String ggg = DateTextFieldTime.super.getText();
            if (ggg.equalsIgnoreCase(DATEINIT) || ggg.equalsIgnoreCase("")) {
                if (focusInitValue.equalsIgnoreCase("ini")) {
                    focusInitValue = Date_Format.Format_Day_Time(new Date());
                }
                DateTextFieldTime.this.setText("");
                DateTextFieldTime.this.setText(focusInitValue);
                DateTextFieldTime.this.setCaretPosition(0);
            }
        }

        public void focusLost(FocusEvent e) {
        }
    }
}
