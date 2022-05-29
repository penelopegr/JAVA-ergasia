import java.util.*;

public class Orders {

    int orderID = 0;

    // sales list
    public ArrayList<Order> orders = new ArrayList<Order>();

    void addOrder(Order o) {
        orderID += 1;
        o.SetOrderID(orderID);
        orders.add(o);
    }

    int ShowOrders() {
        int i = 0;
        for (Order o : orders) {
            i += 1;
            if (i == 1)
                System.out.println("\nOrder with Id = " + o.orderID);
            else
                System.out.println("Order with Id = " + o.orderID);

        }
        return i;
    }

    void RemoveOrder(Order o) {
        orders.remove(o);
    }

    Order listOrders(int n) {
        int i = 0;
        for (Order o : orders) {
            i += 1;
            if (i == n) {
                return o;
            }
        }
        return null;
    }
}
