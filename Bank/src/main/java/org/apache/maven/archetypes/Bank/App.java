package org.apache.maven.archetypes.Bank;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
            new ClassPathXmlApplicationContext("beans.xml");

        CustomerService service = (CustomerService) context.getBean("customerService");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add 2.Deposit 3.Withdraw 4.Transfer 5.ShowAll 6.Enquire 7.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: Name, AccNo, Balance: ");
                    Customer c = new Customer(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
                    service.addCustomer(c);
                    break;

                case 2:
                    System.out.print("Enter ID & Amount: ");
                    service.deposit(sc.nextInt(), sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter ID & Amount: ");
                    service.withdraw(sc.nextInt(), sc.nextDouble());
                    break;

                case 4:
                    System.out.print("FromID - ToID Amount: ");
                    service.transfer(sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;

                case 5:
                    service.showAll();
                    break;

                case 6:
                    System.out.print("Enter ID: ");
                    service.enquire(sc.nextInt());
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}