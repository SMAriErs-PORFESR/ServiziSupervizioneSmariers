package cnr.isti.data.input.protocollo.decode;

public enum TableDigitalInput {
	
	POLICY1(1,	"Interruttore I2 (uscita Q.GE) chiuso"),
	POLICY2(2,	"Interruttore I2 (uscita Q.GE) scattato"),
	POLICY3(3,	"Interruttore I3 (bypass Q.GE) chiuso"),
	POLICY4(4,	"Interruttore I3 (bypass Q.GE) scattato"),
	POLICY5(5,	"Sezionatore S1 (uscita UPS1) chiuso"),
	POLICY6(6,	"Sezionatore S2 (uscita UPS2) chiuso"),
	POLICY7(7,	"Sezionatore S3 (emergenza UPS1) chiuso"),
	POLICY8(8,	"Sezionatore S5 (bypass UPS) chiuso"),
	POLICY9(9,	"Sezionatore S7 (emergenza UPS2) chiuso"),
	POLICY10(10,	"Commutatore telecomandi su locale"),
	POLICY11(11,	"Interruttore aperti"),
	POLICY12(12,	"SCORTA"),
	POLICY13(13,	"ISOL 144 Vcc regolare"),
	POLICY14(14,	"ISOL 150 Vca regolare"),
	POLICY15(15,	"SCORTA"),
	POLICY16(16,	"SCORTA");

    int id;
    String Desc;
    
    //constructor
    TableDigitalInput(int id,  String desc) {
        this.id = id;
        this.Desc = desc;
       
    }

    //method to get error description from id
    public static String getDesc(int policyId)
    {
        for(TableDigitalInput policyInfo:TableDigitalInput.values())
        {
             if(policyInfo.id == policyId)
                 return policyInfo.Desc;
        }
        return "SCORTA";
    }


}
