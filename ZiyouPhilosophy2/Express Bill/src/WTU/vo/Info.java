package WTU.vo;


public class Info {
	private String begin;
	private String sender;
	private String senderPhone;
	private String senderAddress;
	private String receiver;
	private String receiverPhone;
	private String receiverAddress;
	private String jibaodi;
	private String number;
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderPhone() {
		return senderPhone;
	}
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getJibaodi() {
		return jibaodi;
	}
	public void setJibaodi(String jibaodi) {
		this.jibaodi = jibaodi;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Info() {
		super();
	}
	public Info(String begin, String sender, String senderPhone,
			String senderAddress, String receiver, String receiverPhone,
			String receiverAddress, String jibaodi,String number) {
		super();
		this.begin = begin;
		this.sender = sender;
		this.senderPhone = senderPhone;
		this.senderAddress = senderAddress;
		this.receiver = receiver;
		this.receiverPhone = receiverPhone;
		this.receiverAddress = receiverAddress;
		this.jibaodi = jibaodi;
		this.number=number;
	}
	@Override
	public String toString() {
		return "Info [begin=" + begin + ", sender=" + sender + ", senderPhone="
				+ senderPhone + ", senderAddress=" + senderAddress
				+ ", receiver=" + receiver + ", receiverPhone=" + receiverPhone
				+ ", receiverAddress=" + receiverAddress + ", jibaodi="
				+ jibaodi + ", number="+number+"]";
	}
}
