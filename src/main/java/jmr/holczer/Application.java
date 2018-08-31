package jmr.holczer;

public class Application
{

	public static void main( String[] args )
	{
		String data = "I love you";
		String result = SHA256Helper.generateHash(data);
		System.out.println(result);

	}

}
