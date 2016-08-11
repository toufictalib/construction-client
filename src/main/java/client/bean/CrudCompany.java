package client.bean;

import org.springframework.beans.BeanUtils;

import client.gui.annotation.TableColumnAnnotation;
import desktopadmin.model.person.Company;

public class CrudCompany
{

	@TableColumnAnnotation(id = true, editable = false)
	private Long id;

	@TableColumnAnnotation(editable = true, name = "Name", required = true)
	private String name;

	@TableColumnAnnotation(editable = true, name = "Phone 1", required = true)
	private String phone1;

	@TableColumnAnnotation(editable = true, name = "Phone 2")
	private String phone2;

	@TableColumnAnnotation(editable = true, name = "Email", required = true)
	private String email;

	@TableColumnAnnotation(editable = true, name = "Note")
	private String note;

	public Long getId( )
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName( )
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPhone1( )
	{
		return phone1;
	}

	public void setPhone1(String phone1)
	{
		this.phone1 = phone1;
	}

	public String getPhone2( )
	{
		return phone2;
	}

	public void setPhone2(String phone2)
	{
		this.phone2 = phone2;
	}

	public String getEmail( )
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getNote( )
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public static CrudCompany fromModel(Company model)
	{
		CrudCompany fromModel = new CrudCompany();
		BeanUtils.copyProperties(model, fromModel);
		return fromModel;
	}
	
	public Company toModel()
	{
		Company model = new Company();
		BeanUtils.copyProperties(this, model);
		return model;
	}
}
