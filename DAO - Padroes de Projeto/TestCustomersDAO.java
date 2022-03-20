//Author: Gabriel Jose da Silva dos Santos
//Author: Ranniery Lucas de Carvalho Moreira

package main_package;

import java.sql.Connection;
import java.sql.SQLException;

public class TestCustomersDAO {
	
	public static void main(String[] args) throws SQLException {
	
	Customers c = new Customers();
	
	//Para a insercao, os dados devem ser informados abaixo:
	c.setCompany("AAAAAAAAA1");
	c.setLast_name("AAAAAAAAA2");
	c.setFirst_name("AAAAAAAAA3");
	c.setMobile_phone("AAAAAAAAA4");
	c.setCity("AAAAAAAAA5");
	c.setState_province("AAAAAAAAA6");
	c.setZip_postal_code("AAAAAAAAA7");
	c.setCountry_region("AAAAAAAAA8");
	
	CustomersDAO cdao = new CustomersDAO();
	//cdao.inserir(c);
	//cdao.recuperar_clientes();
	//cdao.recupera_cliente_por_id(1);
	cdao.recuperar_clientes_like("Ann");
	
	}

}
