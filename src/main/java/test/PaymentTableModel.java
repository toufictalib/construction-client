package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import desktopadmin.model.accounting.Bank;
import desktopadmin.model.accounting.EnumType.Currency;
import desktopadmin.model.accounting.EnumType.PaymentType;
import desktopadmin.model.accounting.payment.Check;

public class PaymentTableModel extends AbstractTableModel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6696564921841094355L;

	private List<PaymentBean> rows;

	private final static int COL_PAYMENT_TYPE = 0;

	private final static int COL_VALUE = 1;

	private final static int COL_CURRENCY = 2;

	private final static int COL_DOLLAR = 3;

	private final static int COL_CONVERTED_VALUE = 4;

	private final static int COL_BANK = 5;

	private final static int COL_CHECK = 6;

	private String[] cols = {
	"Payment Type", "Value", "Currency", "Dollar($) To LBP(L.L)", "Converted Value", "Bank", "Check"
	};

	private Class<?>[] classes = {
	PaymentType.class, Double.class, Currency.class, Double.class, Double.class, Bank.class, Check.class
	};

	public PaymentTableModel( )
	{
		rows = new ArrayList<PaymentBean>();

	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{

		switch (columnIndex)
		{
			case COL_CHECK:
				PaymentBean bean = rows.get(rowIndex);
				return bean.needCheck();
			case COL_CONVERTED_VALUE:
			case COL_DOLLAR:
				return false;
			default:
				break;
		}

		return true;
	}

	@Override
	public int getRowCount( )
	{
		return rows.size();
	}

	@Override
	public int getColumnCount( )
	{
		return cols.length;
	}

	@Override
	public String getColumnName(int column)
	{
		return cols[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex)
	{

		return classes[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		PaymentBean bean = rows.get(rowIndex);
		switch (columnIndex)
		{
			case COL_BANK:
				return bean.getBank();
			case COL_CURRENCY:
				return bean.getCurrency();
			case COL_DOLLAR:
				return bean.getDollarPrice();
			case COL_PAYMENT_TYPE:
				return bean.getPaymentType();
			case COL_VALUE:
				return bean.getValue();
			case COL_CONVERTED_VALUE:
				return bean.getConvertedValue();
			case COL_CHECK:
				return bean.getCheck();
			default:
				break;
		}

		return null;

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	{
		PaymentBean bean = rows.get(rowIndex);
		switch (columnIndex)
		{
			case COL_BANK:
				bean.setBank((Bank) aValue);
				break;
			case COL_CURRENCY:
				bean.setCurrency((Currency) aValue);
				break;
			case COL_DOLLAR:
				bean.setDollarPrice(aValue == null ? 0 : Double.valueOf(aValue.toString()));
				break;
			case COL_PAYMENT_TYPE:
				bean.setPaymentType((PaymentType) aValue);
				break;
			case COL_VALUE:
				bean.setValue(aValue == null ? 0 : Double.valueOf(aValue.toString()));
				break;
			case COL_CHECK:
				bean.setCheck((Check) aValue);
				break;
			default:

				break;
		}

		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public void addRow(PaymentBean paymentBean)
	{
		rows.add(paymentBean);
		fireTableRowsInserted(rows.size() - 1, rows.size() - 1);
	}

	public void deleteRows(int[] selectedRows)
	{
		Arrays.sort(selectedRows);

		for (int i = selectedRows.length - 1; i >= 0; i-- )
		{
			rows.remove(selectedRows[i]);
		}

		fireTableStructureChanged();
	}

	public List<PaymentBean> getRows( )
	{
		return rows;
	}

	public void setRows(List<PaymentBean> rows)
	{
		this.rows = rows;
	}

}
