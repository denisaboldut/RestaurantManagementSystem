package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import business.MeniuItem;

public class FileWriter {

	String file = "file.txt";
	public String itemuri = new String("ciolan afumat,costite de porc,piept de pui,ton,"
			+ "cartofi prajiti,cartofi natur,cartofi piure," + "cascaval pane,branza de vaca,branza de oaie,telemea,"
			+ "paste,pene,spaghete," + "rosii,castraveti,ridichi,salata,varza,ceapa,usturoi,"
			+ "ou fiert,ou prajit,omleta," + "piper,sare,ulei,otet,"
			+ "sos de rosii,sos picant,sos alb,sos de usturoi,maioneza,sos de cascaval," + "tiramisu,cremes,ecler");
	public MeniuItem menuItem = new MeniuItem(itemuri);
	public List<MeniuItem> lista = new ArrayList<MeniuItem>();

	public RestaurantSerializare item;

	public FileWriter() {
		lista.add(menuItem);
		item = new RestaurantSerializare(lista);
		scrieItem(item.toString());
		// citesteItem();
	}

	public void scrieItem(String s) {

		try {
			FileOutputStream fisier = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fisier);
			out.writeObject(s);
			/////////////
			out.close();
			fisier.close();
			System.out.println("Object has been serialized\n" + s);
		} catch (IOException ex) {
			System.out.println("Eroare la scriere in fiser");
		}

	}

	public String citesteItem() {
		// List<MeniuItem> item=new ArrayList<MeniuItem>();
		String items = new String();
		ObjectInputStream in = null;
		try {
			FileInputStream fisier = new FileInputStream(file);
			in = new ObjectInputStream(fisier);
			items = (String) in.readObject();
			/////////////
			in.close();
			fisier.close();
			System.out.println("\nObject has been deserialized ");
			// System.out.println (items);
			MeniuItem menuItem = new MeniuItem(items);
			List<MeniuItem> lista = new ArrayList<MeniuItem>();
			lista.add(menuItem);
			item = new RestaurantSerializare(lista);
			System.out.println(item.toString());

		} catch (IOException ex) {
			System.out.println("Eroare la citire din fiser");
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException");
		}
		return items;

	}

	public void setItem(String s) {
		itemuri = itemuri + "," + s;
	}

}
