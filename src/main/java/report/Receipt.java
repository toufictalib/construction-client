package report;

import java.util.Date;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import report.GroupsReportTest.Holder;
import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.AutoText;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.ImageBanner;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;

public class Receipt
{
	public DynamicReport buildReport(Ccustomer customer) throws Exception {
		FastReportBuilder builder = new FastReportBuilder();
		
		builder.addImageBanner("images/logo_ipin.jpg", 100, 100, ImageBanner.ALIGN_LEFT);
		builder.addAutoText("Company Name :", AutoText.POSITION_HEADER, AutoText.ALIGMENT_LEFT);
		builder.addAutoText(customer.companyName, AutoText.POSITION_HEADER, AutoText.ALIGMENT_LEFT);
		builder.addAutoText("Company Phone :", AutoText.POSITION_HEADER, AutoText.ALIGMENT_LEFT);
		builder.addAutoText(customer.companyPhone, AutoText.POSITION_HEADER, AutoText.ALIGMENT_LEFT);
		builder.addAutoText("Project Name :", AutoText.POSITION_HEADER, AutoText.ALIGMENT_LEFT);
		builder.addAutoText(customer.projectName, AutoText.POSITION_HEADER, AutoText.ALIGMENT_LEFT);
		
		builder.addAutoText("2016-09-19 8:50 AM", AutoText.POSITION_HEADER, AutoText.ALIGMENT_RIGHT);
		builder.addAutoText("2016-09-19 8:50 AM", AutoText.POSITION_HEADER, AutoText.ALIGMENT_RIGHT);
		
		
		builder.setTitle("Receipt")
		.setSubtitle("This report was generated at " + new Date())
		.setPrintBackgroundOnOddRows(true)
		.setUseFullPageWidth(true);
		
		return builder.build();
	}
	
	private static class Ccustomer
	{
		public String companyName = "Al Twafik";
		public String companyPhone = "76619869";
		
		public String projectName = "Al Shams Residence";
		
		
		public String fullName = "Ahmad Ali Omar";
		public String phone = "76552222";
		
		public String contract= "125544"; 
		public String contractDescription ="Shams Residence - Block A - Flat Right floor 5"; 
		
		public String amount = "500";
		
		public String ownerSignature = "Owner Signature";
		public String clientSignature = "Client Signature";
		
	}
	
	
	public static void main(String[] args) throws Exception {
		Receipt test = new Receipt();
  		DynamicReport dr = test.buildReport(new Ccustomer());
  		JRDataSource ds = new JRBeanCollectionDataSource(Holder.list());
  		JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);
  		JasperViewer.viewReport(jp); 
 	}
}
