public class Motherboard extends Hardware {
    String processor;
    int memory;
    int SATAports;
    int stock;

    // Constructor
    public Motherboard(String model, String model_year, String manufacturer, Double price, String processor, int memory,
            int SATAports, int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.processor = processor;
        this.memory = memory;
        this.SATAports = SATAports;
        this.stock = stock;
    }

    // toString method
    public String toString() {
        return "\n-------------------------------------------------" + "\nMotherboard details :" + super.toString()
                + "\nDiscount rate: " + discRate + "\nFinal Price: " + getFinalPrice() + " $" + "\nProcessor: "
                + processor + "\nMemory: " + memory + " GB" + "\nSATA ports: " + SATAports + "\nStock: " + stock;
    }
}
