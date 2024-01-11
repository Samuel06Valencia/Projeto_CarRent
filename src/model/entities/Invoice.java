package model.entities;

public class Invoice {
	private Double basicPayment;
	private Double tax;
	
	
	public Invoice() {
		super();
	}
	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}
	public Double getBasicPayment() {
		return basicPayment;
	}
	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public Double getTotalPayment() {
		return getBasicPayment() + getTax(); //Por quê estou usando os get's, e não os atributos?Porque pode ser que no futuro alguma regra de calcular imposto seja diferente.
	}
}
