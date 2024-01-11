package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;
//Objeto instanciado na memoria,baseado na classe Invoice com dados gravados de forma fixa.
public class RentalService {
	private Double pricePerHour;
	private Double pricePerDay;
	//assocação:
	private BrazilTaxService taxService;
	
	//Não coloquei o construtor vazio, pois quero orbigar ao usar o RentalService a instanciar esses atributos.
	public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}
	
	//Processa a fatura a partir de um CarRental,baseado no objeto invoice.
	public void processInvoice(CarRental carRental) {
		//Lógica para gerar fatura do CarRental dentro deste método.
		
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours = minutes / 60.0;
		
		double basicPayment;
		if(hours <= 12.0) {
			basicPayment = pricePerHour * Math.ceil(hours); // a função Math.ceil arredonda o valor para cima(ceil == teto);
		}
		else {
			basicPayment = pricePerDay * Math.ceil(hours / 24.0);
		}
		
		double tax = taxService.tax(basicPayment); //Imposto,acessado através da classe de serviço "taxService" com seu método "tax()".
		/*Pega na Classe CarRental o setInvoice da composição, 
		e instância dentro a Classe Invoice,
		com seus parâmtros basicPayment e Tax. */
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}
