package tema4;

import business.Comanda;
import business.Restaurant;
import data.FileWriter;
import prezentarea.AdministratorView;
import prezentarea.OspatarView;
import prezentarea.SefBucatarView;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdministratorView av= new AdministratorView();
		 OspatarView ov= new OspatarView();
		 SefBucatarView sv= new SefBucatarView();
		Restaurant r =new Restaurant(av,ov,sv);

	   
		r.addObserver(sv);
		r.actualizare();
		FileWriter f= new FileWriter();
	
		
		av.setVisible(true);
		ov.setVisible(true);
		sv.setVisible(true);
		
	  
	
	}

}
