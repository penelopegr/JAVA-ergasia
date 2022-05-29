abstract class Peripheral extends Product {
    double finalPrice;
    String discRate = "10%";

    // Constructor
    public Peripheral(String model, String model_year, String manufacturer, Double price, int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.finalPrice = price - 0.1 * price;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

}