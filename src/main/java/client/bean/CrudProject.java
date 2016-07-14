package client.bean;

import java.util.Date;

import client.gui.annotation.TableColumnAnnotation;
import client.gui.annotation.TableColumnComplex;
import client.rmiclient.classes.crud.tableReflection.Column.Complexity;
import desktopadmin.model.building.Address;
import desktopadmin.model.building.Project;
import desktopadmin.model.general.BaseEntity;

public class CrudProject extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6901719528697343918L;

	@TableColumnAnnotation(name = "ID", id = true, editable = false)
	protected Long id;

	@TableColumnAnnotation(name = "Name", editable = true, required = true)
	private String name;

	@TableColumnAnnotation(name="Address",editable=true,required=true)
	@TableColumnComplex(clazz=Address.class,complexity=Complexity.MORE_COMPLEX)
	private Address address;
	
	@TableColumnAnnotation(name="Flat Price/Meter")
	private double flatPriceByMeter;
	
	@TableColumnAnnotation(name="Store Price/Meter")
	private double storePriceByMeter;
	
	@TableColumnAnnotation(name="Warehouse Price/Meter")
	private double warehousePriceByMeter;
	

	@TableColumnAnnotation(name = "Start Date", editable = true, required = true)
	private Date startDate;

	@TableColumnAnnotation(name = "Due Date", editable = true, required = true)
	private Date dueDate;


	
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

	public Address getAddress( )
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public double getFlatPriceByMeter( )
	{
		return flatPriceByMeter;
	}

	public void setFlatPriceByMeter(double flatPriceByMeter)
	{
		this.flatPriceByMeter = flatPriceByMeter;
	}

	public double getStorePriceByMeter( )
	{
		return storePriceByMeter;
	}

	public void setStorePriceByMeter(double storePriceByMeter)
	{
		this.storePriceByMeter = storePriceByMeter;
	}

	public double getWarehousePriceByMeter( )
	{
		return warehousePriceByMeter;
	}

	public void setWarehousePriceByMeter(double warehousePriceByMeter)
	{
		this.warehousePriceByMeter = warehousePriceByMeter;
	}

	public Date getStartDate( )
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getDueDate( )
	{
		return dueDate;
	}

	public void setDueDate(Date dueDate)
	{
		this.dueDate = dueDate;
	}

	public Project toProject()
	{
		Project project = new Project();
		project.setId(id);
		project.setAddress(address);
		project.setFlatPriceByMeter(flatPriceByMeter);
		project.setStorePriceByMeter(storePriceByMeter);
		project.setWarehousePriceByMeter(warehousePriceByMeter);
		project.setName(name);
		project.setStartDate(startDate);
		project.setDueDate(dueDate);
		
		if(address!=null)
		{
		address.setProject(project);
		}
		
		return project;
	}
	
	public static CrudProject fromProject(Project project)
	{
		CrudProject crudProject = new CrudProject();
		crudProject.setId(project.getId());
		crudProject.setAddress(project.getAddress());
		crudProject.setFlatPriceByMeter(project.getFlatPriceByMeter());
		crudProject.setStorePriceByMeter(project.getStorePriceByMeter());
		crudProject.setWarehousePriceByMeter(project.getWarehousePriceByMeter());
		crudProject.setName(project.getName());
		crudProject.setStartDate(project.getStartDate());
		crudProject.setDueDate(project.getDueDate());
		
		return crudProject;
	}
}
