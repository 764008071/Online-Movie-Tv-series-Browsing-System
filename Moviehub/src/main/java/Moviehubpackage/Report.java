package Moviehubpackage;

public class Report {
	
	private int transaction_id;
	private String user_id;
	private String payment_date;
	private String payment_amount;
	private String payment_status;
	public Report(int transaction_id, String user_id, String payment_date, String payment_amount,
			String payment_status) {
		super();
		this.transaction_id = transaction_id;
		this.user_id = user_id;
		this.payment_date = payment_date;
		this.payment_amount = payment_amount;
		this.payment_status = payment_status;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getPayment_date() {
		return payment_date;
	}
	public String getPayment_amount() {
		return payment_amount;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}
	public void setPayment_amount(String payment_amount) {
		this.payment_amount = payment_amount;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	
	}

	

