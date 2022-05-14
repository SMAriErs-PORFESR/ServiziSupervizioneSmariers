package cnr.isti.mqtt.topic;

public enum Topic {
	
	
	
	PRESENZA_EVENTI(1,"SMARIERS_SUB_PRESENZA_EVENTI"),
	PRESENZA_ALLARMI(2,"SMARIERS_SUB_PRESENZA_ALLARMI"),
	PRESENZA_WARNING(3,"SMARIERS_SUB_PRESENZA_WARNING"),
	PRESENZA_MIXED(4,"SMARIERS_SUB_PRESENZA_MIXED"),
	REAL_TIME(5,"SMARIERS_SUB_REALTIME"),
	GROUP(5,"SMARIERS_SUB_GROUP"),
	EMPTY(6,"SMARIERS_SUB_VUOTO");
	
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
