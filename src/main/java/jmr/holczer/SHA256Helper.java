package jmr.holczer;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class SHA256Helper
{
	private SHA256Helper()
	{

	}

	public static String generateHash( String data )
	{
		try
		{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(data.getBytes("UTF-8"));
			Integer[] ints = toInteger(hash);
			String identity = "";
			BiFunction<String, Integer, String> mapper = ( s, b ) -> s + toHex(b);
			BinaryOperator<String> combiner = ( s1, s2 ) -> s1 + s2;
			return Arrays.stream(ints).parallel().reduce(identity, mapper, combiner);
		}
		catch (NoSuchAlgorithmException | UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}
	}

	public static Integer[] toInteger( byte[] bytes )
	{
		Integer[] ints = new Integer[bytes.length];
		for (int i = 0; i < bytes.length; i++)
		{
			ints[i] = (int) bytes[i];
		}
		return ints;
	}

	public static String toHex( int b )
	{
		return Integer.toString((b & 0xff) + 0x100, 16).substring(1);
	}
}
