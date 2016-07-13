/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.rmiclient.classes.crud.tableReflection;

import java.util.List;

import client.rmiclient.classes.crud.ModelHolder;

/**
 *
 * @author User
 */
public interface BeanParsing {
    
    public void prepare(ModelHolder holder);
    
    public void init();
    
    public List<Column> getColumns();

    public List<List<Object>> getRows();
}
