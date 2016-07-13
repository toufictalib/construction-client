/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.rmiclient.classes.crud;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

/**
 *
 * @author User
 */
public class RadioYesNoPanel extends JpanelTemplate {

    private JRadioButton radioBtnYes;
    private JRadioButton radioBtnNo;

    private boolean selected;

    public RadioYesNoPanel(boolean selected) {
        this.selected = selected;
        lazyInitalize();
    }

    @Override
    public void init() {
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("fill:p:grow,10dlu,fill:p:grow"), this);
        builder.append(radioBtnYes);
        builder.append(radioBtnNo);
    }

    @Override
    public void initComponents() {
        radioBtnYes = new JRadioButton("Yes");
        radioBtnNo = new JRadioButton("No");
        
        if(selected)
        {
            radioBtnYes.setSelected(true);
        }
        else
        {
            radioBtnNo.setSelected(true);
        }
        
        ButtonGroup group = new ButtonGroup();
        group.add(radioBtnYes);
        group.add(radioBtnNo);
    }

    public boolean isSelected() {
        return radioBtnYes.isSelected();
    }
    
    public void enableValues(boolean enable) {
        radioBtnNo.setEnabled(enable);
        radioBtnYes.setEnabled(enable);
    }

}
