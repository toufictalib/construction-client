package report.helper;


public class DataHolder
{

  
    
    private final static String EMPTY_INDICATOR = "N/A";
    
	//report info
	public String logo;
	public int logoWidth;
	public int logoHeight;
	
	
	public String title = "Receipt # ";
	
	//branch
	public String branch;
	public String branchPhone;
	public String employee;
	
	//repair info
	public String repairId;
	public String dueDate;
	public String receivedDate;
	
	
	//customer info
	public String customerId;
	public String customerName;  
	public String customerContactPhone;  
	public String customerPhone;  
	
	//device info
	public String brand;  
	public String model;  
	public String color;  
	public String size;  
	public String imei;  
	public String accessories;
	public String problem;
	public String tests;
	
	public String clientSignature="Client Signature";
	public String compagnySignature="Project Owner Signature";
	//footer
	public String disclaimer = "";
			
	
	
	public static DataHolder newInstance()
	{
		DataHolder dataHolder = new DataHolder();
		dataHolder.logo="logo_ipin.jpg";
		dataHolder.logoWidth=100;
		dataHolder.logoHeight=67;
		
		//branch
		dataHolder.branch = "IPIN SEHET EL NOUR - ALFA STORE";
		dataHolder.branchPhone = "96101225533";
		dataHolder.employee= "AREF KAISI";
		
		//repair
		dataHolder.repairId = "2204";
		dataHolder.dueDate="2016-08-02 12:30 PM";
		dataHolder.receivedDate="2016-08-01 10:30 AM";
		
		
		//customer info
		dataHolder.customerId="163";
		dataHolder.customerName=  "Toufic Talib";
		dataHolder.customerContactPhone=  "71 04 02 84";
		dataHolder.customerPhone=  "76 61 98 69";
		
		//device info
		dataHolder.brand=  "APPLE";
		dataHolder.model=  "IPAD AIR 2 (A1567) 4G";
		dataHolder.color=  "BLACK";
		dataHolder.size=  "16GB";
		dataHolder.imei=  "013885002374535";
		dataHolder.accessories = "Battery, Cover, Pen";
		dataHolder.tests = "YES WIFI, NO BLUETOOTH, YES EARPHONES";
		dataHolder.problem = "EXTERNAL BUTTONS : CHECK WHAT IS NEED  AND THE CUSTOMER THE CUSTOMER DONT HAVE MOBILE HE WILL COME AT 12 OCLOCK";
		
		//title
		dataHolder.title = dataHolder.title+dataHolder.repairId;
		
		return dataHolder;
		
		
	}
        
}
