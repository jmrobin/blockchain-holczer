package jmr.holczer;

public class Application
{

	public static void main( String[] args )
	{
		Blockchain blockchain = new Blockchain();
		Miner miner = new Miner();

		Block block0 = new Block(0, "no transaction", "");
		block0.setHash(Constants.GENESIS_PREV_HASH);
		blockchain.addBlock(block0);

		Block block1 = new Block(1, "transaction 1", block0.getHash());
		blockchain.addBlock(block0);

		Block block2 = new Block(2, "transaction 2", block1.getHash());
		miner.mine(block2, blockchain);

	}

}
