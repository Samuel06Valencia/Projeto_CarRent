package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel");
		System.out.print("Modelo do carro: ");
		String model = sc.next();
		sc.nextLine(); //Esvazia o buffer.
		System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
		
		
		CarRental cr = new CarRental(start,finish, new Vehicle(model));
		
		System.out.print("Entre com o preço por hora: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Entre com o preço por dia: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService()); 
		rentalService.processInvoice(cr);
		
		System.out.println("Fatura:");
		System.out.println("Pagamento básico: "+String.format("%.2f",cr.getInvoice().getBasicPayment())); //Acessa a classe CarRental, depois através do get acessa a classe Invoice e por fim o seu atributo "basicPayment".
		System.out.println("Imposto: "+String.format("%.2f",cr.getInvoice().getTax()));
		System.out.println("Pagamento Total: "+String.format("%.2f",cr.getInvoice().getTotalPayment()));
		
		
		sc.close();
	}

}
