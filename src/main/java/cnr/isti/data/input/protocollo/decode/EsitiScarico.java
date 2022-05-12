package cnr.isti.data.input.protocollo.decode;

public enum EsitiScarico {
	ASSENZA(4260096) {
		@Override
		public int getValue() {
			return 4260096;
		}

	},
	SOLOEVENTI(4264192) {
		@Override
		public int getValue() {
			return 4264192;
		}

		@Override
		public boolean isEventi() {
			return true;
		}
	},
	SOLOALLARMI(4260097) {
		@Override
		public int getValue() {
			return 4260097;
		}

		@Override
		public boolean isAllarmi() {
			return true;
		}
	},
	SOLOWARNING(4260128) {
		@Override
		public int getValue() {
			return 4260128;
		}

		@Override
		public boolean isWarning() {
			return true;
		}
	},
	EVENTIALLARMI(4264193) {
		@Override
		public int getValue() {
			return 4264193;
		}

		@Override
		public boolean isAllarmi() {
			return true;
		}

		@Override
		public boolean isEventi() {
			return true;
		}

	},
	EVENTIWARNING(4264224) {
		@Override
		public int getValue() {
			return 4264224;
		}

		@Override
		public boolean isWarning() {
			return true;
		}

		@Override
		public boolean isEventi() {
			return true;
		}
	},
	EVENTIALLARMIWARNING(4264225) {
		@Override
		public int getValue() {
			return 4264225;
		}

		@Override
		public boolean isWarning() {
			return true;
		}

		@Override
		public boolean isEventi() {
			return true;
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

	public int getEsito() {
		return esito;
	}

	EsitiScarico(int i) {
		this.esito = i;
	}

	public static EsitiScarico getEsitiScarico(int esito) {
		switch (esito) {
		case 4264192:
			return SOLOEVENTI;
		case 4264193:
			return EVENTIALLARMI;
		case 4260097:
			return SOLOALLARMI;
		case 4260128:
			return SOLOWARNING;
		case 4264224:
			return EVENTIWARNING;
		case 4264225:
			return EVENTIALLARMIWARNING;
		default:
			break;
		}

		return ASSENZA;
	}

	public int getValue() {

		return 0;
	}

}
