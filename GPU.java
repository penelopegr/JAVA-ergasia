public class GPU extends Hardware {
    String chipset;
    int memory;
    int stock;

    // Constructor
    public GPU(String model, String model_year, String manufacturer, Double price, String chipset, int memory,
            int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.chipset = chipset;
        this.memory = memory;
        this.stock = stock;
    }

    // toString method
    public String toString() {
        return "\n-------------------------------------------------" + "\nGraphics Card details :" + super.toString()
                + "\nDiscount rate: " + discRate + "\nFinal Price: " + getFinalPrice() + " $" + "\nChipset: " + chipset
                + "\nMemory: " + memory + " GB" + "\nStock: " + stock;
    }
}
