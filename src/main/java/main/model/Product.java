package main.model;

public class Product {
    private String name;
    private double price;
    private String category;
    private String imagePath;
    private String description;

    public Product(String name, double price, String category, String imagePath, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.imagePath = imagePath;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
