package jmr.holczer;

import java.util.ArrayList;
import java.util.List;

public class Blockchain
{
	private List<Block> blockchain;

	public Blockchain()
	{
		blockchain = new ArrayList<>();
	}

	public void addBlock( Block block )
	{
		this.blockchain.add(block);
	}

	public List<Block> getBlockChain()
	{
		return new ArrayList<Block>(this.blockchain);
	}

	public int size()
	{
		return this.blockchain.size();
	}
}
