package cnr.isti.data.input.protocollo.decode.deprecated;

public enum TableDigitalOutput {
	
	
	POLICY1(1,"Apertura sezionatore S1"),
	POLICY2(2,"Chiusura sezionatore S1"),
	POLICY3(3,"Apertura sezionatore S2"),
	POLICY4(4,"Chiusura sezionatore S2"),
	POLICY5(5,"Apertura sezionatore S3"),
	POLICY6(6,"Chiusura sezionatore S3"),
	POLICY7(7,"Apertura sezionatore S5"),
	POLICY8(8,"Chiusura sezionatore S5"),
	POLICY9(9,"Apertura sezionatore S7"),
	POLICY10(10,"Chiusura sezionatore S7"),
	POLICY11(11,"Apertura interruttore I3"),
	POLICY12(12,"Chiusura interruttore I3"),
	POLICY13(13,"Apertura interruttore I2"),
	POLICY14(14,"Chiusura interruttore I2"),
	POLICY15(15,"SCORTA"),
	POLICY16(16,"SCORTA");
	
	
	 int id;
	 String Desc;
	
	    
	    //constructor
	    TableDigitalOutput(int id,  String desc) {
	        this.id = id;
	        this.Desc = desc;
	        
	       
	    }
	    
	  //method to get error description from id
	    public static String getDesc(int policyId)
	    {
	        for(TableDigitalOutput policyInfo:TableDigitalOutput.values())
	        {
	             if(policyInfo.id == policyId)
	                 return policyInfo.Desc;
	        }
	        return "SCORTA";
	    }
	    
	   


}
