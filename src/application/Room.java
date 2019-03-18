package application;

public class Room {
	public int rn;
	public String rt;
	public String bt;
	public int p;
	public int avail;
	Room(int rn,String rt,String bt,int p){
		this.rn=rn;
		this.rt=rt;
		this.bt=bt;
		this.p=p;
		this.avail=1;
	}
	Room(int rn,String rt,String bt,int p,int avail){
		this.rn=rn;
		this.rt=rt;
		this.bt=bt;
		this.p=p;
		this.avail=avail;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public String getRt() {
		return rt;
	}
	public void setRt(String rt) {
		this.rt = rt;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getAvail() {
		return avail;
	}
	public void setAvail(int avail) {
		this.avail = avail;
	}
}
