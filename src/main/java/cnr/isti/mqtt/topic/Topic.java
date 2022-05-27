package cnr.isti.mqtt.topic;

public enum Topic {
	
	
	
	PRESENZA_EVENTI(1,"SMARIERS_SUB/EVENTI"),
	PRESENZA_ALLARMI(2,"SMARIERS_SUB/ALLARMI"),
	PRESENZA_WARNING(3,"SMARIERS_SUB/WARNING"),
	PRESENZA_MIXED(4,"SMARIERS_SUB_PRESENZA/MIXED"),
	REG_VALORE(4,"SMARIERS_SUB/REGOLARITAVALORE"),
	PRESENZA_DATI(5,"SMARIERS_SUB/PRESENZA/DATI"),
	REAL_TIME(6,"SMARIERS_SUB/REALTIME"),
	LOG(7,"SMARIERS_SUB/LOG"),
	DATA(7,"SMARIERS_SUB/DATA"),
	GROUP(8,"SMARIERS_SUB/GROUP"),
	EMPTY(9,"SMARIERS_SUB_VUOTO");
	
	String topic;
	int index;
	
	Topic(int i , String tp) {
		this.index = i ;
		this.topic = tp;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	

}
