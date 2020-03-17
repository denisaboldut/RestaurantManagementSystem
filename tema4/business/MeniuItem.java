package business;

public class MeniuItem {
	private String denumire;
	private int pret;
	
	
	public MeniuItem(String s) {
		denumire=s;
	
	}
	
	public MeniuItem(String s,int pret) {
		denumire=s;
		this.pret=pret;
	}

	 public int calculeazaPret() {
		 return pret;
	 }

	@Override
	public String toString() {
		return  denumire;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public int getPret() {
		return pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}
}
