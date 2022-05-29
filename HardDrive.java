public class HardDrive extends Hardware {
    String type;
    Double size;
    int capacity;
    int stock;

    // Constructor
    public HardDrive(String model, String model_year, String manufacturer, Double price, String type, double size,
            int capacity,
            int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.type = type;
        this.size = size;
        this.capacity = capacity;
        this.stock = stock;
    }

    // toString method
    public String toString() {
        return "\n-------------------------------------------------" + "\nHard Disk Drive details :" + super.toString()
                + "\nDiscount rate: " + discRate + "\nFinal Price: " + getFinalPrice() + " $" + "\nType: " + type
                + "\nSize: " + size + " inches" + "\nCapacity: " + capacity + ((capacity < 3) ? " GB" : " TB")
                + "\nStock: " + stock;
    }
}
