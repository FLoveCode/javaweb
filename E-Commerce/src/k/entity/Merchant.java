package k.entity;

public class Merchant {
	private int merid;//商家ID
	private String mername;//商家姓名
	private String merpassword;//商家密码
	private String mersex;//性别
	private int meryear;//出生年份
	private String mertele;//电话
	private boolean mercheck;//审核通过
	public Merchant() {
		// TODO Auto-generated constructor stub
	}
	public Merchant(String Mername,String Merpassword,String Mersex,int Meryear,String Mertele,boolean Mercheck){
		this.mername = Mername;
		this.merpassword = "987654";
		this.mersex = "3";
		this.meryear = Meryear;
		this.mertele = Mertele;
		this.mercheck = false;
		
	}
	public int getMerid() {
		return merid;
	}
	public void setMerid(int merid) {
		this.merid = merid;
	}
	public String getMername() {
		return mername;
	}
	public void setMername(String mername) {
		this.mername = mername;
	}
	public String getMerpassword() {
		return merpassword;
	}
	public void setMerpassword(String merpassword) {
		this.merpassword = merpassword;
	}
	public String getMersex() {
		return mersex;
	}
	public void setMersex(String mersex) {
		this.mersex = mersex;
	}
	public int getMeryear() {
		return meryear;
	}
	public void setMeryear(int meryear) {
		this.meryear = meryear;
	}
	public String getMertele() {
		return mertele;
	}
	public void setMertele(String mertele) {
		this.mertele = mertele;
	}
	public boolean isMercheck() {
		return mercheck;
	}
	public void setMercheck(boolean mercheck) {
		this.mercheck = mercheck;
	}
	
}
