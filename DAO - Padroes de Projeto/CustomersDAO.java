//Author: Gabriel Jose da Silva dos Santos
//Author: Ranniery Lucas de Carvalho Moreira

package main_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAO {
	
	private Connection con;
	
	public CustomersDAO() {
		this.con = new ConnectionFactory().GetConnection();
	}

	public void inserir(Customers c) {
	
		String sql = "INSERT INTO customers(company, last_name, first_name, mobile_phone, city, state_province, zip_postal_code, country_region) VALUES (?,?,?,?,?,?,?,?)";	
		
		try {
			
			PreparedStatement stat = this.con.prepareStatement(sql);
			
			stat.setString(1, c.getCompany());
			stat.setString(2, c.getLast_name());
			stat.setString(3, c.getFirst_name());
			stat.setString(4, c.getMobile_phone());
			stat.setString(5, c.getCity());
			stat.setString(6, c.getState_province());
			stat.setString(7, c.getZip_postal_code());
			stat.setString(8, c.getCountry_region());
			
			stat.execute();
			stat.close();
		}catch(SQLException e){
			e.getMessage();
		}
	}
	
	public void recuperar_clientes() {
		String sql = "select * from customers";
		List<Customers> lista = new ArrayList<Customers>();
		
		try {
			PreparedStatement stat = con.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				
				Customers os = new Customers();
				os.setId(rs.getInt("id"));
				os.setCity(rs.getString("city"));
				os.setCompany(rs.getString("company"));
				os.setCountry_region(rs.getString("country_region"));
				os.setFirst_name(rs.getString("first_name"));
				os.setLast_name(rs.getString("last_name"));
				os.setMobile_phone(rs.getString("mobile_phone"));
				os.setState_province(rs.getString("state_province"));
				os.setZip_postal_code(rs.getString("zip_postal_code"));
				
				lista.add(os);	
			}
			
			rs.close();
			stat.close();
			
			for(Customers customer : lista) {
				System.out.println("| Id: " + customer.getId() + "| City: " + customer.getCity() + "| Company: " + customer.getCompany() + "| Country: " + customer.getCountry_region() + "| FirstN: " + customer.getFirst_name() + "| LastN: " + customer.getLast_name() + "| Mobile: " + customer.getMobile_phone() + "| State: " + customer.getState_province() + "| Zip: " + customer.getZip_postal_code());
			}
			
		}catch(SQLException e){
			e.getMessage();
		}
		
	}
	
	public void recupera_cliente_por_id(int ide) {
		String sql = "select * from customers where id=?";
		Customers os = new Customers();
		
		try {
			PreparedStatement stat = con.prepareStatement(sql);
			stat.setInt(1, ide);
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				
			os.setId(rs.getInt("id"));
			os.setCity(rs.getString("city"));
			os.setCompany(rs.getString("company"));
			os.setCountry_region(rs.getString("country_region"));
			os.setFirst_name(rs.getString("first_name"));
			os.setLast_name(rs.getString("last_name"));
			os.setMobile_phone(rs.getString("mobile_phone"));
			os.setState_province(rs.getString("state_province"));
			os.setZip_postal_code(rs.getString("zip_postal_code"));
			}
			
			rs.close();
			stat.close();
			
			System.out.println("| Id: " + os.getId() + "| City: " + os.getCity() + "| Company: " + os.getCompany() + "| Country: " + os.getCountry_region() + "| FirstN: " + os.getFirst_name() + "| LastN: " + os.getLast_name() + "| Mobile: " + os.getMobile_phone() + "| State: " + os.getState_province() + "| Zip: " + os.getZip_postal_code());
			

		}catch(SQLException e){
			e.getMessage();
		}
	}
	
	public  void recuperar_clientes_like(String search) {
		String sql = "select * from customers where first_name like ?";
		List<Customers> lista = new ArrayList<Customers>();
		
		try {
			PreparedStatement stat = con.prepareStatement(sql);
			stat.setString(1, '%' + search + '%');
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				
				Customers os = new Customers();
				os.setId(rs.getInt("id"));
				os.setCity(rs.getString("city"));
				os.setCompany(rs.getString("company"));
				os.setCountry_region(rs.getString("country_region"));
				os.setFirst_name(rs.getString("first_name"));
				os.setLast_name(rs.getString("last_name"));
				os.setMobile_phone(rs.getString("mobile_phone"));
				os.setState_province(rs.getString("state_province"));
				os.setZip_postal_code(rs.getString("zip_postal_code"));
				
				lista.add(os);	
			}
			
			rs.close();
			stat.close();
			
			for(Customers customer : lista) {
				System.out.println("| Id: " + customer.getId() + "| City: " + customer.getCity() + "| Company: " + customer.getCompany() + "| Country: " + customer.getCountry_region() + "| FirstN: " + customer.getFirst_name() + "| LastN: " + customer.getLast_name() + "| Mobile: " + customer.getMobile_phone() + "| State: " + customer.getState_province() + "| Zip: " + customer.getZip_postal_code());
			}
			
		}catch(SQLException e){
			e.getMessage();
		}
		
	}
}
