//Author: Gabriel Jose da Silva dos Santos
//Author: Ranniery Lucas de Carvalho Moreira

package main_package;

import java.util.Scanner;

public class Menu {

	public static int opt;
	
	public static void start() {
		do {
			System.out.println("\n\n  - - DATA ACESS OBJECT\n BY: Gabriel Jose & Ranniery - - \n");
			System.out.println("1 - Inserir um novo Cliente\n");
			System.out.println("2 - Listar clientes cadastrados\n");
			System.out.println("3 - Listar os dados de um determinando cliente\n");
			System.out.println("4 - Atualizar os dados de um cliente\n");
			System.out.println("5 - Remover um cliente do BD\n");
			System.out.println("0 - Sair\n");
			System.out.println("Escolha a opcao: ");
			Scanner sc = new Scanner(System.in);
			opt = sc.nextInt();
			
			opcoes(opt);
			
		}while(opt != 0);
	}
	
	public static void opcoes(int opt) {
		CustomersDAO cdao = new CustomersDAO();
		switch(opt) {
		case 1:
			
			Scanner sc2 = new Scanner(System.in);
			Customers c = new Customers();
			
			System.out.println("| - Insira os dados do cliente -  |\n");
			System.out.println("Empresa:\n");
			c.setCompany(sc2.nextLine());
			
			System.out.println("Nome do cliente:\n");
			c.setFirst_name(sc2.nextLine());
			
			System.out.println("Sobrenome do sobrenome:\n");
			c.setLast_name(sc2.nextLine());
			
			System.out.println("Numero de telefone:\n");
			c.setMobile_phone(sc2.nextLine());
			
			System.out.println("Cidade:\n");
			c.setCity(sc2.nextLine());
			
			System.out.println("Estado:\n");
			c.setState_province(sc2.nextLine());
			
			System.out.println("CEP:\n");
			c.setZip_postal_code(sc2.nextLine());
			
			System.out.println("Pais:\n");
			c.setCountry_region(sc2.nextLine());
			
			cdao.inserir(c);
			break;
		
		case 2:
			System.out.println("Case 2");
			cdao.recuperar_clientes();
			break;
		
		case 3:
			int ide;
			System.out.println("\nInsira o id do cliente que deseja pesquisar:");
			Scanner sc3 = new Scanner(System.in);
			ide = sc3.nextInt();
			cdao.recupera_cliente_por_id(ide);
			break;
		
		case 4:
			Customers cd = new Customers();
			Scanner sc4 = new Scanner(System.in);
			System.out.println("Insira o id do usuario que deseja atualizar: ");
			cd.setId(Integer.parseInt(sc4.nextLine()));
			
			System.out.println("\n| - Insira os dados do cliente -  |\n");
			System.out.println("Empresa:\n");
			cd.setCompany(sc4.nextLine());
			
			System.out.println("Nome do cliente:\n");
			cd.setFirst_name(sc4.nextLine());
			
			System.out.println("Sobrenome do sobrenome:\n");
			cd.setLast_name(sc4.nextLine());
			
			System.out.println("Numero de telefone:\n");
			cd.setMobile_phone(sc4.nextLine());
			
			System.out.println("Cidade:\n");
			cd.setCity(sc4.nextLine());
			
			System.out.println("Estado:\n");
			cd.setState_province(sc4.nextLine());
			
			System.out.println("CEP:\n");
			cd.setZip_postal_code(sc4.nextLine());
			
			System.out.println("Pais:\n");
			cd.setCountry_region(sc4.nextLine());
			
			cdao.edit(cd);
			
			break;
		
		case 5:
			int id_del;
			System.out.println("\nInsira o id do cliente que deseja deletar:");
			Scanner sc5 = new Scanner(System.in);
			id_del = sc5.nextInt();
			cdao.delete(id_del);
			break;
		
		case 0:
			System.out.println("\nTchauu");
			break;
			
		default:
			System.out.println("OPCAO INVALIDA");
		}
	}
}
