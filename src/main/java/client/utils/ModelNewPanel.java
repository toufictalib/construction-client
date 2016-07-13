/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.utils;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import client.gui.combobox.ComboboxUtils;
import client.rmiclient.classes.crud.Acceptable;
import client.rmiclient.classes.crud.Bean;
import client.rmiclient.classes.crud.MyComponent;
import client.rmiclient.classes.crud.tableReflection.Column;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Sherif elKhatib
 */
public class ModelNewPanel extends javax.swing.JPanel implements Acceptable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6433868569337226746L;

	private Map<String, MyComponent> map = new HashMap<String, MyComponent>();

    private Bean bean;

    /**
     * Creates new form ModelNewPanel
     *
     * @param bean
     * @throws java.lang.IllegalAccessException
     */
    @SuppressWarnings({
	"rawtypes", "unchecked"
	})
	public ModelNewPanel(Bean bean) throws IllegalAccessException, Exception {
        super(new BorderLayout());

        this.bean = bean;

        initComponents();

        FormLayout formLayout = new FormLayout("p,10dlu,fill:p:grow");
        DefaultFormBuilder builder = new DefaultFormBuilder(formLayout, this);
        builder.setDefaultDialogBorder();

        for (int i = 0; i < bean.getColumns().size(); i++) {

            Column column = bean.getColumn(i);

            if (bean.isNewRow() && column.ignoreField()) {
                continue;
            }
            MyComponent component =null;
            if(column.getComplexity()==Column.Complexity.MORE_COMPLEX)
            {
                component = bean.getBeanComplexElement().getComponent(column.getFieldName());
                component.setColumn(column);
            }
            else
            {
                 component = MyComponent.createComponent(column);
            }
            map.put(component.getComponent().getName(), component);
            JLabel l = new JLabel("<html>" + column.getName() + (column.isRequired() ? " <font color=\"red\">*</font>" : "") + "</html>", JLabel.LEADING);
           
            if(component.getColumn().isComplex())
            {
                JComboBox box = (JComboBox) component.getComponent();
                Object[] toArray = bean.getBeanComplexElement().getItems(component.getColumn().getFieldName()).toArray();
                box.setModel(new DefaultComboBoxModel(toArray));
                ComboboxUtils.installAutoCompleteSupport(box, Arrays.asList(toArray));
            }
            
            component.setValue(bean.getValue(i));

            builder.append(l);
            builder.append(component.getComponent());

        }

    }

    public List<Object> getRow() throws Exception {

        List<Object> row = new ArrayList<Object>();

        for (Column column : bean.getColumns()) {
            MyComponent myComponent = map.get(column.getName());
            if(myComponent==null)
            {
                System.out.println(column.getName()+" hasn't any component");
            }
            
            try
            {
            row.add(myComponent==null ? null : myComponent.getValue());
            }catch(Exception e)
            {
                row.add(null);
                System.err.println(e.getMessage());
            }
        }
        return row;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    // End of variables declaration                   
    @Override
    public boolean isAcceptable() {

        try {
            for (MyComponent component : map.values()) {
                if (component.getColumn().isRequired()) {
                    if (component.getValue() == null || component.getValue().toString().length() == 0) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}