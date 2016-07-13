/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.rmiclient.classes.crud;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import client.gui.button.ButtonFactory;
import client.gui.table.utils.TableUtils;
import client.rmiclient.classes.crud.tableReflection.BeanParsing;
import client.rmiclient.classes.crud.tableReflection.Column;
import client.utils.MessageUtils;
import client.utils.ModelNewPanel;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.ButtonBarFactory;
import com.jgoodies.forms.layout.FormLayout;

/**
 *
 * @author User
 */
public class CrudPanel extends JpanelTemplate implements ActionListener, Acceptable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7996975849645358145L;

	private FilterTableFrame filterTableFrame;
    
    public static final String ADD = "Add";
    public static final String DELETE = "Delete";
    public static final String UPDATE = "Update";

    private JButton btnRefresh;
    private JButton btnDelete;
    private JButton btnAdd;

    protected CrudListener crudListener;

    private ModelNewPanel modelNewPanel;

    private boolean addSeperator = true;
    
    public CrudPanel() {
    }

    @Override
    public void lazyInitalize() {
        if (crudListener == null) {
            throw new IllegalArgumentException("CrudListener should be filled in CrudPanel");
        }

        super.lazyInitalize();

    }

    @Override
    public void init() {

        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("p,10dlu,fill:p:grow", ""), this);
        builder.setDefaultDialogBorder();

        if(addSeperator)
        {
        builder.appendSeparator("Manage");
        }
        
        builder.append(ButtonBarFactory.buildLeftAlignedBar(btnRefresh));
        builder.append(ButtonBarFactory.buildRightAlignedBar(btnDelete, btnAdd));

        builder.appendSeparator();
        builder.append(filterTableFrame,3);

    }

    @Override
    public void initComponents() {

        this.filterTableFrame = new FilterTableFrame();

        btnAdd = ButtonFactory.createBtnAdd();
        btnAdd.addActionListener(this);

        btnDelete =ButtonFactory.createBtnDelete();
        btnDelete.addActionListener(this);


        btnRefresh = client.gui.button.ButtonFactory.createBtnRefresh();
        btnRefresh.addActionListener(this);
        
        //keys
       
        final KeyStroke deleteStroke = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0, false);
        final KeyStroke addStroke = KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0, false);
        
         TableUtils.registerKeyboardAction(filterTableFrame.getTable(),createKeyActions(DELETE), DELETE, deleteStroke, JComponent.WHEN_FOCUSED);
        // table.registerKeyboardAction(generateWeeksAction, "Generate Weeks", generateWeeksStroke, JComponent.WHEN_FOCUSED);
        TableUtils.registerKeyboardAction(filterTableFrame.getTable(), createKeyActions(ADD) ,ADD, addStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

     public void setTableDimension(Dimension tableDimension) {
        getFilterTableFrame().setTableDimension(tableDimension);
    }
     
    public void addSeperator(boolean addSeperator)
    {
        this.addSeperator = addSeperator;
    }
    
    protected ModelNewPanel createModelNewPanel(Bean bean) throws Exception {
        return new ModelNewPanel(bean);
    }
     
    private AbstractAction createKeyActions(final String command) {
        return new AbstractAction() {
            
            /**
			 * 
			 */
			private static final long serialVersionUID = 110801617528657643L;

			@Override
            public void actionPerformed(ActionEvent e) {
                if(ADD.equals(command))
                {
                    
                }
                else if(UPDATE.equals(command))
                {
                 
                }
                else if(DELETE.equals(command))
                {
                    btnDelete.doClick();
                }
                
            }
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            btnAddAction();
        } else if (e.getSource() == btnDelete) {
            btnDeleteAction();
            crudListener.delete();

        } 
        else if(e.getSource() == btnRefresh)
        {
            refresh();
        }

    }

    @SuppressWarnings("rawtypes")
	public <T> void fillValues(ModelHolder holder) {
        fillValues(new BeanTableModel(holder));
    }
    
    @SuppressWarnings("rawtypes")
	public <T> void fillValues(BeanTableModel beanTableModel) {
        filterTableFrame.fillValues(beanTableModel);
    }
    
    @SuppressWarnings("rawtypes")
	public <T> void fillValues(ModelHolder holder,BeanParsing beanParsing) {
        fillValues(new BeanTableModel(holder,beanParsing));
    }

    public void setCrudListener(CrudListener crudListener) {
        this.crudListener = crudListener;
    }

    
     public void hideAdd() {
        btnAdd.setVisible(false);
    }
     
     public void hideAllButtons() {
        btnAdd.setVisible(false);
        btnDelete.setVisible(false);
        btnRefresh.setVisible(false);
    }
    
     public void showRefreshButton()
     {
         btnRefresh.setVisible(true);
     }
     
     public void enableAdd() {
        btnAdd.setEnabled(false);
    }
     

    private void btnAddAction() {
        crudListener.add();
    }

    private void btnDeleteAction() {
        
        if(filterTableFrame.getTable().getSelectedRows().length>0)
        {
        boolean delete = MessageUtils.showConfirmationMessage(getOwner(), "Are you sure to delete selected rows?", "Deleting Items");
        if (delete) {
            filterTableFrame.deleteSelectedRows();
        }}
    }

    @Override
    public boolean isAcceptable() {
        return modelNewPanel.isAcceptable();
    }

    @SuppressWarnings("unchecked")
	public List<Column> getColumns() {
        return filterTableFrame.getTableModel().getColumns();
    }

    /**
     * return all values into table after taking all needed modifications
     *
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
	public <T> List<T> getResult(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        return filterTableFrame.getTableModel().revert(clazz);
    }

    public void allowUpdate(boolean allowUpdate)
    {
        filterTableFrame.setAllowUpdate(allowUpdate);
    }
    
     public void setBeanComplexElement(BeanComplexElement beanComplexElement) {
        filterTableFrame.setBeanComplexElement(beanComplexElement);
    }
     
     public BeanComplexElement getBeanComplexElement()
     {
    	 return filterTableFrame.getBeanComplexElement();
     }
     

    public FilterTableFrame getFilterTableFrame() {
        return filterTableFrame;
    }

    protected void refresh() {
        
    }

    
     
    public interface CrudListener {

        public void add();

        public void delete();

        public void cancel();

        public <T> void update(T t);
        
        
    }

}
