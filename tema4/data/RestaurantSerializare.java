package data;

import java.util.ArrayList;
import java.util.List;

import business.MeniuItem;

public class RestaurantSerializare implements java.io.Serializable {

	public List<MeniuItem> meniu = new ArrayList<MeniuItem>();
	
	public RestaurantSerializare(List<MeniuItem> meniu) {
		super();
		this.meniu = meniu;
	}

	@Override
	public String toString() {
		return meniu.toString();
	}
}
