package cnr.isti.data.input.protocollo;

import com.alibaba.fastjson2.annotation.JSONField;

public class Triple<T, V, Z> {
	@JSONField(name = "Descrizione")
	private T t;
	@JSONField(name = "Stato")
	private V v;
	@JSONField(name = "Index")
	private Z z;
	
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
	

	public Z getZ() {
		return z;
	}
	public void setZ(Z z) {
		this.z = z;
	}
	public Triple(T t, V v, Z z) {

		this.t = t;
		this.v = v;
		this.z = z;
	}
	
	
	
	

}
