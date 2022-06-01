package cnr.isti.data.input.protocollo.util;


public class Pair<T, V> {
	
	private T t;
	
	private V v;

	public Pair(T t, V v) {

		this.t = t;
		this.v = v;
	}

	public T getPrimo() {
		return t;
	}



	public V getSecondo() {
		return v;
	}

	@Override
	public String toString() {
		return (t != null ? t + ", " : "") + (v != null ? v : "");
	}


	

}
