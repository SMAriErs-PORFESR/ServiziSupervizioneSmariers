package cnr.isti.data.input.protocollo.decode;

public enum TableDiagnostica {
	
	POLICY1(1,"Allarme critico"),
	POLICY2(2,"Presenza eventi da scaricare"),
	POLICY3(3,"Presenza allarmi da scaricare"),
	POLICY4(4,"Presenza log misure da scaricare"),
	POLICY5(5,"Presenza warning da scaricare"),
	POLICY6(6,"Modulo in modalit√† TEST"),
	POLICY7(7,"Presenza tensione comandi"),
	POLICY8(8,"Attivit‡†"),
	POLICY9(9,"Errore diagnostica ingressi digitali"),
	POLICY10(10,"Presenza eventi da scaricare"),
	POLICY11(11,"Presenza allarmi da scaricare"),
	POLICY12(12,"Presenza log misure da scaricare"),
	POLICY13(13,"Presenza warning da scaricare"),
	POLICY14(14,"Errore diagnostica misure"),
	POLICY15(15,"RISERVATO"),
	POLICY16(16,"Errore comunicazione"),
	POLICY17(17,"Errore comunicazione con almeno 1 slave"),
	POLICY18(18,"Errore bus I2C"),
	POLICY19(19,"Errore orologio interno o RTC"),
	POLICY20(20,"Presenza tensione batteria interna"),
	POLICY21(21,"Errore buffer eventi\\allarmi\\warning\\log"),
	POLICY22(22,"Errore diagnostica uscita digitali"),
	POLICY23(23,"Allarme cumulativo morsettiera"),
	POLICY24(24,"Errore bus di comunicazione"),
	POLICY25(25,"Errore di comunicazione RS485 ausiliaria"),
	POLICY26(26,"Comunicazione locale attivata"),
	POLICY27(27,"Presenza tensione uscite"),
	POLICY28(28,"Assenza tensione ausiliaria"),
	POLICY29(29,"Presenza alimentazione diagnostica"),
	POLICY30(30,"Assenza 110V"),
	POLICY31(31,"Presenza alimentazione esterna"),
	POLICY32(32,"Assenza scheda espansione I/O");

    int id;
    String Desc;
    
    //constructor
    TableDiagnostica(int id,  String desc) {
        this.id = id;
        this.Desc = desc;
       
    }

    //method to get error description from id
    public static String getDesc(int policyId)
    {
        for(TableDiagnostica policyInfo:TableDiagnostica.values())
        {
             if(policyInfo.id == policyId)
                 return policyInfo.Desc;
        }
        return "SCORTA";
    }


}
