class Keyboard extends Peripheral {
    String connection;
    int stock;

    // Constructor
    public Keyboard(String model, String model_year, String manufacturer, Double price, String connection, int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.connection = connection;
        this.stock = stock;
    }

    // toString method
    public String toString() {
        return "\n-------------------------------------------------" + "\nKeyboard details :" + super.toString()
                + "\nDiscount rate: " + discRate + "\nFinal Price: " + getFinalPrice() + " $" + "\nConnection: "
                + connection + "\nStock: " + stock;
    }
}
