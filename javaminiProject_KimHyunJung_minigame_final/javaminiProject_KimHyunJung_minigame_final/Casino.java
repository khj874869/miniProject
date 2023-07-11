package javaminiProject_KimHyunJung_minigame;

public class Casino {
private String name="엄복동";
private double charge =10000;
private int life =6;

public Casino() {
	
	}
	public Casino(String name,double charge,int life) {
		this.name = name;
		this.setCharge(charge);
		this.setLife(life);
		
	}
	public String getname() {
		 return this.name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public double getcharge() {
	 return this.getCharge() ;
	}
	public void  setcharge(int charge) {
		this.setCharge(charge);
	}
	
	public int getLife() {
		return life;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public double getCharge() {
		return charge;
	}
	
	public void setCharge(double charge) {
		this.charge = charge;
	}

}
