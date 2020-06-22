package club.banyuan.Book;

public class Book {

    private String title;
    private double price;
    private double cost;
    private int pages;

    public Book(String title, double price, double cost, int pages) {
        this.title = title;
        this.price = price;
        this.cost = cost;
        this.pages = pages;
    }

    public double profit() {
        return price - cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
