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
  
  import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.AutoText;
import ar.com.fdvs.dj.domain.DJCalculation;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.builders.GroupBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.GroupLayout;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;
import ar.com.fdvs.dj.domain.entities.DJGroup;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;
import ar.com.fdvs.dj.domain.entities.columns.PropertyColumn;
  
  public class GroupsReportTest  {
  
  	public DynamicReport buildReport() throws Exception {
  
  		Style detailStyle = new Style("detail");
  
  		Style headerStyle = new Style("header");
  		headerStyle.setFont(Font.ARIAL_MEDIUM_BOLD);
  		headerStyle.setBorderBottom(Border.PEN_1_POINT());
  		headerStyle.setBackgroundColor(Color.gray);
  		headerStyle.setTextColor(Color.white);
  		headerStyle.setHorizontalAlign(HorizontalAlign.CENTER);
  		headerStyle.setVerticalAlign(VerticalAlign.MIDDLE);
  		headerStyle.setTransparency(Transparency.OPAQUE);
  
  		Style headerVariables = new Style("headerVariables");
  		headerVariables.setFont(Font.ARIAL_BIG_BOLD);
  		headerVariables.setBorderBottom(Border.THIN());
  		headerVariables.setHorizontalAlign(HorizontalAlign.RIGHT);
  		headerVariables.setVerticalAlign(VerticalAlign.TOP);
  		headerVariables.setStretchWithOverflow(true);
  
  		Style groupVariables = new Style("groupVariables");
  		groupVariables.setFont(Font.ARIAL_MEDIUM_BOLD);
  		groupVariables.setTextColor(Color.BLUE);
  		groupVariables.setBorderBottom(Border.THIN());
  		groupVariables.setHorizontalAlign(HorizontalAlign.RIGHT);
  		groupVariables.setVerticalAlign(VerticalAlign.BOTTOM);
  
  		Style titleStyle = new Style("titleStyle");
  		titleStyle.setFont(new Font(18, Font._FONT_VERDANA, true));
  		Style importeStyle = new Style();
  		importeStyle.setHorizontalAlign(HorizontalAlign.RIGHT);
  		Style oddRowStyle = new Style();
  		oddRowStyle.setBorder(Border.NO_BORDER());
  		oddRowStyle.setBackgroundColor(Color.LIGHT_GRAY);
  		oddRowStyle.setTransparency(Transparency.OPAQUE);
  
  		DynamicReportBuilder drb = new DynamicReportBuilder();
  		Integer margin = new Integer(20);
  		drb
  			.setTitleStyle(titleStyle)
  			.setTitle("November 2016 sales report")					//defines the title of the report
  			.setSubtitle("The items in this report correspond "
  					+"to the main products: DVDs, Books, Foods and Magazines")
  			.setDetailHeight(new Integer(15)).setLeftMargin(margin)
  			.setRightMargin(margin).setTopMargin(margin).setBottomMargin(margin)
 			.setPrintBackgroundOnOddRows(true)
 			.setGrandTotalLegend("Grand Total")
 			.setGrandTotalLegendStyle(headerVariables)
 			.setOddRowBackgroundStyle(oddRowStyle);
 
 
  		
 		AbstractColumn columnState = ColumnBuilder.getNew()
 				.setColumnProperty("state", String.class.getName()).setTitle(
 						"State").setWidth(new Integer(85))
 				.setStyle(titleStyle).setHeaderStyle(titleStyle).build();
 
 		AbstractColumn columnBranch = ColumnBuilder.getNew()
 				.setColumnProperty("branch", String.class.getName()).setTitle(
 						"Branch").setWidth(new Integer(85)).setStyle(
 						detailStyle).setHeaderStyle(headerStyle).build();
 
 		AbstractColumn columnaProductLine = ColumnBuilder.getNew()
 				.setColumnProperty("productLine", String.class.getName())
 				.setTitle("Product Line").setWidth(new Integer(85)).setStyle(
 						detailStyle).setHeaderStyle(headerStyle).build();
 
 		AbstractColumn columnaItem = ColumnBuilder.getNew()
 				.setColumnProperty("item", String.class.getName()).setTitle(
 						"Item").setWidth(new Integer(85)).setStyle(detailStyle)
 				.setHeaderStyle(headerStyle).build();
 
 		AbstractColumn columnCode = ColumnBuilder.getNew()
 				.setColumnProperty("id", Long.class.getName()).setTitle("ID")
 				.setWidth(new Integer(40)).setStyle(importeStyle)
 				.setHeaderStyle(headerStyle).build();
 
 		AbstractColumn columnaQuantity = ColumnBuilder.getNew()
 				.setColumnProperty("quantity", Long.class.getName()).setTitle(
 						"Quantity").setWidth(new Integer(25)).setStyle(
 						importeStyle).setHeaderStyle(headerStyle).build();
 
 		AbstractColumn columnAmount = ColumnBuilder.getNew()
 				.setColumnProperty("amount", Float.class.getName()).setTitle(
 						"Amount").setWidth(new Integer(100))
 				.setPattern("$ 0.00").setStyle(importeStyle).setHeaderStyle(
 						headerStyle).build();
 
 		drb.addGlobalHeaderVariable(columnAmount, DJCalculation.SUM,headerVariables);
 		drb.addGlobalHeaderVariable(columnaQuantity, DJCalculation.SUM,headerVariables);
 		drb.addGlobalFooterVariable(columnAmount, DJCalculation.SUM,headerVariables);
 		drb.addGlobalFooterVariable(columnaQuantity, DJCalculation.SUM,headerVariables);
 		drb.setGlobalHeaderVariableHeight(new Integer(25));
 		drb.setGlobalFooterVariableHeight(new Integer(25));
 
 		GroupBuilder gb1 = new GroupBuilder();
 
 //		 define the criteria column to group by (columnState)
 		DJGroup g1 = gb1.setCriteriaColumn((PropertyColumn) columnState)
 				.addFooterVariable(columnaQuantity,DJCalculation.SUM,groupVariables) // idem for the columnaQuantity column
 //				.addFooterVariable(columnAmount,DJCalculation.SUM,groupVariables) // tell the group place a variable footer of the column "columnAmount" with the SUM of allvalues of the columnAmount in this group.
 				.addHeaderVariable(columnaQuantity,DJCalculation.SUM,groupVariables) // idem for the columnaQuantity column
 				.addHeaderVariable(columnAmount,DJCalculation.SUM,groupVariables) // tell the group place a variable footer of the column "columnAmount" with the SUM of allvalues of the columnAmount in this group.
 				.setGroupLayout(GroupLayout.VALUE_IN_HEADER) // tells the group how to be shown, there are manyposibilities, see the GroupLayout for more.
 				.setFooterVariablesHeight(new Integer(20))
 				.setFooterHeight(new Integer(50),true)
 				.setHeaderVariablesHeight(new Integer(35))
 				.build();
 
 		GroupBuilder gb2 = new GroupBuilder(); // Create another group (using another column as criteria)
 		DJGroup g2 = gb2.setCriteriaColumn((PropertyColumn) columnBranch) // and we add the same operations for the columnAmount and
 				.addFooterVariable(columnAmount,
 						DJCalculation.SUM) // columnaQuantity columns
 				.addFooterVariable(columnaQuantity,	DJCalculation.SUM)
 				.build();
 
 		drb.addColumn(columnState);
 		drb.addColumn(columnBranch);
 		drb.addColumn(columnaProductLine);
 		drb.addColumn(columnaItem);
 		drb.addColumn(columnCode);
 		drb.addColumn(columnaQuantity);
 		drb.addColumn(columnAmount);
 
 		drb.addGroup(g1); // add group g1
 //		drb.addGroup(g2); // add group g2
 
 		drb.setUseFullPageWidth(true);
 		drb.addAutoText(AutoText.AUTOTEXT_PAGE_X_SLASH_Y, AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_RIGHT);
 
 		DynamicReport dr = drb.build();
 		return dr;
 	}
 
 	public static void main(String[] args) throws Exception {
 		GroupsReportTest test = new GroupsReportTest();
  		DynamicReport dr = test.buildReport();
  		JRDataSource ds = new JRBeanCollectionDataSource(Holder.list());
  		JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);
  		JasperViewer.viewReport(jp); 
 	}
 	
 	public static class Holder
  	{

  		String state;
  		String branch;
  		String productLine;
  		String item;
  		long id;
  		long quantity;
  		float amount;
  		
  		public static List<Holder> list()
  		{
  			List<Holder> holders = new ArrayList<Holder>();
  			for(int i=1;i<=10;i++){
  				Holder holder = new Holder();
  				holder.state ="State";
  				holder.branch="Branch "+i;
  				holder.item = "item "+i;
  				holder.id = i*1l;
  				holder.quantity = i*2l;
  				holder.amount = i*1f*1000;
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

		public String getProductLine( )
		{
			return productLine;
		}

		public void setProductLine(String productLine)
		{
			this.productLine = productLine;
		}

		public String getItem( )
		{
			return item;
		}

		public void setItem(String item)
		{
			this.item = item;
		}

		public long getId( )
		{
			return id;
		}

		public void setId(long id)
		{
			this.id = id;
		}

		public long getQuantity( )
		{
			return quantity;
		}

		public void setQuantity(long quantity)
		{
			this.quantity = quantity;
		}

		public float getAmount( )
		{
			return amount;
		}

		public void setAmount(float amount)
		{
			this.amount = amount;
		}
  		
  		
  	}
  }
 
 