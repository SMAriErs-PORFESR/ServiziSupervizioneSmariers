package cnr.isti.config;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoadTableTest {

	@Test
	public void test() {
		LoadTable lt = new LoadTable();
		System.out.println(lt.getDiagnosticaDesc((byte) 0x39, 32));
		System.out.println(lt.getDiagnosticaDesc((byte) 0x11, 1));
		System.out.println(lt.getTable(((byte) 0x39)));
		
		
		LoadTableEventi lte = new LoadTableEventi();
		System.out.println(lte.getDiagnosticaDesc((byte) 0x39, 33));
		System.out.println(lte.getTable(((byte) 0x39)));


	}
}
