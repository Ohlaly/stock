package Entite;

public class LigneDemande {

	
	private Produit produit;
	private Demande demande;
	private int quantite;

	public LigneDemande(Produit produit, Demande demande, int quantite) {
		super();
		
		this.produit = produit;
		this.demande = demande;
		this.quantite = quantite;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public LigneDemande(int id, Produit produit, Demande demande, int quantite) {
		super();
		
		this.produit = produit;
		this.demande = demande;
		this.quantite = quantite;
	}

	

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	@Override
	public String toString() {
		return "LigneDemande produit=" + produit.getDesignation()+" quantite:"+quantite + ", demande=" + demande ;
	}

}
