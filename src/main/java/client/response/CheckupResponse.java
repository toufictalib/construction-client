package client.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import client.gui.annotation.TableColumnAnnotation;

public class CheckupResponse {

    @TableColumnAnnotation(name = "ID", editable = false ,id = true)
    private int id;

    @TableColumnAnnotation(name = "Name",required = true)
    private String name;

    @TableColumnAnnotation(name = "Creation Date", editable = false)
    private Date creationDate;

    public CheckupResponse() {
    }

    public CheckupResponse(int id, String name, Date creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public static List<CheckupResponse> list() {
        List<CheckupResponse> list = new ArrayList<CheckupResponse>();
        for (int i = 1; i <= 5; i++) {
            CheckupResponse response = new CheckupResponse();
            response.setCreationDate(new Date());
            response.setId(i);
            response.setName("Name " + i);

            list.add(response);
        }

        return list;
    }
}
