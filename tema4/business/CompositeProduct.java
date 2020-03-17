package business;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MeniuItem {

	 public List<MeniuItem> combinatie = new ArrayList<MeniuItem>();
	 
	public CompositeProduct(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calculeazaPret() {
		// TODO Auto-generated method stub
		int total=0;
		for(MeniuItem i:combinatie) {
			total=total+i.calculeazaPret();
		}
		return total;
	}

}
