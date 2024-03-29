package model.entities;

import java.time.LocalDateTime;

public class CarRental {
	private LocalDateTime start;
	private LocalDateTime finish;
	//associações ou composição de objeto:
	private Vehicle vehicle; //Atributo do tipo Classe Veiculo
	private Invoice invoice; //Atributo do tipo Classe Fatura
	
	public CarRental() {}

	public CarRental(LocalDateTime start, LocalDateTime finish, Vehicle vehicle) {
		this.start = start;
		this.finish = finish;
		this.vehicle = vehicle;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getFinish() {
		return finish;
	}

	public void setFinish(LocalDateTime finish) {
		this.finish = finish;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	
	
	
}
