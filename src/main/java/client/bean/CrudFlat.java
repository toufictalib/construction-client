package client.bean;

import client.gui.annotation.TableColumnAnnotation;
import client.gui.annotation.TableColumnComplex;
import client.rmiclient.classes.crud.tableReflection.Column.Complexity;
import desktopadmin.model.accounting.EnumType.Direction;
import desktopadmin.model.building.Block;

public class CrudFlat
{
	/**
	 * 
	 */

	@TableColumnAnnotation(id = true)
	private Long id;

	@TableColumnAnnotation(name = "description")
	protected String description;

	@TableColumnAnnotation(name = "floor")
	protected int floor;

	@TableColumnAnnotation(name = "price")
	protected double price;

	@TableColumnAnnotation(name = "area")
	protected int area;

	@TableColumnAnnotation(name = "block", editable = true)
	@TableColumnComplex(complexity = Complexity.COMPLEX, clazz = Block.class)
	protected Block block;
	
	@TableColumnAnnotation(name = "Direction", editable = true)
	@TableColumnComplex(complexity = Complexity.COMPLEX, clazz = Direction.class)
	private Direction direction;

	public String getDescription( )
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getFloor( )
	{
		return floor;
	}

	public void setFloor(int floor)
	{
		this.floor = floor;
	}

	public double getPrice( )
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getArea( )
	{
		return area;
	}

	public void setArea(int area)
	{
		this.area = area;
	}

	public Block getBlock( )
	{
		return block;
	}

	public void setBlock(Block block)
	{
		this.block = block;
	}

	public Long getId( )
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Direction getDirection( )
	{
		return direction;
	}

	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}
	
	
	

}
