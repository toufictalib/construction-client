package client.bean;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import client.gui.annotation.TableColumnAnnotation;
import client.gui.annotation.TableColumnComplex;
import client.rmiclient.classes.crud.tableReflection.Column.Complexity;
import desktopadmin.model.accounting.Bank;
import desktopadmin.model.accounting.payment.Check;

public class CrudCheck
{

	@TableColumnAnnotation(id = true, editable = false)
	private Long id;

	@TableColumnAnnotation(editable = true, name = "Bank", required = true)
	@TableColumnComplex(clazz = Bank.class, complexity = Complexity.COMPLEX)
	private Bank bank;

	@TableColumnAnnotation(editable = true, name = "Check #", required = true)
	private Long checkId;

	@TableColumnAnnotation(editable = true, name = "Owner", required = true)
	private String owner;

	@TableColumnAnnotation(editable = true, name = "Note", required = true)
	private String note;

	@TableColumnAnnotation(editable = true, name = "Entilement Date", required = true)
	private Date entilementDate;

	@TableColumnAnnotation(editable = false, name = "Update Date")
	private Date updateDate;

	@TableColumnAnnotation(editable = false, name = "Creation Date")
	private Date creationDate;

	public Long getId( )
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Bank getBank( )
	{
		return bank;
	}

	public void setBank(Bank bank)
	{
		this.bank = bank;
	}

	public Long getCheckId( )
	{
		return checkId;
	}

	public void setCheckId(Long checkId)
	{
		this.checkId = checkId;
	}

	public String getOwner( )
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public String getNote( )
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public Date getEntilementDate( )
	{
		return entilementDate;
	}

	public void setEntilementDate(Date entilementDate)
	{
		this.entilementDate = entilementDate;
	}

	public Date getUpdateDate( )
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}

	public Date getCreationDate( )
	{
		return creationDate;
	}

	public void setCreationDate(Date creationDate)
	{
		this.creationDate = creationDate;
	}

	public CrudCheck(Long id, Bank bank, Long checkId, String owner, String note, Date entilementDate, Date updateDate, Date creationDate)
	{
		super();
		this.id = id;
		this.bank = bank;
		this.checkId = checkId;
		this.owner = owner;
		this.note = note;
		this.entilementDate = entilementDate;
		this.updateDate = updateDate;
		this.creationDate = creationDate;
	}

	public CrudCheck( )
	{
		super();
	}
	
	public static CrudCheck fromCheck(Check check)
	{
		CrudCheck crudCheck = new CrudCheck();
		BeanUtils.copyProperties(check, crudCheck);
		return crudCheck;
	}
	
	public Check toCheck()
	{
		Check check = new Check();
		BeanUtils.copyProperties(this, check);
		return check;
	}
	
	
	

}
