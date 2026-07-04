public class Clothing extends Product {
	 public Clothing(int id, String name, String brand, String supplier, double price, int stock, double weight) {
	 super(id, name, brand, supplier, price, stock, weight);
	 }
	 
	 @Override
	 public double calculateDiscountPrice() {
	 double discountAmount = this.getPrice() * 0.20;
	 double finalPrice = this.getPrice() - discountAmount;
	 return finalPrice;
	 }
	 
	 @Override
	 public double calculateTax() {
	 double taxAmount = this.getPrice() * 0.05;
	 return taxAmount;
	 }
	 @Override
	 public String getProductType() {
	 return "Clothing";
	 }
	}