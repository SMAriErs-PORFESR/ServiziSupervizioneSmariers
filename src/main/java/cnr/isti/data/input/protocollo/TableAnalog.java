package cnr.isti.data.input.protocollo;

public enum TableAnalog {
	
	
	POLICY1(1,"Tensione di ingresso fase U","V",1),
	POLICY2(2,"Corrente di ingresso fase U","A",0.1),
	POLICY3(3,"Cosfi di ingresso fase U","",0.001),
	POLICY4(4,"Frequenza di ingresso fase U","Hz",0.1),
	POLICY5(5,"Tensione di ingresso fase V","V",1.0),
	POLICY6(6,"Corrente di ingresso fase V","A",0.1),
	POLICY7(7,"Cosfi di ingresso fase V","",0.001),
	POLICY8(8,"Frequenza di ingresso fase V","Hz",0.1),
	POLICY9(9,"Tensione di ingresso fase W","V",1.0),
	POLICY10(10,"Corrente di ingresso fase W","A",0.1),
	POLICY11(11,"Cosfi di ingresso fase W","",0.001),
	POLICY12(12,"Frequenza di ingresso fase W","Hz",0.1),
	POLICY13(13,"Tensione di uscita fase U","V",1.0),
	POLICY14(14,"Corrente di uscita fase U","A",0.1),
	POLICY15(15,"Cosfi di uscita fase U","",0.001),
	POLICY16(16,"Frequenza di uscita fase U","Hz",0.1),
	POLICY17(17,"Tensione di uscita fase V","V",1.0),
	POLICY18(18,"Corrente di uscita fase V","A",0.1),
	POLICY19(19,"Cosfi di uscita fase V","",0.001),
	POLICY20(20,"Frequenza di uscita fase V","Hz",0.1),
	POLICY21(21,"Tensione di uscita fase W","V",1.0),
	POLICY22(22,"Corrente di uscita fase W","A",0.1),
	POLICY23(23,"Cosfi di uscita fase W","",0.001),
	POLICY24(24,"Frequenza di uscita fase W","Hz",0.1),
	POLICY25(25,"Temperatura ambiente","C",0.1);
	
	
	 int id;
	 String Desc;
	 String MisureU;
	 double precision;
	    
	    //constructor
	    TableAnalog(int id,  String desc, String misure, double precision) {
	        this.id = id;
	        this.Desc = desc;
	        this.MisureU = misure;
	        this.precision = precision;
	       
	    }
	    
	  //method to get error description from id
	    public static String getDesc(int policyId)
	    {
	        for(TableAnalog policyInfo:TableAnalog.values())
	        {
	             if(policyInfo.id == policyId)
	                 return policyInfo.Desc+" "+policyInfo.MisureU;
	        }
	        return "SCORTA";
	    }
	    
	    public static String getMisure(int num)
	    {
	        for(TableAnalog policyInfo:TableAnalog.values())
	        {
	             if(policyInfo.id == num)
	                 return policyInfo.MisureU;
	        }
	        return "SCORTA";
	    }
	    
	    public static double getPrecision(int policyId)
	    {
	        for(TableAnalog policyInfo:TableAnalog.values())
	        {
	             if(policyInfo.id == policyId)
	                 return policyInfo.precision;
	        }
	        return 1;
	    }

}
