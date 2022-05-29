abstract class Hardware extends Product {
    double finalPrice;
    double fdiscRate = .25;
    String discRate = "25%";

    // Constructor
    public Hardware(String model, String model_year, String manufacturer, Double price, int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.finalPrice = price * (1 - fdiscRate);
    }

    // Getter
    public double getFinalPrice() {
        return finalPrice;
    }
}
