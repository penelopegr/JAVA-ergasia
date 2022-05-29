import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDate;

//import javax.lang.model.util.ElementScanner14;

public class mainApp {
    public static void main(String args[]) {
        Lists myLists = new Lists();
        Sales mySales = new Sales();
        Orders myOrders = new Orders();

        Scanner sc = new Scanner(System.in);
        boolean done = false, done2 = false, done3 = false;
        String choice0, choice1, choice2, choice3;
        int nItems = 0;

        myLists.storeProduct(new Motherboard("asus motherboard Intel", "2017", "asus", 400.0, "Intel", 64, 6, 5));
        myLists.storeProduct(new Motherboard("asus motherboard AMD", "2021", "asus", 400.0, "AMD", 128, 8, 4));
        myLists.storeProduct(new CPU("intel core 8", "2020", "intel", 600.0, 2.8, 8, "Yes", 0));
        myLists.storeProduct(new CPU("intel core i7", "2019", "intel", 400.0, 3.3, 16, "No", 7));
        myLists.storeProduct(new RAM("Corsair Vengeance RGB pro", "2020", "Corsair", 100.0, "DDR4", 8, 1600, 0));
        myLists.storeProduct(new RAM("G.skill Ripjaws V 16GB", "2022", "G.skill", 200.0, "DDR5", 16, 3200, 2));
        myLists.storeProduct(new GPU("GigaByte Geforce GTX", "2019", "GigaByte", 700.0, "AMD", 8, 10));
        myLists.storeProduct(new GPU("GigaByte Geforce RTX", "2018", "GigaByte", 650.0, "nVidia", 16, 0));
        myLists.storeProduct(
                new HardDrive("Western Digital Blue 512 GB ", "2017", "Western Digital", 50.0, "SSD", 2.5, 512, 0));
        myLists.storeProduct(
                new HardDrive("Western Digital Blue 1TB", "2019", "Western Digital", 80.0, "SSD", 3.5, 1, 8));
        myLists.storeProduct(
                new Monitor("Samsung Monitor", "2021", "Samsung", 400.0, "Portable Monitor", 34, "1024*1024",
                        "Display Port", 0));
        myLists.storeProduct(
                new Monitor("Dell Monitor Allienware", "2018", "Dell", 250.0, "Monitor", 28, "1024*1024", "HDMI", 5));
        myLists.storeProduct(new Keyboard("Razer ornata chroma", "2022", "Razer", 100.0, "Wireless", 6));
        myLists.storeProduct(new Keyboard("Logitech G915 TKL", "2020", "Logitech", 80.0, "Wired", 1));
        myLists.storeProduct(new Mouse("Razer Deathadder Elite", "2021", "Razer", 60.0, "Laser", "Wireless", 5));
        myLists.storeProduct(new Mouse("Glorious PC Gaming mouse", "2017", "Glorious", 50.0, "Optical", "Wired", 10));
        myLists.storeProduct(new Printer("HP DeskJet 2721e", "2015", "HP", 40.0, "Laser", "Colour", 15));
        myLists.storeProduct(new Printer("Xerox B230V/DNI", "2019", "Xerox", 30.0, "Inkjet", "Colour", 0));

        while (!done) {
            System.out.println("\n1. Overview Available Products");
            System.out.println("2. Overview Orders");
            System.out.println("3. Overview Sales");
            System.out.println("4. Exit\n");
            choice0 = sc.nextLine();

            done2 = false;
            while (!done2) {

                // CHOICE = 1; Overview Available Products ----->
                if (choice0.equals("1")) {
                    System.out.println("\nChoose a category: 1. Hardware / 2. Peripherals / 3. Back");
                    choice1 = sc.nextLine();
                    if (Integer.parseInt(choice1) == 3)
                        break; // fallback to main menu

                    done3 = false;
                    while (!done3) {
                        // SUBMENU1 = HARDWARE
                        if (choice1.equals("1")) {
                            System.out.println(
                                    "\nChoose product type: 1. CPU / 2. GPU / 3. Hard Disk Drive / 4. Motherboard / 5. RAM / 6. Back");
                            choice2 = sc.nextLine();
                            if (choice2.equals("1")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listCPUs();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product cpu = myLists.listCPU(nChoice);
                                        if (cpu.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Integer.parseInt(sc.nextLine());
                                                mySales.addSale(sale);
                                                cpu.ReduceStock();
                                                System.out.println("\nSales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Integer.parseInt(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    DateTimeFormatter myFormat = DateTimeFormatter
                                                            .ofPattern("dd-MM-yyyy");
                                                    LocalDate customer_date = LocalDate.parse(order.del_date, myFormat);

                                                    if (order.ordr_date.isBefore(customer_date) == false) {
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = cpu;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }
                            } else if (choice2.equals("2")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listGPUs();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product gpu = myLists.listGPU(nChoice);
                                        if (gpu.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Integer.parseInt(sc.nextLine());
                                                mySales.addSale(sale);
                                                gpu.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Integer.parseInt(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    DateTimeFormatter myFormat = DateTimeFormatter
                                                            .ofPattern("dd-MM-yyyy");
                                                    LocalDate customer_date = LocalDate.parse(order.del_date, myFormat);

                                                    if (order.ordr_date.isBefore(customer_date) == false) {
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = gpu;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }
                            } else if (choice2.equals("3")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listHDDs();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product hdd = myLists.listHDD(nChoice);
                                        if (hdd.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Integer.parseInt(sc.nextLine());
                                                mySales.addSale(sale);
                                                hdd.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Integer.parseInt(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    DateTimeFormatter myFormat = DateTimeFormatter
                                                            .ofPattern("dd-MM-yyyy");
                                                    LocalDate customer_date = LocalDate.parse(order.del_date, myFormat);

                                                    if (order.ordr_date.isBefore(customer_date) == false) {
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = hdd;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }

                            } else if (choice2.equals("4")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listMotherboards();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product motherboard = myLists.listMotherboard(nChoice);
                                        if (motherboard.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Integer.parseInt(sc.nextLine());
                                                mySales.addSale(sale);
                                                motherboard.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Integer.parseInt(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    DateTimeFormatter myFormat = DateTimeFormatter
                                                            .ofPattern("dd-MM-yyyy");
                                                    LocalDate customer_date = LocalDate.parse(order.del_date, myFormat);

                                                    if (order.ordr_date.isBefore(customer_date) == false) {
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = motherboard;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }
                            } else if (choice2.equals("5")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listRAMs();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product ram = myLists.listRAM(nChoice);
                                        if (ram.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Integer.parseInt(sc.nextLine());
                                                mySales.addSale(sale);
                                                ram.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Integer.parseInt(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    DateTimeFormatter myFormat = DateTimeFormatter
                                                            .ofPattern("dd-MM-yyyy");
                                                    LocalDate customer_date = LocalDate.parse(order.del_date, myFormat);

                                                    if (order.ordr_date.isBefore(customer_date) == false) {
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = ram;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }
                            } else
                                break;

                        } else if (choice1.equals("2")) {
                            System.out.println(
                                    "\nChoose product type: 1. Printer / 2. Keyboard / 3. Monitor / 4. Mouse / 5. Back");
                            choice2 = sc.nextLine();
                            if (choice2.equals("1")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listPrinters();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product printer = myLists.listPrinter(nChoice);
                                        if (printer.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Integer.parseInt(sc.nextLine());
                                                mySales.addSale(sale);
                                                printer.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Integer.parseInt(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    DateTimeFormatter myFormat = DateTimeFormatter
                                                            .ofPattern("dd-MM-yyyy");
                                                    LocalDate customer_date = LocalDate.parse(order.del_date, myFormat);

                                                    if (order.ordr_date.isBefore(customer_date) == false) {
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = printer;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }
                            } else if (choice2.equals("2")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listKeyboards();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product keyboard = myLists.listKeyboard(nChoice);
                                        if (keyboard.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Integer.parseInt(sc.nextLine());
                                                mySales.addSale(sale);
                                                keyboard.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Integer.parseInt(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    DateTimeFormatter myFormat = DateTimeFormatter
                                                            .ofPattern("dd-MM-yyyy");
                                                    LocalDate customer_date = LocalDate.parse(order.del_date, myFormat);

                                                    if (order.ordr_date.isBefore(customer_date) == false) {
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = keyboard;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }

                            } else if (choice2.equals("3")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listMonitors();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product monitor = myLists.listMonitor(nChoice);
                                        if (monitor.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Integer.parseInt(sc.nextLine());
                                                mySales.addSale(sale);
                                                monitor.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Integer.parseInt(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    DateTimeFormatter myFormat = DateTimeFormatter
                                                            .ofPattern("dd-MM-yyyy");
                                                    LocalDate customer_date = LocalDate.parse(order.del_date, myFormat);

                                                    if (order.ordr_date.isBefore(customer_date) == false) {
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = monitor;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }

                            } else if (choice2.equals("4")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listMousee();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product mouse = myLists.listMouse(nChoice);
                                        if (mouse.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Integer.parseInt(sc.nextLine());
                                                mySales.addSale(sale);
                                                mouse.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Integer.parseInt(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    DateTimeFormatter myFormat = DateTimeFormatter
                                                            .ofPattern("dd-MM-yyyy");
                                                    LocalDate customer_date = LocalDate.parse(order.del_date, myFormat);

                                                    if (order.ordr_date.isBefore(customer_date) == false) {
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }
                                                order.ordproduct = mouse;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }
                                        done3 = true;
                                        done2 = true;
                                    }
                                }
                            } else
                                break;
                        }
                    }

                } else if (choice0.equals("2")) {
                    if (myOrders.ShowOrders() > 0) {
                        System.out.print("\nChoose order:");
                        int num_order = Integer.parseInt(sc.nextLine());
                        Order o = myOrders.listOrders(num_order);
                        System.out.println(o.toString());
                        System.out.println("\n Do you want to complete the order?(Y\\N)");
                        String choice5 = sc.nextLine();
                        if (choice5.equals("Y") || choice5.equals("y")) {
                            Sale s = new Sale();
                            s.cus_name = o.cus_name;
                            s.cus_phone = o.cus_phone;
                            s.sale_date = o.del_date;
                            s.finalprice = o.finalprice;
                            mySales.addSale(s);
                            myOrders.RemoveOrder(o);
                        }
                    } else
                        System.out.println("\nThere are no orders");
                    done2 = true;
                } else if (choice0.equals("3")) {
                    if (mySales.ShowSales() > 0) {
                        System.out.println("\nChoose sale:");
                        mySales.ShowSales();
                        int num_sale = Integer.parseInt(sc.nextLine());
                        Sale s = mySales.listSales(num_sale);
                        System.out.println(s.toString());
                    } else
                        System.out.println("\nThere are no sales");
                    done2 = true;
                } else if (choice0.equals("4")) {
                    done = true;
                    break;
                }
            }
        }
        sc.close();
    }
}
