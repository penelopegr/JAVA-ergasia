import java.util.*;

public class Sales {

    int saleID = 0;

    // sales list
    public ArrayList<Sale> sales = new ArrayList<Sale>();

    void addSale(Sale s) {
        saleID += 1;
        s.SetSalesID(saleID);
        sales.add(s);
    }

    int ShowSales() {
        int i = 0;
        for (Sale o : sales) {
            i += 1;
            if (i == 1)
                System.out.println("\nOrder with Id = " + o.saleID);
            else
                System.out.println("Order with Id = " + o.saleID);

        }
        return i;
    }

    Sale listSales(int n) {
        int i = 0;
        for (Sale s : sales) {
            i += 1;
            if (i == n) {
                return s;
            }
        }
        return null;
    }

}
