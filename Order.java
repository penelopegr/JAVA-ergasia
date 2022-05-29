import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order {
    int orderID = 0;
    String cus_name; // customer name
    int cus_phone; // customer phone
    String del_status; // delivery status
    double finalprice;
    LocalDate ordr_date = LocalDate.now(); // order date
    DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String order_date = ordr_date.format(myFormat);
    String del_date; // delivery date
    Product ordproduct;

    public Order() {
        this.orderID = 0;
        this.cus_name = "";
        this.cus_phone = 0;
        this.order_date = "";
        this.finalprice = 0;
        this.del_date = "";
        ordr_date = LocalDate.now(); // sale date
        order_date = ordr_date.format(myFormat);
    }

    public Order(Product ordproduct, int orderID, String cus_name, int cus_phone, String order_date, String del_date,
            String del_status, double finalprice) {
        this.orderID = orderID;
        this.cus_name = cus_name;
        this.cus_phone = cus_phone;
        this.order_date = order_date;
        this.finalprice = ordproduct.getFinalPrice();
        this.del_date = del_date;
    }

    public void SetOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int GetOrderID() {
        return this.orderID;
    }

    // toString method
    public String toString() {
        return "\n--------------------------" + "\nOrder ID: " + orderID + "\nCustomer name: "
                + cus_name + "\nCustomer phone: " + cus_phone
                + "\nOrder date: " + order_date + "\nDelivery date: " + del_date;
    }
    // !!!!! product details +++++
}
