package CryptoApp.cryptoApp.repository;

import CryptoApp.cryptoApp.entity.Coin;
import org.springframework.jdbc.core.JdbcTemplate;

public class CoinRepository {

    private  static String INSERT = "insert into coin(name, price, quantity, datetime) valeus (?, ?, ?, ?, ?"

    private JdbcTemplate jdbcTemplate;

    public CoinRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Coin insert(Coin coin) {

        Object[] atrr = new Object[] {
                coin.getName(),
                coin.getPrice(),
                coin.getQuantity(),
                coin.getDa
        }
        jdbcTemplate.update(sql:"")
    }
}
