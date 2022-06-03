package cnr.isti.config;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoadTableIOTest {

	@Test
	public void test() {
		LoadTableIO lte = new LoadTableIO();
		
		System.out.println(lte.getTable(((byte) 0x39),3));

	}

}
