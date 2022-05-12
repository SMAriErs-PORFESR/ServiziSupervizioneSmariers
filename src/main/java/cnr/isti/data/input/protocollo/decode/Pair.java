package cnr.isti.data.input.protocollo.decode;

import com.alibaba.fastjson2.annotation.JSONField;

public class Pair<T, V> {
	@JSONField(name = "Descrizione")
	private T t;
	@JSONField(name = "Valore")
	private V v;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v = v;
	}

	public Pair(T t, V v) {

		this.t = t;
		this.v = v;
	}
	
	
	
	

}
