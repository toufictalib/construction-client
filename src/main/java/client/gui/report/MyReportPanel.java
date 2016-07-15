/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.report;

import java.util.List;

import client.rmiclient.classes.crud.BeanTableModel;
import client.rmiclient.classes.crud.ExtendedCrudPanel;
import client.rmiclient.classes.crud.ModelHolder;

/**
 *
 * @author User
 */
public class MyReportPanel extends ExtendedCrudPanel {

    private List data;

    public MyReportPanel(String title) {
        super(title);
    }

    public MyReportPanel() {
        this("Report");
    }

    @Override
    public void initComponents() {
        super.initComponents();
        crudPanel.hideAllButtons();
        crudPanel.showRefreshButton();
        hideButtons();

        crudPanel.allowUpdate(false);
    }

    @Override
    protected void fillCrudTable() {

/*        Petition.getClients().setListener(new BaseListener<Clients>(getOwner()) {

            @Override
            protected void handleSuccess(Clients response) {
                super.handleSuccess(response);
                setData(response.getClients());
            }

        }).buildAndRun();
*/
    }

    public void setData(List data) {
        this.data = data;
        crudPanel.fillValues(new ModelHolder(getData(), data.isEmpty() ? Object.class : data.get(0).getClass()));
    }

    public void setData(BeanTableModel beanTableModel) {
        this.data = beanTableModel.getRows();
        crudPanel.fillValues(beanTableModel);
    }

    public List getData() {
        if (data != null) {
            return data;
        }
        throw new UnsupportedOperationException("Please Extends this class to fill table data");
    }

    @Override
    protected void btnCancelAction() {
    }

    @Override
    protected void btnSaveAction() {

    }

}
