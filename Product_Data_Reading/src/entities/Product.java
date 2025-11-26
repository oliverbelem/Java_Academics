package entities;


public class Product {
	
	public String Name;
	public double Price;
	public int Quantity;
	
	
	public Double TotalValueStock() {
		return this.Price * this.Quantity;
	}
	
	public void AddProducts(int add_quant) {
		this.Quantity += add_quant;
	}
	
	public void RemoveProducts(int rm_quant) {
		this.Quantity -= rm_quant;
	}
	
	public String toString() {
		return this.Name +
				", R$" +
				String.format("%.2f", this.Price) +
				", " +
				this.Quantity +
				" und. Total Value: R$" +
				String.format("%.2f", this.TotalValueStock());
	}
}