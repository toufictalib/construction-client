/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.rmiclient.classes.crud;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;

import client.gui.button.ButtonFactory;
import client.utils.MessageUtils;
import client.utils.ModelNewPanel;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.ButtonBarFactory;
import com.jgoodies.forms.layout.FormLayout;

/**
 *
 * @author User
 */
public abstract class ExtendedCrudPanel extends JpanelTemplate implements ActionListener, CrudPanel.CrudListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3519685938746048836L;

	protected CrudPanel crudPanel;

    protected JButton btnSave;
    protected JButton btnCancel;
    
    protected String title;

    public ExtendedCrudPanel(String title) {
        this.title = title;
    }

    public void hideButtons()
    {
        btnCancel.setVisible(false);
        btnSave.setVisible(false);
    }
    @Override
    public void init() {

        FormLayout formLayout = new FormLayout("fill:p:grow");
        DefaultFormBuilder builder = new DefaultFormBuilder(formLayout, this);
        builder.setDefaultDialogBorder();

        builder.append(crudPanel);

        builder.appendSeparator();

        builder.append(ButtonBarFactory.buildRightAlignedBar(btnCancel, btnSave));

    }

    @Override
    public void initComponents() {
        this.crudPanel = new CrudPanel()
        {

            /**
			 * 
			 */
			private static final long serialVersionUID = 6755797471176678268L;

			@Override
            protected void refresh() {
                super.refresh(); 
                fillCrudTable();
            }
            
        } 
                ;
        crudPanel.setCrudListener(this);
        crudPanel.lazyInitalize();
       
        
        btnSave = ButtonFactory.createBtnSave();
        btnSave.addActionListener(this);

        btnCancel = ButtonFactory.createBtnCancel();
        btnCancel.addActionListener(this);
        btnCancel.setVisible(false);

        fillCrudTable();

    }

    protected abstract void fillCrudTable();

     public void setTableDimension(Dimension tableDimension) {
        crudPanel.setTableDimension(tableDimension);
    }
     
    @SuppressWarnings("unchecked")
	@Override
    public void add() {
        try {

            Bean bean = new Bean();
            bean.setColumns(crudPanel.getFilterTableFrame().getTableModel().getColumns());
            bean.setRow(new ArrayList<Object>());
            bean.setBeanComplexElement(crudPanel.getFilterTableFrame().getBeanComplexElement());
            bean.setNewRow(true);

            ModelNewPanel modelNewPanel = new ModelNewPanel(bean);
            int ok = DialogUtilities.showOkCancelDialog(getOwner(), modelNewPanel, "New "+title);
            if (ok == DialogUtilities.RESULT_OK) {
                {
                    if (modelNewPanel.isAcceptable()) {
                        crudPanel.getFilterTableFrame().getTableModel().addRow(modelNewPanel.getRow());
                    }
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(CrudPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete() {
    }

    @Override
    public void cancel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> void update(T t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            btnSaveAction();
        } else if (e.getSource() == btnCancel) {
            resetModifications();
        }
    }
    

    protected abstract void btnCancelAction();

    protected abstract void btnSaveAction();

    private void resetModifications() {
            boolean showConfirmationMessage = MessageUtils.showConfirmationMessage(this, "Your changes will be reset.Ok to proceed or Cancel to Keep your changes.", "Warning");
            if (showConfirmationMessage) {
                btnCancelAction();
            }

    }
}
