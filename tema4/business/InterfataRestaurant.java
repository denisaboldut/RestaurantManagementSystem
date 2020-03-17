package business;

public interface InterfataRestaurant {
	//public void adaugareComanda();
	/**
	 * @pre k>=2
	 * @post @nochange
	 * @post notify
	 * */
	public void actualizare();
	
	
	/**
	 * @pre selectat!=NULL
	 * @post change selectat
	 * */
	public void editareSelectareProdus();
	
	/**
	 * @pre selectat!=NULL
	 * @post change table
	 * */
	public void stergereSelectareProdus();
	
	/**
	 * @pre selectat!=NULL
	 * @post  listaMeniu.size++
	 * @post comenzi.size++
	 * */
	public void creeazaComanda();
	
	
	/**
	 * @pre oV.getID!=NULL
	 * @pre oV.getMasa!=NULL
	 * @pre oV.getData!=NULL
	 * @post change table
	 * */
	public void incarcaComanda (); 
	
	
	/**
	 * @pre creeazaComanda() succeed
	 * @pre incarcaComanda() succeed
	 * @post change AreaText
	 * */
	  public void comanda();
	  
	  
	  /**
		 * @pre comenzi is not empty
		 * @post nochange
		 * @return pret
		 * */
	  public int calculeazaNotaDePlata();
	  
	  
	  
	  /**
	   * @post nochange
	   * @return true daca hastable comenzi este WellFormed
	   * */
	  public boolean isWellFormed();
	

}
