package Service;

import Entite.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entite.Produit;
import connexion.connexion;
import dao.IDAO;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ProduitService implements IDAO<Produit> {

	private RayonService rss;
        private CategoryService cs;

	public ProduitService() {
		rss = new RayonService();
	     cs=new CategoryService();
        }

	@Override
	public boolean create(Produit o) {
		try {
			String sql = "insert into produit values(null,'"+o.getImage()+"','"+o.getDesignation()+"'," + o.getCategor().getId() + "," + o.getPrixAchat() + ","+o.getTva()+","
					+ o.getQuantite() + "," + o.getRayon().getId() + ")";
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
	public boolean delete(Produit o) {
		try {
			String sql = "delete from produit where id=" + o.getId();
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
	public boolean update(Produit o) {
		try {
			String sql = "update produit set image='"+o.getImage()+"',Designation='"+o.getDesignation()+"',categor=" + o.getCategor().getId() + ",prixAchat=" + o.getPrixAchat()+",TVA="+o.getTva()
					+ ",quantite=" + o.getQuantite() + ",rayon=" + o.getRayon().getId();
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
	public Produit findById(int id) {
		try {
			String sql = "select * from produit where id=" + id;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				return new Produit(rs.getInt("id"),rs.getString("image"),rs.getString("Designation"), cs.findById(rs.getInt("categor")), rs.getDouble("prixAchat"),rs.getDouble("TVA"),
						rs.getInt("quantite"), rss.findById(rs.getInt("rayon")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> produits;
		try {
			produits = new ArrayList<Produit>();
			String sql = "select * from produit";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				produits.add(new Produit(rs.getInt("id"),rs.getString("image"),rs.getString("Designation"), cs.findById(rs.getInt("categor")), rs.getDouble("prixAchat"),rs.getDouble("TVA"),
						rs.getInt("quantite"), rss.findById(rs.getInt("rayon"))));
			}
			return produits;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
        public List<Produit> findByCategory(String cat) {
		List<Produit> produits;
		try {
			produits = new ArrayList<Produit>();
			String sql = "select * from produit p,category c where p.categor=c.id and c.nom='"+cat+"'";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				produits.add(new Produit(rs.getInt("id"),rs.getString("image"),rs.getString("Designation"), cs.findById(rs.getInt("categor")), rs.getDouble("prixAchat"),rs.getDouble("TVA"),
						rs.getInt("quantite"), rss.findById(rs.getInt("rayon"))));
			}
			return produits;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
        public List<Produit> findByDesign(String cat) {
		List<Produit> produits;
		try {
			produits = new ArrayList<Produit>();
			String sql = "select * from produit p where Designation='"+cat+"'";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				produits.add(new Produit(rs.getInt("id"),rs.getString("image"),rs.getString("Designation"), cs.findById(rs.getInt("categor")), rs.getDouble("prixAchat"),rs.getDouble("TVA"),
						rs.getInt("quantite"), rss.findById(rs.getInt("rayon"))));
			}
			return produits;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
        public List<Produit> findByPrix(double cat) {
		List<Produit> produits;
		try {
			produits = new ArrayList<Produit>();
			String sql = "select * from produit p where prixAchat<="+cat+"";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				produits.add(new Produit(rs.getInt("id"),rs.getString("image"),rs.getString("Designation"), cs.findById(rs.getInt("categor")), rs.getDouble("prixAchat"),rs.getDouble("TVA"),
						rs.getInt("quantite"), rss.findById(rs.getInt("rayon"))));
			}
			return produits;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
        public List<Produit> findByRayon(String cat) {
		List<Produit> produits;
		try {
			produits = new ArrayList<Produit>();
			String sql = "select * from produit p,rayon r where p.rayon=r.id and r.code='"+cat+"'";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				produits.add(new Produit(rs.getInt("id"),rs.getString("image"),rs.getString("Designation"), cs.findById(rs.getInt("categor")), rs.getDouble("prixAchat"),rs.getDouble("TVA"),
						rs.getInt("quantite"), rss.findById(rs.getInt("rayon"))));
			}
			return produits;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
        
        
}
