/**
 * @Title: Transaction.java
 * @Package cn.osxm.jcodef.biz.blockchain
 * @Description: TODO
 * @author oscarchen
 * @date 2019年12月3日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.blockchain;

/**
  * @ClassName: Transaction
  * @Description: TODO
  * @author oscarchen
  */
public class Transaction {
	 private String id;

	    private String sender;

	    private String recipient;

	    private float amount;

	    public Transaction() {

	    }

	    public Transaction(String id, String sender, String recipient, float amount) {
	        this.id = id;
	        this.sender = sender;
	        this.recipient = recipient;
	        this.amount = amount;
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getSender() {
	        return sender;
	    }

	    public void setSender(String sender) {
	        this.sender = sender;
	    }

	    public String getRecipient() {
	        return recipient;
	    }

	    public void setRecipient(String recipient) {
	        this.recipient = recipient;
	    }

	    public float getAmount() {
	        return amount;
	    }

	    public void setAmount(float amount) {
	        this.amount = amount;
	    }
}
