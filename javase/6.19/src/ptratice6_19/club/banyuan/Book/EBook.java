package ptratice6_19.club.banyuan.Book;

public class EBook extends Book {

    private double sizeMB;

    public EBook(String title, double price, double cost, int pages, double sizeMB) {
        super(title, price, cost, pages);
        this.sizeMB = sizeMB;
    }

    public double getSizeMB() {
        return sizeMB;
    }

    public void setSizeMB(double sizeMB) {
        this.sizeMB = sizeMB;
    }

    public static void main(String[] args) {
        EBook eBook = new EBook("Java编程思想", 199, 0, 200, 3.5);


    }
}
