package report.helper;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.ComponentPositionType;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.StretchType;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;

public class Receipt
{

    public Receipt()
    {
        
    }
	public JasperReportBuilder build()
	{
            DataHolder dataHolder = DataHolder.newInstance();
		// styles
		StyleBuilder boldStyle = stl.style().bold();

		StyleBuilder boldCenteredStyle = stl.style(boldStyle).setVerticalTextAlignment(VerticalTextAlignment.MIDDLE);

		StyleBuilder titleStyle = stl.style(boldCenteredStyle)

		/*
		 * .setVerticalTextAlignment(VerticalTextAlignment.MIDDLE)
		 * .setHorizontalImageAlignment(HorizontalImageAlignment.LEFT)
		 */

		.setFontSize(23);


		TextFieldBuilder<String> title = cmp.text(dataHolder.title).setStyle(titleStyle).setHorizontalTextAlignment(HorizontalTextAlignment.RIGHT);

		/*VerticalListBuilder rightHeader = cmp.verticalList()
		.add(cmp.text("Repair # :"+dataHolder.repairId),
			cmp.text("Customer # :"+dataHolder.customerId)
				);
		
		VerticalListBuilder leftHeader = cmp.verticalList()
				.add(cmp.text("Service Center :"+dataHolder.disclaimer),
					cmp.text("Contact Number :"+dataHolder.branchPhone),
					cmp.text("Served By :"+dataHolder.employee)
						);
		
		HorizontalListBuilder disclaimer =  cmp.horizontalList()
	            .setStyle(stl.style(10)).setGap(50).add(

			               cmp.hListCell(createLeftHeaderComponent("Bill To", dataHolder)).heightFixedOnTop()

			               );*/
		

			
			JasperReportBuilder reportBuilder =report()					
					.setTemplate(Templates.reportTemplate)
					.title(cmp.horizontalList()

			           .add(
					getImage(dataHolder),
					title)
		           )
		           .pageHeader( /*Templates.createTitleComponent("Repair No.: " + dataHolder.repairId),*/

		            cmp.horizontalList()
		            .setStyle(stl.style(10)).setGap(50).add(

		               cmp.hListCell(createLeftHeaderComponent("Bill To", dataHolder)).heightFixedOnTop(),

		               cmp.hListCell(createRightHeaderComponent("Ship To", dataHolder)).heightFixedOnTop()).newRow()
               		   .add(cmp.filler().setStyle(stl.style().setTopBorder(stl.pen2Point())).setFixedHeight(10)),

		            cmp.verticalGap(10)
		          ,
		            		cmp.verticalList()
				            .setStyle(stl.style(10)).setGap(50).add(

				              /* cmp.vListCell(createCustomerComponent(dataHolder)).heightFixed(),*/

				             //  cmp.vListCell(createDeviceComponent( dataHolder)).heightFixed()
                                                      cmp.vListCell(createDeviceSeperator(dataHolder)).heightFixed()
                                                    ,
                                                       cmp.vListCell(cmp.text("").setStyle(stl.style().
				setTopBorder(stl.pen1Point()))),
				cmp.vListCell(addSignatures(dataHolder))
                                                    
                                                    /*,
				               cmp.vListCell(createOtherComponent( dataHolder)).heightFixed()*/
				               ),
                                        

				            cmp.verticalGap(10)
		            		
		            		
		            		)
		            		.pageFooter(createDisclaimerComponent(dataHolder))
		            		


			;
			
			
			return reportBuilder;

	}

	private ImageBuilder getImage(DataHolder dataHolder)
	{
		return cmp.
				image("images/" + dataHolder.logo).
				setWidth(dataHolder.logoWidth).
				setHeight(dataHolder.logoHeight).
				setHorizontalImageAlignment(HorizontalImageAlignment.LEFT);
	}
	private ComponentBuilder<?, ?> createRightHeaderComponent(String label, DataHolder dataHolder) {

	      HorizontalListBuilder list = cmp.horizontalList().setBaseStyle(stl.style().setLeftPadding(10));

	      //addCustomerAttribute(list, "Repair #", dataHolder.repairId);
	      //addCustomerAttribute(list, "Customer #", dataHolder.customerId);
	      addEmptyLine(list);
	      addCustomerAttribute(list, "Date", dataHolder.receivedDate);
	      addCustomerAttribute(list, "Customer", dataHolder.customerName);
	      addCustomerAttribute(list, "Phone", dataHolder.customerPhone);

	     

	      /*return cmp.verticalList(

	                     cmp.text(label).setStyle(Templates.boldStyle),

	                     list);*/
	      return list;

	   }
	
	

	private ComponentBuilder<?, ?> createLeftHeaderComponent(String label, DataHolder dataHolder) {

	      HorizontalListBuilder list = cmp.horizontalList().setBaseStyle(stl.style().setLeftPadding(10));

	  /*	VerticalListBuilder leftHeader = cmp.verticalList()
				.add(cmp.text("Service Center :"+dataHolder.branch),
					cmp.text("Contact Center :"+dataHolder.branchPhone),
					cmp.text("Served By :"+dataHolder.employee)
						);*/
	  	
	      addCustomerAttribute(list, "Company", dataHolder.branch);
	      addCustomerAttribute(list, "Company Phone", dataHolder.branch);
	      addCustomerAttribute(list, "Project", dataHolder.employee);

	     

	      /*return cmp.verticalList(

	                     cmp.text(label).setStyle(Templates.boldStyle),

	                     list);*/
	      return list;

	   }
	private ComponentBuilder<?, ?> createDisclaimerComponent(DataHolder dataHolder) {

	      HorizontalListBuilder list = cmp.horizontalList().setBaseStyle(stl.style().setLeftPadding(10));

	      addCustomerAttributeWithFixedColumn(list, "Note", dataHolder.disclaimer, 4);
		    addEmptyLine(list);
		    addEmptyLine(list);
	      //addCustomerAttribute(list, "Customer #", dataHolder.customerId);

	     

	      /*return cmp.verticalList(

	                     cmp.text(label).setStyle(Templates.boldStyle),

	                     list);*/
	      return list;

	   }

	   private void addCustomerAttribute(HorizontalListBuilder list, String label, String value) {

	      if (value != null) {

	         list.add(cmp.text(label + ":").setFixedColumns(10).setStyle(Templates.boldStyle), cmp.text(value)).newRow();

	      }

	   }
	   
	   private void addCustomerAttributeWithFixedColumn(HorizontalListBuilder list, String label, String value,int fixedColumns) {

		      if (value != null) {

		         list.add(cmp.text(label + ":")
		        		 .setFixedColumns(fixedColumns)
		        		 .setStyle(Templates.boldStyle)
		        		 .setStretchType(StretchType.CONTAINER_HEIGHT)
		        		 .setStretchWithOverflow(true)
		        		 .setPositionType(ComponentPositionType.FLOAT)
		        		 , cmp.text(value)).newRow();

		      }

		   }
	   
	   private void addCustomerAttributeHorizantaly(HorizontalListBuilder list, String label, String value) {

		      if (value != null) {

		         list.add(cmp.text(label + ":").setFixedColumns(7).setStyle(Templates.boldStyle), cmp.text(value));

		      }

		   }
	   
	   private void goToNewRow(HorizontalListBuilder list) {
		   list.newRow();
		   }
	   
	   private void addEmptyLine(HorizontalListBuilder list) {
		   list.add(cmp.text("").setFixedColumns(7).setStyle(Templates.boldStyle), cmp.text("")).newRow();
		   }

            private void addCustomerAttributeHorizantalyWithNewRow(HorizontalListBuilder list, String label, String value) {

		      if (value != null) {

		         list.add(cmp.text(label + ":").setFixedColumns(7).setStyle(Templates.boldStyle), 
		        		 cmp.text(value)).newRow().setPositionType(ComponentPositionType.FIX_RELATIVE_TO_TOP);

		      }

		   }

	   
	private ComponentBuilder<?, ?> createCustomerComponent(DataHolder dataHolder)
	{

		HorizontalListBuilder list = cmp.horizontalList().setBaseStyle(stl.style().setTopBorder(stl.pen1Point()).setLeftPadding(10));

		addCustomerAttributeHorizantaly(list, "Name", dataHolder.customerName);

		addCustomerAttributeHorizantaly(list, "Phone #", dataHolder.customerPhone);

		addCustomerAttributeHorizantaly(list, "Contact #", dataHolder.customerContactPhone);

		return cmp.verticalList(

		cmp.text("Customer Info").setStyle(Templates.boldStyle),

		list);

	}
	
	/*private ComponentBuilder<?, ?> createDeviceComponent(DataHolder dataHolder)
	{

		HorizontalListBuilder list = cmp.horizontalList().setBaseStyle(stl.style().setTopBorder(stl.pen1Point()).setLeftPadding(10));

		addCustomerAttributeHorizantaly(list, "Contract", dataHolder.brand);
		addCustomerAttributeHorizantaly(list, "Real Estate Price", dataHolder.accessories);
		goToNewRow(list);
		addCustomerAttributeHorizantaly(list, "Contract Description", dataHolder.color);
		addCustomerAttributeHorizantaly(list, "Problem", dataHolder.problem);
		goToNewRow(list);
		addCustomerAttributeHorizantaly(list, "Model", dataHolder.model);
		addCustomerAttributeHorizantaly(list, "Tests", dataHolder.tests);
		goToNewRow(list);
		addCustomerAttributeHorizantaly(list, "Size", dataHolder.size);
		goToNewRow(list);
		addCustomerAttributeHorizantaly(list, "IMEI", dataHolder.imei);
		addEmptyLine(list);
		addEmptyLine(list);


		return cmp.verticalList(

		cmp.text("Device Info").setStyle(Templates.boldStyle),

		list,
		cmp.text("").setStyle(stl.style().
				setTopBorder(stl.pen1Point())
				
				));

	}*/	
	private ComponentBuilder<?, ?> createOtherComponent(DataHolder dataHolder)
	{

		HorizontalListBuilder list = cmp.horizontalList().setBaseStyle(stl.style().setTopBorder(stl.pen1Point()).setLeftPadding(10));

		addCustomerAttributeHorizantaly(list, "Accessories", dataHolder.accessories);

		/*addCustomerAttributeHorizantaly(list, "Customer Phone", dataHolder.customerPhone);

		addCustomerAttributeHorizantaly(list, "Customer Address", dataHolder.customerAddress);*/

		return cmp.verticalList(

		cmp.text("Others").setStyle(Templates.boldStyle),

		list);

	}

	   
        private ComponentBuilder<?, ?> createDeviceSeperator(DataHolder dataHolder)
	{

		HorizontalListBuilder list = cmp.
				horizontalList().
				setBaseStyle(stl.style().
				//setTopBorder(stl.pen1Point()).
				setLeftPadding(10));
		
		list.add(createLeftDeviceComponent(dataHolder));
		list.add(createRightDeviceComponent(dataHolder));

		return cmp.verticalList(

		//cmp.text("Device Info").setStyle(Templates.boldStyle),

		list
              //,  cmp.horizontalList().add(cmp.text("").setFixedColumns(5).setStyle(Templates.boldStyle), cmp.text("")).newRow()
		
				
				);

	}
        
        private ComponentBuilder<?, ?> addSignatures(DataHolder dataHolder)
    	{

    		HorizontalListBuilder list = cmp.
    				horizontalList().
    				setBaseStyle(stl.style().
    				//setTopBorder(stl.pen1Point()).
    				setLeftPadding(10));
    		
    		 list.add( cmp.text(dataHolder.compagnySignature).setFixedColumns(15).setStyle(stl.style().setTopBorder(stl.penDashed()).setLeftPadding(10)));
    		 list.add( 250,cmp.text(dataHolder.clientSignature).setFixedColumns(10).setStyle(stl.style().setTopBorder(stl.penDashed()).setLeftPadding(10)));

    		return cmp.verticalList(

    		//cmp.text("Device Info").setStyle(Templates.boldStyle),

    		list
                  //,  cmp.horizontalList().add(cmp.text("").setFixedColumns(5).setStyle(Templates.boldStyle), cmp.text("")).newRow()
    		
    				
    				);

    	}
	
	private ComponentBuilder<?, ?> createLeftDeviceComponent(DataHolder dataHolder)
	{

		HorizontalListBuilder list = cmp.horizontalList();//.setBaseStyle(stl.style().setTopBorder(stl.pen1Point()).setLeftPadding(10));
		addCustomerAttributeHorizantaly(list, "Contract", dataHolder.brand);
		goToNewRow(list);
		addCustomerAttributeHorizantaly(list, "Contract Description", dataHolder.color);
		goToNewRow(list);
		addCustomerAttributeHorizantaly(list, "Real Estate Price", dataHolder.model);
		/*goToNewRow(list);
		addCustomerAttributeHorizantaly(list, "Size", dataHolder.size);
		goToNewRow(list);
		addCustomerAttributeHorizantaly(list, "IMEI", dataHolder.imei);*/


		return cmp.verticalList(

		//cmp.text("Device Info").setStyle(Templates.boldStyle),

		list
		
				
				);

	}
	
	
	
	private ComponentBuilder<?, ?> createRightDeviceComponent(DataHolder dataHolder)
	{

		
		HorizontalListBuilder list = cmp.horizontalList();//.setBaseStyle(stl.style().setTopBorder(stl.pen1Point()).setLeftPadding(10));;

		addCustomerAttributeHorizantalyWithNewRow(list, "Amount", dataHolder.accessories);
		/*addCustomerAttributeHorizantalyWithNewRow(list, "Problem", dataHolder.problem);
		addCustomerAttributeHorizantalyWithNewRow(list, "Tests", dataHolder.tests);
                addEmptyLine(list);*/
                addEmptyLine(list);
                addEmptyLine(list);

		return cmp.verticalList(

	//cmp.text("Device Info").setStyle(Templates.boldStyle),

		list
		
				
				);

	}

        public void print() throws Exception
        {
            build().show();
        }
        
	public static void main(String[] args)
	{
		try
		{
			new Receipt().print();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
