package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import desktopadmin.model.stock.Item;
import desktopadmin.model.stock.Product;
import desktopadmin.utils.ConverterUtils;

public class StockTableModel extends AbstractTableModel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6696564921841094355L;

	private List<Item> rows;

	private final static int COL_PRODUCT = 0;

	private final static int COL_UNIT = 1;

	private final static int COL_QUANTITY = 2;

	private final static int COL_PRICE = 3;

	public final static int COL_SUB_TOTAL = 4;

	private String[] cols = {
	"PRODUCT", "UNIT", "QUANTITY", "PRICE($)", "SUB TOTAL"
	};

	private Class<?>[] classes = {
	Product.class, String.class, Double.class, Double.class, Double.class
	};

	public StockTableModel( )
	{
		rows = new ArrayList<Item>();

	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{

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
		Item bean = rows.get(rowIndex);
		switch (columnIndex)
		{
			case COL_PRODUCT:
				return bean.getProduct();
			case COL_UNIT:
				return bean.getUnit();
			case COL_QUANTITY:
				return bean.getQuantity();
			case COL_PRICE:
				return bean.getPrice();
			case COL_SUB_TOTAL:
				return getSubTotal(bean.getPrice(), bean.getQuantity());
			default:
				break;
		}

		return null;

	}

	private Double getSubTotal(Double price, Double quantity)
	{
		if (price != null && quantity != null) return price * quantity;
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	{
		Item bean = rows.get(rowIndex);
		switch (columnIndex)
		{
			case COL_PRODUCT:
				bean.setProduct((Product) aValue);
				break;
			case COL_QUANTITY:

				bean.setQuantity(ConverterUtils.toDoubleWithOutException(aValue));
				break;
			case COL_PRICE:
				bean.setPrice(ConverterUtils.toDoubleWithOutException(aValue));
				break;
			default:

				break;
		}

		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public void addRow(Item newRow)
	{
		rows.add(newRow);
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

	public List<Item> getRows( )
	{
		return rows;
	}

	public void setRows(List<Item> rows)
	{
		this.rows = rows;
	}

}
