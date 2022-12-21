/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Category;
import connexion.connexion;
import dao.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eve
 */
public class CategoryService implements IDAO<Category> {

    @Override
    public boolean create(Category o) {
        try {
			String sql = "insert into category values(null,'" + o.getNom()+ "')";
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
    public boolean delete(Category o) {
        try {
			String sql = "delete from category where id=" + o.getId();
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
    public boolean update(Category o) {
        try {
			String sql = "update category set nom='" + o.getNom() + "'";
			Statement st = connexion.getConnection().createStatement();
			if (st.executeUpdate(sql) == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
    }

    @Override
    public Category findById(int id) {
        try {
			String sql = "select * from category where id=" + id;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				return new Category(rs.getInt("id"), rs.getString("nom"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories;
		try {
			categories = new ArrayList<Category>();
			String sql = "select * from category";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				categories.add(new Category(rs.getInt("id"), rs.getString("nom")));
			}
			return categories;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    public int findCateId(String nom) {
		try {
			
			String sql = "select id from category where nom="+nom;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
    }
    
}
