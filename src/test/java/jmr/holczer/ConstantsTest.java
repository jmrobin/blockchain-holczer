package jmr.holczer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConstantsTest
{
	@Test
	public void GenesisHash()
	{
		// arrange
		char[] c = new char[64];
		String expected = new String(c).replace(c[0], '0');
		// act
		String actual = Constants.GENESIS_PREV_HASH;
		// assert
		assertEquals(expected, actual);

	}
}
