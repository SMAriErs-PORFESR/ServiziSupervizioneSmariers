package cnr.isti.data.input.protocollo.decode;

public enum EsitiDiagnostica {
	ALLARMECRITICO(1) {
		@Override
		public String getValue() {
			return "Allarme Critico Presente";
		}
		
		@Override
		public boolean isCritico() {
			return true;
		}

	},
	PRESENZAEVENTI(2) {
		@Override
		public String getValue() {
			return "Presenza eventi da Scaricare";
		}

		@Override
		public boolean isEventi() {
			return true;
		}
	},
	PRESENZAALLARMI(3) {
		@Override
		public String getValue() {
			return "Presenza Allarmi da Scaricare";
		}

		@Override
		public boolean isAllarmi() {
			return true;
		}
	},
	PRESENZAWARNING(4) {
		@Override
		public String getValue() {
			return "Presenza Warning da Scaricare";
		}

		@Override
		public boolean isWarning() {
			return true;
		}
	},
	PRESENZALOG(5) {
		@Override
		public String getValue() {
			return "Presenza Log Misure";
		}

		@Override
		public boolean isLog() {
			return true;
		}

		

	},
	ERRORECOM(6) {
		@Override
		public String getValue() {
			return "Errore Comunicazione";
		}

		@Override
		public boolean isError() {
			return false;
		}
	};

	private int esito;

	public boolean isEventi() {
		return false;
	}

	public boolean isWarning() {
		return false;
	}

	public boolean isAllarmi() {
		return false;
	}
	
	public boolean isCritico() {
		return false;
	}
	
	public boolean isLog() {
		return false;
	}
	
	public boolean isError() {
		return false;
	}

	public int getEsito() {
		return esito;
	}

	EsitiDiagnostica(int i) {
		this.esito = i;
	}

	

	public String getValue() {

		return "";
	}

}
