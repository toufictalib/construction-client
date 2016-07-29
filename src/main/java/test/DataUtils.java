package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import client.bean.CrudProject;
import desktopadmin.model.accounting.Bank;
import desktopadmin.model.accounting.EnumType.Payer;
import desktopadmin.model.accounting.TransactionCause;
import desktopadmin.model.accounting.payment.Check;
import desktopadmin.model.building.Project;
import desktopadmin.model.person.Title;

public class DataUtils
{
	
	private static List<Check> checks;
	
	private static List<TransactionCause> transactionCauses;
	
	private static Project selectedProject;
	
	public final static int MAX_ROWS = 1000;
	
	

	public static List<Check> getChecks(Bank bank)
	{
		
		return checks.stream().filter(e->e.getBank().equals(bank)).collect(Collectors.toList());
	}

	public static void setChecks(List<Check> checks)
	{
		DataUtils.checks = checks;
	}
	
	

	

	public static List<TransactionCause> getTransactionCauses( )
	{
		return transactionCauses;
	}

	public static void setTransactionCauses(List<TransactionCause> transactionCauses)
	{
		DataUtils.transactionCauses = transactionCauses;
	}

	public static Project getSelectedProject( )
	{
		return selectedProject;
	}
	
	public static Long getSelectedProjectId()
	{
		return selectedProject.getId();
	}

	public static void setSelectedProject(Project selectedProject)
	{
		DataUtils.selectedProject = selectedProject;
	}

	public static List<Bank> banks( )
	{
		List<Bank> banks = new ArrayList<>();
		String[] bankst = {
		"Fransabank", "Med", "BLC", "BLOM","JAMMAL"
		};
		for (int i = 1; i <= 5; i++ )
		{
			Bank bank = new Bank();
			bank.setId(Long.valueOf(i + ""));
			bank.setName(bankst[i - 1]);

			banks.add(bank);
		}

		return banks;
	}

	public static List<TransactionCause> transactionCauses(Payer payer)
	{
		return transactionCauses.stream()
				.filter(e->e.getPayer()==payer)
				.collect(Collectors.toList());
	}

	public static List<Title> titles( )
	{
		List<Title> list = new ArrayList<Title>();
		list.add(new Title("Soldier"));
		list.add(new Title("Teacher"));
		list.add(new Title("BusinessMan"));
		list.add(new Title("Private Employee"));
		list.add(new Title("Engineer"));

		return list;
	}

	public static List<CrudProject> projects( )
	{
		List<CrudProject> crudCustomers = new ArrayList<>();
		for (int i = 1; i < 10; i++ )
		{
			CrudProject crudProject = new CrudProject();
			crudProject.setId(i * 10L);
			crudProject.setName("Project 1");

			crudCustomers.add(crudProject);

		}
		return crudCustomers;
	}
}
