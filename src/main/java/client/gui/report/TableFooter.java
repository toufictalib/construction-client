package client.gui.report;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;

public class TableFooter  {
    private JTable table;
    private JTable filterRow;
    public JPanel panel;
    private Color HeaderColor = Color.getHSBColor(0, 0, (float)0.93);

    private Map<JTable, TableColumnModelListener> map;
    
public TableFooter(JTable mytable) {
	 panel = new JPanel();
}

public void init(JTable mytable)
{
	
	 table = mytable;
	    table.setPreferredScrollableViewportSize(table.getPreferredSize());
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBorder(BorderFactory.createMatteBorder(1,1,0,0,Color.GRAY));
	     
	    filterRow = new JTable();
	    filterRow.setSelectionBackground(null);
	    filterRow.setSelectionForeground(Color.BLACK);
        
	 map = new HashMap<JTable, TableColumnModelListener>();
	    
	  
	    
	   

	   
	    
	    filterRow.setModel(new DefaultTableModel(1,table.getModel().getColumnCount())
        {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        }
        );
	    TableColumnModelListener columnListener1 = new ColumnChangeListener(table, filterRow, map);
	    TableColumnModelListener  columnListener2 = new ColumnChangeListener(filterRow, table, map);
	    map.put(table, columnListener1);
	    map.put(filterRow, columnListener2);
	    
	    table.getColumnModel().addColumnModelListener(columnListener1);
	    filterRow.getColumnModel().addColumnModelListener(columnListener2);
	    
	   
	    
	   
	    //  Panel for text fields
	   
	 
	    panel.removeAll();
	   
	    panel.setLayout(new BorderLayout());
	    panel.add(scrollPane, BorderLayout.CENTER);
	    panel.add(filterRow, BorderLayout.SOUTH);
	    panel.revalidate();
	    panel.repaint();
}

//  Implement TableColumnModelListener methods
//  (Note: instead of implementing a listener you should be able to
//  override the columnMarginChanged and columMoved methods of JTable)
/*@Override
public void columnMarginChanged(ChangeEvent e) {
    TableColumnModel tcm = table.getColumnModel();
    int columns = tcm.getColumnCount();

    if(columns>0)
    {
    	filterRow.removeAll();
    	 for (int i = 0; i < table.getColumnCount(); i++) {
		        JTextField temp = new JTextField(" Sum at - " + i);

		        if(i==0){
		            temp.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.GRAY));
		        }else{
		            temp.setBorder(BorderFactory.createMatteBorder(1,0,1,1,Color.GRAY));
		        }




		        temp.setHorizontalAlignment(JTextField.CENTER);
		        temp.setBackground(HeaderColor);
		        filterRow.add(temp);
		    }
    }
    for (int i = 0; i < columns; i++) {
        JTextField textField = (JTextField) filterRow.getComponent(i);
        textField.setEditable(false);
        textField.setSelectionColor(HeaderColor);
        Dimension d = textField.getPreferredSize();
        if(i==0){
        d.width = tcm.getColumn(i).getWidth()+1;
        }else{
        d.width = tcm.getColumn(i).getWidth();    
        }
        textField.setPreferredSize(d);
    }

    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            filterRow.revalidate();
        }
    });
}

@Override
public void columnMoved(TableColumnModelEvent e) {
    Component moved = filterRow.getComponent(e.getFromIndex());
    filterRow.remove(e.getFromIndex());
    filterRow.add(moved, e.getToIndex());
    filterRow.validate();
}

@Override
public void columnAdded(TableColumnModelEvent e) {
}

@Override
public void columnRemoved(TableColumnModelEvent e) {
}

@Override
public void columnSelectionChanged(ListSelectionEvent e) {
}*/


 public JPanel getPanel( )
{
	 if(panel==null)
	 {
		 return new JPanel();
	 }
	return panel;
}

public static void main(String[] args) {
    TableFooter panel = new TableFooter(new JTable(10, 5));
    //frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    JFrame frame = new JFrame();
    frame.setContentPane(panel.panel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
 }
}