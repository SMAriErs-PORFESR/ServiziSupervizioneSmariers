package cnr.isti.data.input.protocollo.decode.deprecated;

public enum TableTipiEvento {
	
	
	POLICY1(0,"Evento generico"),
	POLICY2(1,"Evento"),
	POLICY3(2,"Warning"),
	POLICY4(3,"Allarme"),
	POLICY5(4,"Variazioni misure"),
	POLICY6(5,"Configurazione"),
	POLICY7(6,"Comunicazione"),
	POLICY8(7,"Operatore"),
	POLICY9(8,"NON DEFINITO"),
	POLICY10(9,"Rientro in normalità"),
	POLICY11(10,"Allarme riconosciuto"),
	POLICY12(30,"SNMP Allarme"),
	POLICY13(31,"SNMP Evento");
	
	
	 int id;
	 String Desc;
	
	    
	    //constructor
	    TableTipiEvento(int id,  String desc) {
	        this.id = id;
	        this.Desc = desc;
	        
	       
	    }
	    
	  //method to get error description from id
	    public static String getDesc(int policyId)
	    {
	        for(TableTipiEvento policyInfo:TableTipiEvento.values())
	        {
	             if(policyInfo.id == policyId)
	                 return policyInfo.Desc;
	        }
	        return "NON DEFINITO";
	    }
	    
	   


}
