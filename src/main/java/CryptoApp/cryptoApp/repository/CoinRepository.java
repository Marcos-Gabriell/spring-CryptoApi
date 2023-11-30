package CryptoApp.cryptoApp.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class CoinRepository {

    private JdbcTemplate jdbcTemplate;

    public CoinRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
