package cnr.isti.data.input.protocollo.decode;

public enum TableCodiceEventi {
	
	POLICY1(1,"I2 chiuso (uscita Q.GE)","Evento"),
	POLICY2(2,"I2 aperto (uscita Q.GE)","Evento"),
	POLICY3(3,"I2 scattato (uscita Q.GE)","Allarme"),
	POLICY4(4,"I3 chiuso (bypass Q.GE)","Evento"),
	POLICY5(5,"I3 aperto (bypass Q.GE)","Evento"),
	POLICY6(6,"I3 scattato (bypass Q.GE)","Allarme"),
	POLICY7(7,"S1 chiuso (uscita UPS1)","Evento"),
	POLICY8(8,"S1 aperto (uscita UPS1)","Evento"),
	POLICY9(9,"S2 chiuso (uscita UPS2)","Evento"),
	POLICY10(10,"S2 aperto (uscita UPS2)","Evento"),
	POLICY11(11,"S3 chiuso (emergenza UPS1)","Evento"),
	POLICY12(12,"S3 aperto (emergenza UPS1)","Evento"),
	POLICY13(13,"S5 chiuso (bypass UPS)","Evento"),
	POLICY14(14,"S5 aperto (bypass UPS)","Evento"),
	POLICY15(15,"S7 chiuso (emergenza UPS2)","Evento"),
	POLICY16(16,"S7 aperto (emergenza UPS2)","Evento"),
	POLICY17(17,"Telecomandi abilitati","Evento"),
	POLICY18(18,"Telecomandi disabilitati","Evento"),
	POLICY19(19,"Interruttori chiusi","Evento"),
	POLICY20(20,"Interruttori aperti","Allarme"),
	POLICY21(21,"ISOL 144 Vcc regolare","Evento"),
	POLICY22(22,"ISOL 144 Vcc allarme","Allarme"),
	POLICY23(23,"ISOL 150 Vca regolare","Evento"),
	POLICY24(24,"ISOL 150 Vca allarme","Allarme"),
	POLICY160(160,"Accensione","Warning"),
	POLICY161(161,"Rimessa oraria da operatore","Evento"),
	POLICY162(162,"Restart da operatore","Warning"),
	POLICY163(163,"Errore lettura configurazione modulo","Allarme"),
	POLICY164(164,"Sovrascrittura configurazione modulo","Evento"),
	POLICY165(165,"Ricevuta nuova configurazione modulo (identificazione modulo)","Evento"),
	POLICY166(166,"Ricevuta nuova configurazione canale analogico","Evento"),
	POLICY167(167,"Errore checksum memoria non volatile","Warning"),
	POLICY168(168,"Avvio procedura di autoapprendimento impianto","Evento"),
	POLICY169(169,"Fine procedura di autoapprendimento impianto","Evento"),
	POLICY170(170,"RISERVATO","Evento"),
	POLICY171(171,"Allarme comunicazione o stato ignoto modulo slave","Allarme"),
	POLICY172(172,"Rientro in normalità comunicazione con slave","Evento"),
	POLICY173(173,"Cancellazione totale buffer eventi, allarmi e warning","Evento"),
	POLICY174(174,"Allarme comunicazione o stato ignoto modulo master","Allarme"),
	POLICY175(175,"Rientro in normalità comunicazione con master","Evento"),
	POLICY176(176,"Errore indirizzo risposta modulo slave","Warning"),
	POLICY177(177,"Sincronismo orario modulo","Evento"),
	POLICY178(178,"Errore stato attuatori dopo richiesta telecomando","Allarme"),
	POLICY179(179,"Errore orologio interno modulo (RTC)","Warning"),
	POLICY180(180,"Inizio invio aggiornamento firmware su modulo","Evento"),
	POLICY181(181,"Fine invio aggiornamento firmware su modulo","Evento"),
	POLICY182(182,"Errore batteria interna modulo","Warning"),
	POLICY183(183,"Sovrascrittura configurazione impianto su memoria non volatile","Evento"),
	POLICY184(184,"Nessuna configurazione slave caricata","Warning"),
	POLICY185(185,"Errore scrittura configurazione impianto su memoria non volatile","Warning"),
	POLICY186(186,"Errore scrittura configurazione canale analogica su memoria non volatile","Warning"),
	POLICY187(187,"Cancellazione totale buffer variazioni misure","Evento"),
	POLICY188(188,"Attivata comunicazione seriale in locale","Evento"),
	POLICY189(189,"Rientro in modalità comunicazione RS485","Evento"),
	POLICY190(190,"Errore buffer eventi\\allarmi\\warning\\log","Warning"),
	POLICY191(191,"Richiesta attuazione telecomando diretto","Evento"),
	POLICY192(192,"Nuovo slave aggiunto in configurazione impianto","Evento"),
	POLICY193(193,"Slave eliminato dalla configurazione impianto","Evento"),
	POLICY194(194,"Anomalia tensione alimentazione","Warning"),
	POLICY195(195,"Errore hardware canbus","Warning"),
	POLICY196(196,"Errore risposta comando canbus slave","Warning"),
	POLICY197(197,"Errore comunicazione seriale","Allarme"),
	POLICY198(198,"Rientro in normalità comunicazione seriale","Evento"),
	POLICY199(199,"Warning massimo misura soglia 2","Warning"),
	POLICY200(200,"Rientro in normalità misura","Evento"),
	POLICY201(201,"Warning minimo misura soglia 1","Warning"),
	POLICY202(202,"Warning massimo misura soglia 1","Warning"),
	POLICY203(203,"Allarme massimo misura","Allarme"),
	POLICY204(204,"Allarme minimo misura","Allarme"),
	POLICY205(205,"RISERVATO","Evento"),
	POLICY206(206,"Inizio buco di tensione","Allarme"),
	POLICY207(207,"Fine buco di tensione","Allarme"),
	POLICY208(208,"Inizio sovracorrente","Allarme"),
	POLICY209(209,"Fine sovracorrente","Allarme"),
	POLICY210(210,"Variazione ingresso digitale su stato OFF","Evento"),
	POLICY211(211,"Variazione ingresso digitale su stato ON","Evento"),
	POLICY212(212,"Batteria interna in normalità","Evento"),
	POLICY213(213,"Errore bus dati","Warning"),
	POLICY214(214,"Bus dati in normalità","Evento"),
	POLICY215(215,"Rientro in normalità tensione alimentazione","Evento"),
	POLICY216(216,"Allarme diagnostica uscite digitali","Allarme"),
	POLICY217(217,"Allarme diagnostica ingressi digitali","Allarme"),
	POLICY218(218,"Allarme diagnostica ingressi analogici","Allarme"),
	POLICY219(219,"Inserimento scheda I/O","Evento"),
	POLICY220(220,"Disinserimento scheda I/O","Evento"),
	POLICY221(221,"Ricevuta nuova configurazione seriale","Evento"),
	POLICY222(222,"Ricevuta nuova configurazione canbus","Evento"),
	POLICY223(223,"Regolarità tensione 24V","Evento"),
	POLICY224(224,"Tensione 24V non regolare","Allarme"),
	POLICY225(225,"Regolarità tensione 110V","Evento"),
	POLICY226(226,"Tensione 110V non regolare","Allarme"),
	POLICY227(227,"Rientro in normalità allarme generico","Evento"),
	POLICY228(228,"Warning minimo misura soglia 2","Warning"),
	POLICY229(229,"Anomalia cambio stato uscita digitale","Allarme"),
	POLICY230(230,"Sovrascrittura FIFO dati su modulo","Warning"),
	POLICY231(231,"Richiesta telecomando","Evento"),
	POLICY232(232,"Ricezione sequenza o comando","Warning"),
	POLICY233(233,"Login operatore","Evento"),
	POLICY234(234,"Caricamento parametri eseguito","Evento"),
	POLICY235(235,"Scheda ingressi digitali entrata in allarme","Allarme"),
	POLICY236(236,"Scheda ingressi digitali rientro in normalità","Evento"),
	POLICY237(237,"Scheda comandi digitali entrata in allarme","Allarme"),
	POLICY238(238,"Scheda comandi digitali rientro in normalità","Evento"),
	POLICY239(239,"Scheda analogica entrata in allarme","Allarme"),
	POLICY240(240,"Scheda analogica rientro in normalità","Evento"),
	POLICY241(241,"Richiesta comando","Evento"),
	POLICY242(242,"Risposta comando","Evento");

    int id;
    String Desc;
    String tipo;
    
    //constructor
    TableCodiceEventi(int id,  String desc, String tipo) {
        this.id = id;
        this.Desc = desc;
        this.tipo= tipo;
       
    }

    //method to get error description from id
    public static String getDesc(int policyId)
    {
        for(TableCodiceEventi policyInfo:TableCodiceEventi.values())
        {
             if(policyInfo.id == policyId)
                 return policyInfo.Desc;
        }
        return "SCORTA";
    }
    
    public static String getTipo(int policyId)
    {
        for(TableCodiceEventi policyInfo:TableCodiceEventi.values())
        {
             if(policyInfo.id == policyId)
                 return policyInfo.tipo;
        }
        return "Indefinito";
    }


}
