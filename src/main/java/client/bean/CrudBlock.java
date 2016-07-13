package client.bean;

import client.gui.annotation.TableColumnAnnotation;
import client.gui.annotation.TableColumnComplex;
import client.rmiclient.classes.crud.tableReflection.Column.Complexity;
import desktopadmin.model.building.Block;
import desktopadmin.model.building.Project;

public class CrudBlock
{

	@TableColumnAnnotation(id = true, editable = false)
	private Long id;

	@TableColumnAnnotation(name = "Name", editable = true)
	private String name;

	@TableColumnAnnotation(name = "Number of Floor", editable = true)
	private int floorNb;

	@TableColumnAnnotation(name = "Number of Flat/Floor", editable = true)
	private int nbFlatPerFloor;

	@TableColumnAnnotation(name = "Number of Flat", editable = true)
	private int flatNb;

	@TableColumnAnnotation(name = "Number of Store", editable = true)
	private int storeNb;

	@TableColumnAnnotation(name = "Number of Warehouse", editable = true)
	private int warehouseNb;

	@TableColumnAnnotation(name = "Project", editable = true)
	@TableColumnComplex(complexity = Complexity.COMPLEX, clazz = Project.class)
	private Project project;

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

	public int getFloorNb( )
	{
		return floorNb;
	}

	public void setFloorNb(int floorNb)
	{
		this.floorNb = floorNb;
	}

	public int getNbFlatPerFloor( )
	{
		return nbFlatPerFloor;
	}

	public void setNbFlatPerFloor(int nbFlatPerFloor)
	{
		this.nbFlatPerFloor = nbFlatPerFloor;
	}

	public int getFlatNb( )
	{
		return flatNb;
	}

	public void setFlatNb(int flatNb)
	{
		this.flatNb = flatNb;
	}

	public int getStoreNb( )
	{
		return storeNb;
	}

	public void setStoreNb(int storeNb)
	{
		this.storeNb = storeNb;
	}

	public int getWarehouseNb( )
	{
		return warehouseNb;
	}

	public void setWarehouseNb(int warehouseNb)
	{
		this.warehouseNb = warehouseNb;
	}

	public Project getProject( )
	{
		return project;
	}

	public void setProject(Project project)
	{
		this.project = project;
	}

	public static CrudBlock fromBlock(Block block)
	{
		CrudBlock crudBlock = new CrudBlock();
		crudBlock.setId(block.getId());
		crudBlock.setFlatNb(block.getFlatNb());
		crudBlock.setFloorNb(block.getFloorNb());
		crudBlock.setName(block.getName());
		crudBlock.setNbFlatPerFloor(block.getNbFlatPerFloor());
		crudBlock.setProject(block.getProject());
		crudBlock.setStoreNb(block.getStoreNb());
		crudBlock.setWarehouseNb(block.getWarehouseNb());

		return crudBlock;

	}

	public Block toBlock( )
	{
		CrudBlock crudBlock = this;
		Block block = new Block();
		block.setId(crudBlock.getId());
		block.setFlatNb(crudBlock.getFlatNb());
		block.setFloorNb(crudBlock.getFloorNb());
		block.setName(crudBlock.getName());
		block.setNbFlatPerFloor(crudBlock.getNbFlatPerFloor());
		block.setProject(crudBlock.getProject());
		block.setStoreNb(crudBlock.getStoreNb());
		block.setWarehouseNb(crudBlock.getWarehouseNb());

		return block;

	}

}
