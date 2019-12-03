/**
 * @Title: MineDemo.java
 * @Package cn.osxm.jcodef.biz.blockchain
 * @Description: TODO
 * @author oscarchen
 * @date 2019年12月3日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.blockchain;

import java.util.ArrayList;
import java.util.List;

/**
  * @ClassName: MineDemo
  * @Description: TODO
  * @author oscarchen
  */
public class MineDemo {
	 private static void mineBlock(List<Block> blockchain, List<Transaction> txs, String address) {
	        Transaction sysTx = new Transaction(CryptoUtil.UUID(), "", address, 10);
	        txs.add(sysTx);
	        Block latestBlock = blockchain.get(blockchain.size() - 1);
	        int nonce = 1;
	        String hash = "";
	        while (true) {
	            hash = CryptoUtil.SHA256(latestBlock.getHash() + JSON.toJSONString(txs) + nonce);
	            //if (hash.startsWith("0000000000")) {
	            if (hash.startsWith("0000")) {
	                System.out.println("=====计算结果正确，计算次数为：" + nonce + ",hash:" + hash);
	                break;
	            }
	            nonce++;
	            System.out.println("计算错误，hash:" + hash);
	        }
	        Block newBlock = new Block(latestBlock.getIndex() + 1, System.currentTimeMillis(), txs, nonce, latestBlock.getHash(), hash);
	        blockchain.add(newBlock);
	        System.out.println("挖矿后的区块链：" + JSON.toJSONString(blockchain));
	    }

	    public static int getWalletBalance(List<Block> blockchain, String address) {
	        int balance = 0;
	        for (Block block : blockchain) {
	            List<Transaction> transactions = block.getTransactions();
	            for (Transaction transaction : transactions) {
	                if (address.equals(transaction.getRecipient())) {
	                    balance += transaction.getAmount();
	                }
	                if (address.equals(transaction.getSender())) {
	                    balance -= transaction.getAmount();
	                }
	            }
	        }
	        return balance;
	    }

	    /**
	     * @Title: main
	     * @Description: TODO
	     * @param args
	     */

	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        List<Block> blockchain = new ArrayList<>();
	        Block block = new Block(1, System.currentTimeMillis(), new ArrayList<Transaction>(), 1, "1", "1");
	        blockchain.add(block);
	        System.out.println(JSON.toJSONString(blockchain));
	        String sender = "sender_wallet";
	        String recipient = "recipient_wallet";
	        List<Transaction> txs = new ArrayList<>();

	        mineBlock(blockchain, txs, sender);
	        System.out.println(sender + "钱包的余额为：" + getWalletBalance(blockchain, sender));

	        List<Transaction> txs1 = new ArrayList<>();
	        Transaction tx1 = new Transaction(CryptoUtil.UUID(), sender, recipient, 3);
	        Transaction tx2 = new Transaction(CryptoUtil.UUID(), sender, recipient, 1);
	        txs1.add(tx1);
	        txs1.add(tx2);

	        mineBlock(blockchain, txs1, sender);
	        System.out.println(sender + "钱包的余额为：" + getWalletBalance(blockchain, sender));
	        System.out.println(recipient + "钱包的余额为：" + getWalletBalance(blockchain, recipient));
	    }
}
