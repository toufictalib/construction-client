package client.bean;

import org.springframework.beans.BeanUtils;

import client.gui.annotation.TableColumnAnnotation;
import client.gui.annotation.TableColumnComplex;
import client.rmiclient.classes.crud.tableReflection.Column.Complexity;
import desktopadmin.model.person.Customer;
import desktopadmin.model.person.Title;

public class CrudCustomer
{

	@TableColumnAnnotation(id = true, editable = false)
	private Long id;

	@TableColumnAnnotation(editable = true, name = "Name", required = true)
	private String name;

	@TableColumnAnnotation(editable = true, name = "Middle Name", required = true)
	private String middleName;

	@TableColumnAnnotation(editable = true, name = "Last Name", required = true)
	private String lastName;

	@TableColumnAnnotation(editable = true, name = "Phone 1", required = true)
	private String phone1;

	@TableColumnAnnotation(editable = true, name = "Phone 2", required = true)
	private String phone2;

	@TableColumnAnnotation(editable = true, name = "Email", required = true)
	private String email;

	@TableColumnAnnotation(editable = true, name = "Title", required = true)
	@TableColumnComplex(clazz = Title.class, complexity = Complexity.COMPLEX)
	private Title title;

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

	public String getMiddleName( )
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String getLastName( )
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
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

	public Title getTitle( )
	{
		return title;
	}

	public void setTitle(Title title)
	{
		this.title = title;
	}
	
	public static CrudCustomer fromModel(Customer model)
	{
		CrudCustomer fromModel = new CrudCustomer();
		BeanUtils.copyProperties(model, fromModel);
		return fromModel;
	}
	
	public Customer toModel()
	{
		Customer model = new Customer();
		BeanUtils.copyProperties(this, model);
		return model;
	}

	

}
