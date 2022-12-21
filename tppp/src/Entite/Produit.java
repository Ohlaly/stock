package Entite;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.sql.Blob;
import java.util.Objects;
public class Produit {

	private int id;
        private String pic;
        private String Designation;
	private Category categor;
	private double prixAchat;
        private double tva;
	public int quantite;
	private static int comp;
	private Rayon rayon;
        private ImageIcon format=null;

	public Produit(String image,String design,Category designation, double prixAchat,double tva,int quantite, Rayon rayon) {
		this.id = ++comp;
                this.pic=image;
                this.Designation=design;
		this.categor = designation;
		this.prixAchat = prixAchat;
                this.tva=tva;
		this.quantite = 0;
		this.rayon = rayon;
	}
	public String getPic()
        {
            return this.pic;
        }

	public Produit(int id,String image,String design, Category designation, double prixAchat,double tva, int quantite, Rayon rayon) {
		super();
		this.id = id;
                this.pic=image;
                this.Designation=design;
		this.categor = designation;
		this.prixAchat = prixAchat;
                this.tva=tva;
		this.quantite = quantite;
		this.rayon = rayon;
	}


	public Produit(int id,String design, Category designation, double prixAchat, Rayon rayon) {
		super();
		this.id = id;
                this.Designation=design;
		this.categor = designation;
		this.prixAchat = prixAchat;
		this.quantite = 0;
		this.rayon = rayon;
	}
        public String getImage()
        {
            return this.pic;
        }
        public void setImage(String img)
        {
            this.pic=img;
        }
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategor() {
		return categor;
	}

	public void setCategor(Category designation) {
		this.categor = designation;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}
        
        public void setDesignation(String design)
        {
            this.Designation=design;
        }
        public String getDesignation()
        {
            return this.Designation;
        }
        
        public double getTva()
        {
            return this.tva;
        }

	@Override
	public String toString() {
		return  categor +": " +Designation;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.categor);
        hash = 67 * hash + Objects.hashCode(this.rayon);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if (!Objects.equals(this.categor, other.categor)) {
            return false;
        }
        if (!Objects.equals(this.rayon, other.rayon)) {
            return false;
        }
        return true;
    }

}
