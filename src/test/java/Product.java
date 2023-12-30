public class Product {
    private String name;
    private String price;
    private int count = 0;
    public Product(String name, String price) {
        this.name = name;
        this.price = price;
        this.count++;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
