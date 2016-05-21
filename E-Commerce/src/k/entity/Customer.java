package k.entity;

public class Customer {
	private int cusid;//顾客ID
	private String cusname;//顾客名
	private String cuspassword;//顾客密码
	private String cussex;//性别
	private String cusyear;//出生年份
	private String custele;//电话号码
	private boolean cuscheck;//通过审核
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String Cusname,String Cuspassword,String Cussex,String Cusyear,String Custele,boolean Cuscheck){
		this.cusname = Cusname;
		this.cuspassword = "123456";
		this.cussex = "3";
		this.cusyear = Cusyear;
		this.custele = Custele;
		this.cuscheck = false;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public String getCuspassword() {
		return cuspassword;
	}
	public void setCuspassword(String cuspassword) {
		this.cuspassword = cuspassword;
	}
	public String getCussex() {
		return cussex;
	}
	public void setCussex(String cussex) {
		this.cussex = cussex;
	}
	public String getCusyear() {
		return cusyear;
	}
	public void setCusyear(String cusyear) {
		this.cusyear = cusyear;
	}
	public String getCustele() {
		return custele;
	}
	public void setCustele(String custele) {
		this.custele = custele;
	}
	public boolean isCuscheck() {
		return cuscheck;
	}
	public void setCuscheck(boolean cuscheck) {
		this.cuscheck = cuscheck;
	}
	
}

