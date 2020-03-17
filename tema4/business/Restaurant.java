package business;

import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Observable;

import javax.swing.table.DefaultTableModel;

import data.FileWriter;
import prezentarea.AdministratorView;
import prezentarea.OspatarView;
import prezentarea.SefBucatarView;

//This is the class being observed.
@SuppressWarnings("deprecation")
public class Restaurant extends Observable implements InterfataRestaurant {
	List<MeniuItem> listaMeniu = new ArrayList<MeniuItem>();
	public Hashtable<Comanda, List<MeniuItem>> comenzi = new Hashtable<Comanda, List<MeniuItem>>();
	AdministratorView aV;
	FileWriter f = new FileWriter();
	OspatarView oV;
	SefBucatarView sV;
	int i=0;
	int k=0;
	Comanda ptBon;
	String ptChef=new String();

	public Restaurant(AdministratorView aView,OspatarView oView,SefBucatarView sView) {
		aV = aView;
        oV=oView;
        sV=sView;
		// String s= new String(f.citesteItem());
		// System.out.println("AICI"+s);
		aV.incarcaProduse(f.citesteItem());
		aV.addListenerAdaugareProdus(new AdaugareProdus());
        editareSelectareProdus();
        stergereSelectareProdus();
        comanda();
        generareNotaDePlata();
      
      
      
	}

	///////////////////////// OBSERVER///////////////////////////////
	public void actualizare() {
		setChanged();
	if(k>=2) {
		notifyObservers(ptChef);
		}
	}
	////////////////////////////////////////////////////////////////

	public class AdaugareProdus implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String nou = new String(aV.iaProdusulNou());
			MeniuItem inou = new MeniuItem(nou);
			// listaMeniu.add(inou);
			// f.lista.add(inou);
			// f.item.meniu.add(inou);
			f.setItem(nou);
			f.scrieItem(f.itemuri);
			// String ceAmAvut=f.citesteItem();
			System.out.println("AICi" + f.item);
			aV.incarcaProduse(f.citesteItem());
		}

	}
	
	public void editareSelectareProdus() {
		
		aV.tabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				DefaultTableModel modelTabel=(DefaultTableModel)aV.tabel.getModel();
				int randSelectat=aV.tabel.getSelectedRow();
				String selectat = new String(modelTabel.getValueAt(randSelectat, 0).toString());
				for (String val : f.itemuri.split(",")) {
					MeniuItem m =new MeniuItem(val);
					listaMeniu.add(m);
				}
					aV.addListenerEditare(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							
							//for(MeniuItem i: listaMeniu) {
								//if (selectat.equals(i.toString()) ) {
									listaMeniu.add(randSelectat, new MeniuItem(selectat));
									//System.out.println("sadsa");
								//}
						//}
							//aV.incarcaProduse(listaMeniu.toString());
						}
					});		
				//System.out.println(modelTabel.getValueAt(randSelectat, 0).toString());
			}
		});	
	}
	
public void stergereSelectareProdus() {
		
		aV.tabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				DefaultTableModel modelTabel=(DefaultTableModel)aV.tabel.getModel();
				int randSelectat=aV.tabel.getSelectedRow();
				String selectat = new String(modelTabel.getValueAt(randSelectat, 0).toString());
				for (String val : f.itemuri.split(",")) {
					MeniuItem m =new MeniuItem(val);
					listaMeniu.add(m);
				}
					aV.addListenerStergere(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
					    // System.out.println("adadd");
							listaMeniu.remove(randSelectat);
							aV.incarcaProduse(listaMeniu.toString());
						}
					});
			}
		});	
}
public void creeazaComanda() {
	oV.tabelCopie.addMouseListener(new java.awt.event.MouseAdapter() {
		DefaultTableModel modelTabel1=(DefaultTableModel)oV.tabel1.getModel();
		
		public void mouseClicked(java.awt.event.MouseEvent evt) {
			
			DefaultTableModel modelTabel=(DefaultTableModel)oV.tabelCopie.getModel();
			
			int randSelectat=oV.tabelCopie.getSelectedRow();
			String inainte=(String) oV.tabel1.getValueAt(i-1, 3);
			if(inainte==null) {
				inainte="";
			}
			
			String selectat = new String(modelTabel.getValueAt(randSelectat, 0).toString());
			//String selectat1 = new String(modelTabel1.getValueAt(randSelectat, 0).toString());
			oV.tabel1.setValueAt(inainte+selectat+",", i-1,3 );
			ptChef="actualizare:"+inainte+"+"+selectat;
			////////////////////////////////////////////////
			int idComanda=Integer.valueOf(oV.getId());
			int nrMasa=Integer.valueOf(oV.getMasa());
			String data=oV.getData();
			Comanda comanda=new Comanda();
			comanda.comandaID=idComanda;
			comanda.data=data;
			comanda.nrMasa=nrMasa;
			
			//listaMeniu = new ArrayList<MeniuItem>();
			
			MeniuItem item=new MeniuItem(selectat,i*3+selectat.length()*3);
			
			listaMeniu.add(item);
			ptBon=comanda;
			comenzi.put(comanda, listaMeniu);
			
			k++;
			 System.out.println(comenzi);
			 System.out.println(item.getPret());
			// System.out.println("K= "+ptChef);
			 actualizare();
        }

	});
}
  public void incarcaComanda () {
	  int j=0;
	 
	  oV.tabel1.setValueAt(oV.getId(), i, j);
	  j++;
	  oV.tabel1.setValueAt(oV.getData(), i, j);
	  j++;
	  oV.tabel1.setValueAt(oV.getMasa(), i, j);
	  i++;
  }
  public void comanda() {
	  
	  creeazaComanda();
		 
      oV.addListenerComanda(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
				k=0;
				incarcaComanda();
				setChanged();
				notifyObservers("--------------------------------------");
			}
      	
      });
  }
  
      public int calculeazaNotaDePlata() {
    	  int pret=0;;
    	 for(MeniuItem j :comenzi.get(ptBon) ) {
    		 pret=pret+j.getPret();
    	 }
    	 return pret;		  
      }
      
      public void generareNotaDePlata(){
    	  oV.addListenerBill(new ActionListener() {
 		@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
 			try {
 	        	 PrintWriter writer = new PrintWriter("factura"+ptBon.comandaID+".txt", "UTF-8");
 	        	 writer.println("----BON FISCAL----");
 	        	 writer.println("Data: "+ptBon.data);
 	        	 writer.println("La masa: "+ptBon.nrMasa);
 	        	 writer.println("S-a inregistrat urmatoarea consumatie:");
 	        	 writer.println(comenzi.get(ptBon));
 	        	 writer.println("In valoare de: "+calculeazaNotaDePlata()+" lei." );
 	        	 writer.println("Va mai asteptam!");
 	        	 writer.close();
 	         }catch(Exception e){
 	        	System.out.println("Nu s-a putut crea bonul;");	 
 	         }
			}    
			});
      }
      
      public boolean isWellFormed() {
    	  boolean corect;
    	  int nrCorecte;
    	  int nrComenzi = 0;
    	  for(Comanda j :comenzi.keySet()) {
    		  nrComenzi++;
     	 }
    	  nrCorecte=comenzi.size();
    	  if(nrCorecte==nrComenzi) {
    		  corect=true;
    	  }
    	  else corect=false;
    	  return corect;
      }
}
