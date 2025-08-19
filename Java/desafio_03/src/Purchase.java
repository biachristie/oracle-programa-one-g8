public class Purchase implements Comparable<Purchase>{
    private String description;
    private double price;

    public Purchase(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("""
                Compra:
                   Descrição: %s
                   Valor: %.2f
                """, description, price);
    }

    @Override
    public int compareTo(Purchase outro) {
        return Double.valueOf(this.price).compareTo(Double.valueOf(outro.price));
    }
}
