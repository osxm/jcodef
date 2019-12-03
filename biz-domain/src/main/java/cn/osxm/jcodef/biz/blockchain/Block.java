/**
 * @Title: Block.java
 * @Package cn.osxm.jcodef.biz.blockchain
 * @Description: TODO
 * @author oscarchen
 * @date 2019年12月3日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.blockchain;

import java.util.List;

/**
  * @ClassName: Block
  * @Description: TODO
  * @author oscarchen
  */
public class Block {
	/**
     * 区块索引号
     */
    private int index;

    /**
     * 区块标识Hash值
     */
    private String hash;

    private long temestamp;

    private List<Transaction> transactions;

    private int nonce;

    private String lastHash;

    public Block() {

    }

    public Block(int index,  long temestamp, List<Transaction> transactions, int nonce, String lastHash,String hash) {
        this.index = index;
        this.hash = hash;
        this.temestamp = temestamp;
        this.transactions = transactions;
        this.nonce = nonce;
        this.lastHash = lastHash;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getTemestamp() {
        return temestamp;
    }

    public void setTemestamp(long temestamp) {
        this.temestamp = temestamp;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getLastHash() {
        return lastHash;
    }

    public void setLastHash(String lastHash) {
        this.lastHash = lastHash;
    }
}
