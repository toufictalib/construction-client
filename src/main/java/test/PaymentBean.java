package test;

import desktopadmin.model.accounting.Bank;
import desktopadmin.model.accounting.EnumType.Currency;
import desktopadmin.model.accounting.EnumType.PaymentType;
import desktopadmin.model.accounting.payment.Check;

public class PaymentBean
{
	private PaymentType paymentType = PaymentType.CASH;

	protected double value;

	private Currency currency = Currency.DOLLAR;

	private double dollarPrice = OurPreferences.DOLLAR_VALUE;

	private double convertedValue;

	private Bank bank;

	private Check check;

	public PaymentBean( )
	{
		super();
	}

	public PaymentBean(PaymentType paymentType, double value, Currency currency, double dollarPrice, Bank bank, Check check)
	{
		super();
		this.paymentType = paymentType;
		this.value = value;
		this.currency = currency;
		this.dollarPrice = dollarPrice;
		this.bank = bank;
		this.check = check;
	}

	public PaymentType getPaymentType( )
	{
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType)
	{
		this.paymentType = paymentType;
	}

	public double getValue( )
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}

	public Currency getCurrency( )
	{
		return currency;
	}

	public void setCurrency(Currency currency)
	{
		this.currency = currency;
	}

	public double getDollarPrice( )
	{
		return dollarPrice;
	}

	public void setDollarPrice(double dollarPrice)
	{
		this.dollarPrice = dollarPrice;
	}

	public double getConvertedValue( )
	{
		if (currency == Currency.LBP && dollarPrice != 0)
		{
			convertedValue =  value / dollarPrice;
		}
		else
			convertedValue = value;
		return convertedValue;
	}

	public void setConvertedValue(double convertedValue)
	{
		this.convertedValue = convertedValue;
	}

	public Bank getBank( )
	{
		return bank;
	}

	public void setBank(Bank bank)
	{
		this.bank = bank;
	}

	public Check getCheck( )
	{
		return check;
	}

	public void setCheck(Check check)
	{
		this.check = check;
	}
	
	public boolean needCheck( )
	{
		return paymentType == PaymentType.CHECK || paymentType == PaymentType.INNER_CHECK;
	}

}
