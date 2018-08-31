package jmr.holczer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SHA256HelperTest
{

	@Test
	public void generateHashTest()
	{
		// arrange
		String data = "I love you";
		String expected = "c33084feaa65adbbbebd0c9bf292a26ffc6dea97b170d88e501ab4865591aafd";
		// act
		String actual = SHA256Helper.generateHash(data);
		// assert
		assertEquals(expected, actual);

	}
}
