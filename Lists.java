import java.util.*;

public class Lists {
    // available products list
    public ArrayList<Product> products = new ArrayList<Product>();
    Scanner sc = new Scanner(System.in);

    void storeProduct(Product p) {
        products.add(p);
    }

    void listProducts() {
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }

    int listMotherboards() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Motherboard) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listMotherboard(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Motherboard) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listCPUs() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof CPU) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listCPU(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof CPU) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listGPUs() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof GPU) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listGPU(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof GPU) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listHDDs() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof HardDrive) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listHDD(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof HardDrive) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listKeyboards() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Keyboard) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listKeyboard(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Keyboard) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listMonitors() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Monitor) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listMonitor(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Monitor) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listMousee() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Mouse) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listMouse(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Mouse) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listPrinters() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Printer) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listPrinter(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Printer) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listRAMs() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof RAM) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listRAM(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof RAM) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    Product GetProduct(String model) {
        for (Product p : products) {
            if (p.GetModel() == model) {
                return p;
            }
        }
        return null;
    }
}
