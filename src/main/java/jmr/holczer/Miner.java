package jmr.holczer;

public class Miner
{
	private double reward;

	public void mine( Block block, Blockchain blockchain )
	{
		while (!isGoldenHash(block.getHash(), Constants.DIFFICULTY))
		{
			block.generateHash();
			block.incrementNonce();
		}

		System.out.println("Block has just mined");
		System.out.println("Hash is " + block.getHash());

		blockchain.addBlock(block);
		reward += Constants.MINER_REWARD;
	}

	public boolean isGoldenHash( String hash, int difficulty )
	{
		char[] c = new char[difficulty];
		String s = new String(c).replace(c[0], '0');
		return hash.substring(0, difficulty).equals(s);
	}

	public double getReward()
	{
		return this.reward;
	}
}
