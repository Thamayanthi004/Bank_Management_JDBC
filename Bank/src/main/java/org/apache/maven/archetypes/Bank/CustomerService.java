package org.apache.maven.archetypes.Bank;
public class CustomerService {

    private CustomerDAO dao;

    public void setDao(CustomerDAO dao) {
        this.dao = dao;
    }

    public void addCustomer(Customer c) {
        dao.addCustomer(c);
        System.out.println("Customer Added!");
    }

    public void deposit(int id, double amount) {
        Customer c = dao.getCustomer(id);
        dao.updateBalance(id, c.getBalance() + amount);
        System.out.println("Amount Deposited!");
    }

    public void withdraw(int id, double amount) {
        Customer c = dao.getCustomer(id);

        if (c.getBalance() >= amount) {
            dao.updateBalance(id, c.getBalance() - amount);
            System.out.println("Amount Withdrawn!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void transfer(int fromId, int toId, double amount) {
        withdraw(fromId, amount);
        deposit(toId, amount);
        System.out.println("Transfer Successful!");
    }

    public void showAll() {
        dao.getAllCustomers().forEach(c ->
            System.out.println(c.getId() + " " + c.getName() + " " + c.getBalance())
        );
    }

    public void enquire(int id) {
        Customer c = dao.getCustomer(id);
        System.out.println(c.getId() + " " + c.getName() + " " + c.getBalance());
    }
}