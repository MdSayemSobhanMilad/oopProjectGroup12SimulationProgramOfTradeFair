package cse213.todayjava.Rahat.UserVisitor;

public class Searchproduct {
    private String name;
    private int price;
    private String stockStatus;

    public Searchproduct(String name, int price, String stockStatus) {
        this.name = name;
        this.price = price;
        this.stockStatus = stockStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    @Override
    public String toString() {
        return "Searchproduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stockStatus='" + stockStatus + '\'' +
                '}';
    }
}

