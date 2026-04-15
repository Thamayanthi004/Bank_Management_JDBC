package org.apache.maven.archetypes.Bank;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addCustomer(Customer c) {
        jdbcTemplate.update("INSERT INTO customer VALUES (?, ?, ?, ?)",
                c.getId(), c.getName(), c.getAccountNumber(), c.getBalance());
    }

    public Customer getCustomer(int id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM customer WHERE id=?",
            (rs, rowNum) -> new Customer(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("account_number"),
                rs.getDouble("balance")
            ),
            id
        );
    }

    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query(
            "SELECT * FROM customer",
            (rs, rowNum) -> new Customer(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("account_number"),
                rs.getDouble("balance")
            )
        );
    }

    public void updateBalance(int id, double balance) {
        jdbcTemplate.update("UPDATE customer SET balance=? WHERE id=?", balance, id);
    }
}
