package k.entity;

public class Commodity {
	private int comid;//商品ID
	private String comname;//商品名称
	private float comprice;//单价
	private String comimage;//图片
	private int comtotal;//库存
	private String comsort;//类别
	private String comdescribe;//描述
	private int merid;//商品所属商家
	public Commodity(String Comname,float Comprice,String Comimage,int Comtotal,String Comsort,String Comdescribe,int Merid){
		this.comname = Comname;
		this.comprice = Comprice;
		this.comimage = Comimage;
		this.comtotal = Comtotal;
		this.comsort = Comsort;
		this.comdescribe = Comdescribe;
		this.merid = Merid;
	}
	public Commodity() {
		// TODO Auto-generated constructor stub
	}
	public int getComid() {
		return comid;
	}
	public void setComid(int comid) {
		this.comid = comid;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	public float getComprice() {
		return comprice;
	}
	public void setComprice(float comprice) {
		this.comprice = comprice;
	}
	public String getComimage() {
		return comimage;
	}
	public void setComimage(String comimage) {
		this.comimage = comimage;
	}
	public int getComtotal() {
		return comtotal;
	}
	public void setComtotal(int comtotal) {
		this.comtotal = comtotal;
	}
	public String getComsort() {
		return comsort;
	}
	public void setComsort(String comsort) {
		this.comsort = comsort;
	}
	public String getComdescribe() {
		return comdescribe;
	}
	public void setComdescribe(String comdescribe) {
		this.comdescribe = comdescribe;
	}
	public int getMerid() {
		return merid;
	}
	public void setMerid(int merid) {
		this.merid = merid;
	}
	
}
