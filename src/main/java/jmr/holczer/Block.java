package jmr.holczer;

import java.time.Instant;

public class Block
{
	private int id;
	private int nonce;
	private long timestamp;
	private String hash;
	private String previousHash;
	private String transaction;

	public Block( int id, String transaction, String previousHash )
	{
		this.id = id;
		this.transaction = transaction;
		this.previousHash = previousHash;
		this.timestamp = Instant.now().toEpochMilli();
		generateHash();
	}

	public void generateHash()
	{
		String data = previousHash + id + nonce + timestamp + transaction;
		hash = SHA256Helper.generateHash(data);
	}

	public String getHash()
	{
		return this.hash;
	}

	public void setHash( String hash )
	{
		this.hash = hash;
	}

	public void incrementNonce()
	{
		this.nonce++;
	}

	@Override
	public String toString()
	{
		return this.id + " " + this.hash;
	}
}
