package client.rmiclient.classes.crud;

import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import client.rmiclient.classes.crud.tableReflection.Column;

/**
 *
 * @author User
 */
public class MyComponent {

    protected Column column;
    protected JComponent component;

    public MyComponent(JComponent component, Column column) {
        this.component = component;
        setColumn(column);
    }
    
    public MyComponent()
    {
        
    }

    public JComponent getComponent() {
        return component;
    }

    public void setComponent(JComponent component) {
        this.component = component;
    }

    public void setColumn(Column column) {
        this.column = column;
          component.setName(column.getName());
    }

    public Object getValue() throws Exception {
        if (column.getType() == Date.class) {
            return ((JXDatePicker) component).getDate();
        } else if (column.getType() == String.class) {
            return ((JTextField) component).getText();
        } else if (column.getType() == Integer.class ||column.getType() == int.class) {
            return Integer.valueOf(((JTextField) component).getText());
        } else if (column.getType() == Double.class || column.getType() == double.class) {
            if (((JTextField) component).getText().length() == 0) {
                return null;
            }
            return Double.valueOf(((JTextField) component).getText());
        }else if(column.getType()==Boolean.class || column.getType()==boolean.class) 
        {
            return ((JCheckBox)component).isSelected();
        }
        
        else if (column.getComplexity()==Column.Complexity.COMPLEX) {
            return ((JComboBox) component).getSelectedItem();
        }
        else if (column.getType() == Long.class ||column.getType() == long.class) {
            return Long.valueOf(((JTextField) component).getText());
        }
        throw new RuntimeException("Unhandled type: " + column.getType());
    }

    public void setValue(Object value) throws Exception {
       
        if(value==null)
            return;
        
        if (column.getType() == Date.class) {
            ((JXDatePicker) component).setDate((Date) value);
        } else if (column.getType() == String.class) {
            ((JTextField) component).setText((String) value);
        } else if (column.getType() == Integer.class || column.getType()==int.class) {
            ((JTextField) component).setText(String.valueOf(value));
        } else if (column.getType() == Double.class || column.getType() == double.class) {
            ((JTextField) component).setText(value == null ? "" : String.valueOf(value));
        } else if (column.getComplexity()==Column.Complexity.COMPLEX) {
            ((JComboBox) component).setSelectedItem(value);
        } 
        else if (column.getType() == Long.class || column.getType()==long.class) {
            ((JTextField) component).setText(String.valueOf(value));
        }
        /*else if (column.getType() == ColumnOneToMany.Holder.class) {
            ((TextExpandableComponent) component).setData(value);
        } */else if (column.getType() == Boolean.class || column.getType()==boolean.class) {
            ((JCheckBox)component).setSelected(Boolean.valueOf(value.toString()));
        } 
        else {
            throw new RuntimeException("Unhandled type: " + column.getType());
        }
    }

    private static JComponent createComponent(Class clazz, Column c) {
        
        if (clazz == Date.class) {
            return new JXDatePicker();
        }
        
        if(c.isComplex())
        {
            return new JComboBox();
        }
        
        if (clazz == Boolean.class||clazz==boolean.class) {
            return new JCheckBox();
        }
        
        if(c.getComplexity()==Column.Complexity.IGNORE)
        {
             return new JTextField();
        }
        
        
        System.err.println("Get default Componetn for class " + clazz);

        return new JTextField();
    }

    public static MyComponent createComponent(Column column) {
//        if (column instanceof ColumnOneToOne) {
//            List data = ((ColumnOneToOne) column).getData();
//            JComboBox combo = new JComboBox(data.toArray());
//            return new MyComponent(combo, column);
//        } else {
        JComponent createdComponent = createComponent(column.getType(), column);
        
        createdComponent.setEnabled(column.isEditable());
        return new MyComponent(createdComponent, column);

    }

    public Column getColumn() {
        return column;
    }
    
    
}
