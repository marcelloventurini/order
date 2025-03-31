import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Birth date (dd/mm/yyyy): ");
        Date birthDate = sdf.parse(scanner.next());
        scanner.nextLine();

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = scanner.nextLine();

        Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

        System.out.print("How many items will be registered? ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the data for the product #" + (i + 1));
            System.out.print("Name: ");
            String productName = scanner.nextLine();

            System.out.print("Price: ");
            double productPrice = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(quantity, product.getPrice(), product);
            order.addOrderItem(orderItem);
        }

        System.out.println("\nOrder summary:");
        System.out.println(order);

        scanner.close();
    }
}
