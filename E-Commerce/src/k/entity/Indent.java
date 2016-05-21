package k.entity;

public class Indent {
	private int comid;
	private int cusid;
	private int time;
	private float purchase;
	public Indent() {
		// TODO Auto-generated constructor stub
	}
	public Indent(int Comid,int Cusid,int Time,float Purchase){
		this.comid = Comid;
		this.cusid = Cusid;
		this.time = Time;
		this.purchase = Purchase;
	}
	public int getComid() {
		return comid;
	}
	public void setComid(int comid) {
		this.comid = comid;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public float getPurchase() {
		return purchase;
	}
	public void setPurchase(float purchase) {
		this.purchase = purchase;
	}
	
}
