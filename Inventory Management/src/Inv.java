import java.util.ArrayList;

public class Inv {

    private ArrayList<Product> productData;

    public Inv() {

        productData = new ArrayList<Product>();

        startingProducts();
    }

    private void startingProducts() {

        try {

            Product mobile = new Electronics(101, "Pixel 8 Pro", "Google", "Alpha Distributs", 959.0, 45, 0.2);
            Product laptop = new Electronics(102, "MacBook Air", "Apple", "BETA Distributs", 1099.0, 25, 1.2);
            Product shirt = new Clothing(201, "Hoodie", "Adidas", "G.Garments", 65.0, 80, 0.3);
            Product chair = new Furniture(301, "Gaming Chair", "Secretlab", "Cseat", 450.0, 15, 22.0);
            Product javaBook = new Book(401, "Python Course", "Maryam Publishers", "P_Turner", 35.0, 150, 0.8);



            addProduct(mobile);
            addProduct(laptop);
            addProduct(shirt);
            addProduct(chair);
            addProduct(javaBook);

        } catch (InvException e) {

            System.out.println(e.getMessage());
        }
    }
        public void addProduct(int id, String name, String brand, String supplier, double price, int stock, double weight, String type) 
        {
        }
    public void addProduct(Product newItem)
            throws InvException {

        Product found = searchProduct(
                newItem.getId());

        if (found != null) {

            throw new InvException(
                    "Duplicate Product ID"
            );
        }

        productData.add(newItem);
    }

    public Product searchProduct(int id) {

        for (Product p : productData) {

            if (p.getId() == id) {

                return p;
            }
        }

        return null;
    }

    public ArrayList<Product> searchProduct(
            String name) {

        ArrayList<Product> matchedProducts =
                new ArrayList<Product>();

        for (Product p : productData) {

            if (p.getName()
                    .equalsIgnoreCase(name)) {

                matchedProducts.add(p);
            }
        }

        return matchedProducts;
    }

    public void deleteProduct(int id)
            throws InvException {

        Product p = searchProduct(id);

        if (p == null) {

            throw new InvException(
                    "Product not found"
            );
        }

        productData.remove(p);
    }

    public void updateProduct(
            int id,
            String name,
            String brand,
            String supplier,
            double price,
            int stock,
            double weight
    ) throws InvException {

        Product item = searchProduct(id);

        if (item == null) {

            throw new InvException(
                    "Product not found"
            );
        }

        item.setName(name);
        item.setBrand(brand);
        item.setSupplierName(supplier);
        item.setPrice(price);
        item.setStock(stock);
        item.setWeight(weight);
    }

    public void sortProductsByPrice() {

        for (int i = 0;
             i < productData.size();
             i++) {

            for (int j = i + 1;
                 j < productData.size();
                 j++) {

                Product first =
                        productData.get(i);

                Product second =
                        productData.get(j);

                if (first.getPrice()
                        > second.getPrice()) {

                    productData.set(i, second);
                    productData.set(j, first);
                }
            }
        }
    }

    public void sortProductsByName() {

        for (int i = 0;
             i < productData.size();
             i++) {

            for (int j = i + 1;
                 j < productData.size();
                 j++) {

                Product first =
                        productData.get(i);

                Product second =
                        productData.get(j);

                if (first.getName()
                        .compareToIgnoreCase(
                                second.getName()) > 0) {

                    productData.set(i, second);
                    productData.set(j, first);
                }
            }
        }
    }

    public Product getCheapestProduct() {

        if (productData.size() == 0) {

            return null;
        }

        Product cheap =
                productData.get(0);

        for (Product p : productData) {

            if (p.getPrice()
                    < cheap.getPrice()) {

                cheap = p;
            }
        }

        return cheap;
    }

    public Product getMostExpensiveProduct() {

        if (productData.size() == 0) {

            return null;
        }

        Product expensive =
                productData.get(0);

        for (Product p : productData) {

            if (p.getPrice()
                    > expensive.getPrice()) {

                expensive = p;
            }
        }

        return expensive;
    }

    public int getTotalStockCount() {

        int total = 0;

        for (Product p : productData) {

            total += p.getStock();
        }

        return total;
    }

    public ArrayList<Product> getAllProducts() {

        return productData;
    }
}
