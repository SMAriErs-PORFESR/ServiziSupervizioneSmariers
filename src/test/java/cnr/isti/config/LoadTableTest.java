package cnr.isti.config;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoadTableTest {

	@Test
	public void test() {
		LoadTable lt = new LoadTable();
		System.out.println(lt.getDiagnosticaDesc((byte) 0x39, 1));
		System.out.println(lt.getDiagnosticaDesc((byte) 0x11, 1));
	}

}
