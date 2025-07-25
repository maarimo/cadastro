package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.ItemOrder;
import entities.Product;
import services.Order;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Client> clients = new ArrayList<>();
		List<Product> products = new ArrayList<>();
		List<Order> orders = new ArrayList<>();
		
		int option;
		
		do {
			System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Produto");
            System.out.println("3 - Criar Pedido");
            System.out.println("4 - Listar Pedidos");
            System.out.println("0 - Sair");
            
            System.out.print("Escolha uma opção: ");
            option = sc.nextInt();
            sc.nextLine();
            
            switch(option) {
            case 1:
            	System.out.print("ID do Cliente: ");
            	int idClient = sc.nextInt();
            	sc.nextLine();
            	System.out.print("Nome do Cliente: ");
            	String nameClient = sc.nextLine();
            	System.out.print("Email do Cliente: ");
            	String emailClient = sc.nextLine();
            	
            	clients.add(new Client(idClient, nameClient, emailClient));
            	System.out.println("================================");
            	System.out.println("Cliente cadastrado com sucesso!!");
              	System.out.println("================================");
            	break;
            	
            case 2:
            	System.out.print("ID do Produto: ");
            	int idProduct = sc.nextInt();
            	sc.nextLine();
            	System.out.print("Nome do Produto: ");
            	String nameProduct = sc.nextLine();
            	System.out.print("Preço do Produto: ");
            	double priceProduct = sc.nextDouble();
            	
            	products.add(new Product(idProduct, nameProduct, priceProduct));
            	System.out.println("================================");
            	System.out.println("Produto cadastrado com sucesso!!");
              	System.out.println("================================");
            	break;
            	
            case 3:
            	System.out.print("ID do pedido: ");
            	int idOrder = sc.nextInt();
            	sc.nextLine();
            	System.out.print("ID do client: ");
            	int idClientOrder = sc.nextInt();
            	sc.nextLine();
            	
            	Client client = null;
            	for(Client c : clients) {
            		if(c.getId() == idClientOrder) {
            			client = c;
            			break;
            		}
            	}
            	if(client == null) {
            		System.out.println("================================");
                	System.out.println("    Cliente não encontrado!!");
                  	System.out.println("================================");
                	break;
            	}
            	
            	Order order = new Order(idOrder, client);
            	
            	String keep;
            	do {
            		System.out.print("ID do produto: ");
            		int idProd = sc.nextInt();
            		sc.nextLine();
            		Product product = null;
            		for(Product p : products) {
            			if(p.getId() == idProd) {
            				product = p;
            				break;
            			}
            		}
            			if(product == null) {
            				System.out.println("================================");
                        	System.out.println("    Produto não encontrado!!");
                          	System.out.println("================================");
            			} else {
            				System.out.print("Quantidade: ");
            				int quantityProduct = sc.nextInt();
            				order.addItem(new ItemOrder(product, quantityProduct));
            			}
            		        		
            		
            		System.out.print("Adicionar outro item? (s/n): ");
                    keep = sc.next();
            	} while(keep.equalsIgnoreCase("s"));
            	
            	orders.add(order);
            	System.out.println("================================");
            	System.out.println("   Pedido criado com sucesso!!");
              	System.out.println("================================");
            	break;
            	
            case 4:
                for (Order p : orders) {
                    System.out.println("\n----------------------");
                    System.out.println(p);
                }
                break;

            case 0:
                System.out.println("Saindo...");
                break;

            default:
                System.out.println("Opção inválida!");
            }
            
		} while(option != 0);

	}

}
