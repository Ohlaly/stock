package Service;

import Entite.Demande;
import Entite.Fournisseur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entite.LigneCommande;
import Entite.LigneDemande;
import Entite.Produit;
import connexion.connexion;
import dao.IDAO;
import java.sql.PreparedStatement;
import java.util.Date;

public class LigneDemandeService implements IDAO<LigneDemande> {

	private DemandeService ds;
	private ProduitService ps;
        private FournisseurService fs;

	public LigneDemandeService() {
		ds = new DemandeService();
		ps = new ProduitService();
                fs=new FournisseurService();
	}

	@Override
	public boolean create(LigneDemande o) {
		try {
			String sql = "insert into lignedemande values("+o.getProduit().getId()+","+ o.getDemande().getId()
					+ "," + o.getQuantite() + ")";
			Produit p=ps.findById(o.getProduit().getId());
			if(p!=null)
			{
			p.quantite=p.quantite+o.getQuantite();
			String sql2="update produit set quantite="+p.quantite +" where id="+o.getProduit().getId();
			Statement st2=connexion.getConnection().createStatement();
			st2.executeUpdate(sql2);
			}
			Statement st = connexion.getConnection().createStatement();
			if (st.executeUpdate(sql) == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(LigneDemande o) {
		try {
			String sql = "delete from lignedemande where produit=" + o.getProduit().getId()+" and demande="+o.getDemande().getId();
			Statement st = connexion.getConnection().createStatement();
			if (st.executeUpdate(sql) == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(LigneDemande o) {
		try {
			String sql = "update lignedemande set produit=" + o.getProduit().getId() + ",demande="
					+ o.getDemande().getId() + ",quantite=" + o.getQuantite();
			Statement st = connexion.getConnection().createStatement();
			if (st.executeUpdate(sql) == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public LigneDemande findById(int id) {
		try {
			String sql = "select *from lignedemande where id=" + id;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				return new LigneDemande(ps.findById(rs.getInt("produit")),
						ds.findById(rs.getInt("demande")), rs.getInt("quantite"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<LigneDemande> findAll() {
		List<LigneDemande> lignedemandes;
		try {

			lignedemandes = new ArrayList<LigneDemande>();
			String sql = "select * from lignedemande";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				lignedemandes.add(new LigneDemande(ps.findById(rs.getInt("produit")),
						ds.findById(rs.getInt("demande")), rs.getInt("quantite")));
			}
			return lignedemandes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
        public List<LigneDemande> findSpec() {
		List<LigneDemande> lignedemandes;
		try {
			lignedemandes = new ArrayList<LigneDemande>();
			String sql = "select l.produit,l.demande, p.image,d.fournisseur,d.date,l.quantite from lignedemande l,demande d,produit p where l.demande=d.id and l.produit=p.id";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
                            Produit p=ps.findById(rs.getInt("produit"));
                            p.setImage(rs.getString("image"));
                            Demande d=ds.findById(rs.getInt("demande"));
                            Fournisseur f=fs.findById(rs.getInt("fournisseur"));
                            Date dat=rs.getDate("date");
                            d.setFournisseur(f);
                            d.setDate(dat);
				lignedemandes.add(new LigneDemande(p,d, rs.getInt("quantite")));
			}
			return lignedemandes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
        public List<LigneDemande> findBetweenDate(java.util.Date d1,java.util.Date d2) {
        List<LigneDemande> lignedemandes;
		try {
			lignedemandes = new ArrayList<LigneDemande>();
			String sql = "select l.produit,l.demande, p.image,d.fournisseur,d.date,l.quantite from lignedemande l,demande d,produit p where l.demande=d.id and l.produit=p.id and d.date between ? and ?";
			PreparedStatement st = connexion.getConnection().prepareStatement(sql);
                        st.setDate(1, new java.sql.Date(d1.getTime()));
                        st.setDate(2, new java.sql.Date(d2.getTime()));
                        ResultSet rs = st.executeQuery();
			while (rs.next()) {
                            Produit p=ps.findById(rs.getInt("produit"));
                            p.setImage(rs.getString("image"));
                            Demande d=ds.findById(rs.getInt("demande"));
                            Fournisseur f=fs.findById(rs.getInt("fournisseur"));
                            Date dat=rs.getDate("date");
                            d.setFournisseur(f);
                            d.setDate(dat);
				lignedemandes.add(new LigneDemande(p,d, rs.getInt("quantite")));
			}
			return lignedemandes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
public List<LigneDemande> findSpecial(String l) {
		List<LigneDemande> lignedemandes;
		try {
			lignedemandes = new ArrayList<LigneDemande>();
			String sql = "select l.produit,l.demande, p.image,d.fournisseur,d.date,l.quantite from lignedemande l,demande d,produit p,fournisseur f where l.demande=d.id and l.produit=p.id and d.fournisseur=f.id and f.name='"+l+"'";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
                            Produit p=ps.findById(rs.getInt("produit"));
                            p.setImage(rs.getString("image"));
                            Demande d=ds.findById(rs.getInt("demande"));
                            Fournisseur f=fs.findById(rs.getInt("fournisseur"));
                            Date dat=rs.getDate("date");
                            d.setFournisseur(f);
                            d.setDate(dat);
				lignedemandes.add(new LigneDemande(p,d, rs.getInt("quantite")));
			}
			return lignedemandes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
public List<LigneDemande> findSpecialist(String l) {
		List<LigneDemande> lignedemandes;
		try {
			lignedemandes = new ArrayList<LigneDemande>();
			String sql = "select l.produit,l.demande, p.image,d.fournisseur,d.date,l.quantite from lignedemande l,demande d,produit p where l.demande=d.id and l.produit=p.id and p.Designation='"+l+"'";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
                            Produit p=ps.findById(rs.getInt("produit"));
                            p.setImage(rs.getString("image"));
                            Demande d=ds.findById(rs.getInt("demande"));
                            Fournisseur f=fs.findById(rs.getInt("fournisseur"));
                            Date dat=rs.getDate("date");
                            d.setFournisseur(f);
                            d.setDate(dat);
				lignedemandes.add(new LigneDemande(p,d, rs.getInt("quantite")));
			}
			return lignedemandes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
