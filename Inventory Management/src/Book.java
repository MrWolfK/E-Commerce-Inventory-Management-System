public class Book extends Product {
 
 public Book(int id, String name, String brand, String supplier, double price, int stock, double weight) {
 super(id, name, brand, supplier, price, stock, weight);
 }

 @Override
 public double calculateDiscountPrice() {
 double discountAmount = this.getPrice() * 0.15;
 double finalPrice = this.getPrice() - discountAmount;
 return finalPrice;
 }
 
 @Override
 public double calculateTax() {
 return 0.0;
 }

 @Override
 public String getProductType() {
 return "Book";
 }
}