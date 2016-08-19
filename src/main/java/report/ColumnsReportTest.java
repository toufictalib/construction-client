   /*
    * DynamicJasper: A library for creating reports dynamically by specifying
    * columns, groups, styles, etc. at runtime. It also saves a lot of development
    * time in many cases! (http://sourceforge.net/projects/dynamicjasper)
    *
    * Copyright (C) 2008  FDV Solutions (http://www.fdvsolutions.com)
    *
    * This library is free software; you can redistribute it and/or
    * modify it under the terms of the GNU Lesser General Public
   *
   * License as published by the Free Software Foundation; either
   *
   * version 2.1 of the License, or (at your option) any later version.
   *
   * This library is distributed in the hope that it will be useful,
   * but WITHOUT ANY WARRANTY; without even the implied warranty of
   *
   * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
   *
   * Lesser General Public License for more details.
   *
   * You should have received a copy of the GNU Lesser General Public
   * License along with this library; if not, write to the Free Software
   *
   * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
   *
   *
   */
  
  package report;
  
  
  import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DJCalculation;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import ar.com.fdvs.dj.domain.builders.GroupBuilder;
import ar.com.fdvs.dj.domain.entities.DJGroup;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;
import ar.com.fdvs.dj.domain.entities.columns.PropertyColumn;

  
  public class ColumnsReportTest {
  
  	public DynamicReport buildReport() throws Exception {
  
  
  		/**
  		 * Creates the DynamicReportBuilder and sets the basic options for
  		 * the report
  		 */
  		
  		AbstractColumn columnAmount = ColumnBuilder.getNew()
  		        .setColumnProperty("amount", Float.class.getName())
  		        .setTitle("Amount")
  		        .setPattern("$ 0.00")		//defines a pattern to apply to the values swhown (uses TextFormat)
  		        .build();

  		
		GroupBuilder gb1 = new GroupBuilder();
		DJGroup djGroup = gb1.setCriteriaColumn((PropertyColumn) columnAmount)
				.addFooterVariable(columnAmount, DJCalculation.SUM)
				//.setGroupLayout(GroupLayout.DEFAULT_WITH_HEADER)

		.build();

       /* GroupBuilder gb2 = new GroupBuilder();                                        //Create another group (using another column as criteria)
        ColumnsGroup g2 = gb2.setCriteriaColumn((PropertyColumn) columnBranch)        //and we add the same operations for the columnAmount and
            .addFooterVariable(columnAmount,ColumnsGroupVariableOperation.SUM)        //columnaQuantity columns
            .addFooterVariable(columnaQuantity,ColumnsGroupVariableOperation.SUM)
            .build();*/
        
        
  		FastReportBuilder drb = new FastReportBuilder();
  		drb.addColumn("State", "state", String.class.getName(),30)
  			.addColumn("Branch", "branch", String.class.getName(),30)
  			.addColumn("Item", "item", String.class.getName(),50)
  			.addColumn(columnAmount)
  			.addGroup(djGroup)
  			.setTitle("November 2016 sales report")
  			.setSubtitle("This report was generated at " + new Date())
  			.setColumnsPerPage(1,10)
  			.setUseFullPageWidth(true);
  
  		DynamicReport dr = drb.build();
  
  		return dr;
  	}
  
  	public static class Holder
  	{
  		String state;
  		String branch;
  		String item;
  		Float amount;
  		
  		public static List<Holder> list()
  		{
  			List<Holder> holders = new ArrayList<ColumnsReportTest.Holder>();
  			for(int i=1;i<=10;i++){
  				Holder holder = new Holder();
  				holder.state ="State";
  				holder.branch="Branch "+i;
  				holder.item = "item "+i;
  				holder.amount = i*1f;
  				holders.add(holder);
  			}
  			return holders;
  		}

		public String getState( )
		{
			return state;
		}

		public void setState(String state)
		{
			this.state = state;
		}

		public String getBranch( )
		{
			return branch;
		}

		public void setBranch(String branch)
		{
			this.branch = branch;
		}

		public String getItem( )
		{
			return item;
		}

		public void setItem(String item)
		{
			this.item = item;
		}

		public Float getAmount( )
		{
			return amount;
		}

		public void setAmount(Float amount)
		{
			this.amount = amount;
		}
  		
  		
  	}
  	public static void main(String[] args) throws Exception {
  		
  		ColumnsReportTest test = new ColumnsReportTest();
  		DynamicReport dr = test.buildReport();
  		JRDataSource ds = new JRBeanCollectionDataSource(Holder.list());
  		JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);
  		JasperViewer.viewReport(jp); 
  //			JasperDesignViewer.viewReportDesign(jr);
  	}
  
  }