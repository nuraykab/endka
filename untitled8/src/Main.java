import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayProduct() {
        System.out.println("Product: " + name + " | Price: $" + price);
    }
}

interface ProductCatalog {
    void addProduct(Product product);
    void displayCatalog();
}

class WeeklyProductCatalog implements ProductCatalog {
    private List<Product> products;

    public WeeklyProductCatalog() {
        this.products = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void displayCatalog() {
        for (Product product : products) {
            product.displayProduct();
        }
    }
}

interface ShopperActions {
    void viewCatalog(ProductCatalog catalog);
}

class Shopper implements ShopperActions {
    private String name;

    public Shopper(String name) {
        this.name = name;
    }

    @Override
    public void viewCatalog(ProductCatalog catalog) {
        System.out.println("Shopper: " + name + " is viewing the catalog:");
        catalog.displayCatalog();
    }
}

class UndergraduateShopper extends Shopper {
    private String department;

    public UndergraduateShopper(String name, String department) {
        super(name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

public class Main {
    public static void main(String[] args) {
        ProductCatalog weeklyCatalog = new WeeklyProductCatalog();

        Product laptop = new Product("Laptop", 1200.00);
        Product headphones = new Product("Headphones", 150.00);

        weeklyCatalog.addProduct(laptop);
        weeklyCatalog.addProduct(headphones);

        Shopper shopper = new Shopper("Nuray Kab");
        shopper.viewCatalog(weeklyCatalog);

        UndergraduateShopper undergradShopper = new UndergraduateShopper("Adema", "Computer Science");
        undergradShopper.viewCatalog(weeklyCatalog);
    }
}
