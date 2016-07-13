/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.rmiclient.classes.crud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class BeanComplexElement {
    private Map<String/*fieldName*/, List> map;
    private Map<String,MyComponent> components;
    
    public BeanComplexElement()
    {
        this.map = new HashMap<String, List>();
        this.components = new HashMap<String, MyComponent>();
    }
    
    public void addObjects(String fieldName,List objects)
    {
        map.put(fieldName, objects);
    }
    
    public List getItems(String fieldName)
    {
        return map.get(fieldName);
    }
    

    public void addComponent(String fieldName,MyComponent component)
    {
        components.put(fieldName, component);
    }
    
    public MyComponent getComponent(String fieldName)
    {
        return components.get(fieldName);
    }
    
    
}
