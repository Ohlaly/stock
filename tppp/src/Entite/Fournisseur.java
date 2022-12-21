package Entite;

import java.sql.Blob;
import java.util.Objects;

public class Fournisseur {

	private int id;
        private Blob pic;
	private String name;
        private String lastname;
	private String telephone;
        private String email;
	private static int comp;

	public Fournisseur(Blob img,String name,String last, String telephone,String em) {
		super();
		this.id = ++comp;
                this.pic=img;
		this.name = name;
                this.lastname=last;
		this.telephone = telephone;
                this.email=em;
	}

	public Fournisseur(int id,Blob img, String name,String last, String telephone,String ema) {
		super();
		this.id = id;
                this.pic=img;
		this.name = name;
                this.lastname=last;
		this.telephone = telephone;
                this.email=ema;
	}
        public String getEmail()
        {
            return this.email;
        }
        public String getLastName()
        {
            return this.lastname;
        }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
        public Blob getImage()
        {
            return this.pic;
        }
        public void setImage(Blob img)
        {
            this.pic=img;
        }

	@Override
	public String toString() {
		return "" + name;
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.pic);
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.lastname);
        hash = 37 * hash + Objects.hashCode(this.telephone);
        hash = 37 * hash + Objects.hashCode(this.email);
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
        final Fournisseur other = (Fournisseur) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.pic, other.pic)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.telephone, other.telephone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

}
