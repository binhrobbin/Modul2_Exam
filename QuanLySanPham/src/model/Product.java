package model;

public class Product implements Comparable<Product>{
private int id;
private String nameProduct;
private double price;
private int quantity;
private String describer;

    public Product(int id, String nameProduct, double price, int quantity, String describer) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.describer = describer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriber() {
        return describer;
    }

    public void setDescriber(String describer) {
        this.describer = describer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", describer='" + describer + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        if (price<o.getPrice()) return 1;
        else if (price>o.getPrice()) return -1;
        else return 0;
    }
}
