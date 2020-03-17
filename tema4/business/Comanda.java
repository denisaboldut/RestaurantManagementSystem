package business;


import java.util.Objects;

public class Comanda {
  public int comandaID;
  public String data;
  public int nrMasa;
  
  public boolean equals(Object deComparat) {
	  if(deComparat == this ) return true;
	  if(deComparat instanceof Comanda) {
		  Comanda comanda = (Comanda) deComparat;
		  return comandaID == comanda.comandaID &&
				  Objects.equals(comanda.data,data) &&
				  nrMasa==comanda.nrMasa;
	  }
	  else return false;
  }
  public int hashCode() {
	  return Objects.hash(comandaID,data,nrMasa);
  }
}
