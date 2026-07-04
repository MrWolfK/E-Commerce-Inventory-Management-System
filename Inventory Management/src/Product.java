public abstract class Product {
	 private int id;
	 private String name;
	 private String brand;
	 private String supplierName;
	 private double price;
	 private int stock;
	 private double weight;
	 
	 public Product() {
	 this.id = 0;
	 this.name = "Unknown";
	 this.brand = "Unknown";
	 this.supplierName = "Unknown";
	 this.price = 0.0;
	 this.stock = 0;
	 this.weight = 0.0;
	 }
	 
	 public Product(int id, String name, String brand, String supplierName, double price, int stock, double weight) {
	 this.id = id;
	 this.name = name;
	 this.brand = brand;
	 this.supplierName = supplierName;
	 this.price = price;
	 this.stock = stock;
	 this.weight = weight;
	 }
	 
	 public abstract double calculateDiscountPrice();
	 public abstract double calculateTax();
	 public abstract String getProductType();
	 
	 public void displayInfo() {
	 System.out.println("===========================");
	 System.out.println("Product ID: " + this.id);
	 System.out.println("Product Name: " + this.name);
	 System.out.println("Brand: " + this.brand);
	 System.out.println("Supplier: " + this.supplierName);
	 System.out.println("Base Price: $" + this.price);
	 System.out.println("Stock Qty: " + this.stock);
	 System.out.println("Weight: " + this.weight + " kg");
	 System.out.println("===========================");
	 }
	
	 public int getId() { 
	 return id; 
	 }
	 
	 public void setId(int id) { 
	 this.id = id; 
	 }
	 public String getName() { 
	 return name; 
	 }
	 
	 public void setName(String name) { 
	 this.name = name; 
	 }
	 public String getBrand() { 
	 return brand; 
	 }
	 
	 public void setBrand(String brand) { 
	 this.brand = brand; 
	 }
	 public String getSupplierName() {
	 return supplierName;
	 }
	 public void setSupplierName(String supplierName) {
	 this.supplierName = supplierName;
	 }
	 public double getPrice() { 
	 return price; 
	 }
	 
	 public void setPrice(double price) {
	 if (price >= 0) {
	 this.price = price;
	 } else {
	 System.out.println("Error: Price cannot be negative.");
	 }
	 }
	 public int getStock() { 
	 return stock; 
	 }
	 
	 public void setStock(int stock) {
	 if (stock >= 0) {
	 this.stock = stock;
	 } else {
	 System.out.println("Error: Stock cannot be negative.");
	 }
	 }
	 public double getWeight() { 
	 return weight; 
	 }
	 
	 public void setWeight(double weight) {
	 if (weight >= 0) {
	 this.weight = weight;
	 }
	 }
	}