package com.company.repositories;

import java.sql.PreparedStatement;
import com.company.data.interfaces.IDB;
import com.company.models.Product;
import com.company.repositories.interfaces.IProductRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final IDB db;

    public ProductRepository(IDB db){
        this.db = db;
    }
    @Override
    public boolean createProduct(Product product){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO services(model,memory,battery,price) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,product.getModel());
            st.setString(2,product.getMemory());
            st.setInt(3,product.getBattery());
            st.setInt(4,product.getPrice());

            st.execute();
            return true;
        }catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }
        return false;

    }

    @Override
    public Product getProduct(String model) {
        return null;
    }


    @Override
    public List<Product> getAllProducts(){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT model,memory,battery,price FROM services";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Product> users = new LinkedList<>();
            while (rs.next()) {
                Product product = new Product(rs.getString("model"),
                        rs.getString("memory"),
                        rs.getString("battery"),
                        rs.getString("price"));

                users.add(product);
            }

            return users;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return null;
    }
        }


