package CryptoApp.cryptoApp.repository;

import CryptoApp.cryptoApp.entity.Coin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CoinRepository {

    private static final Logger logger = LoggerFactory.getLogger(CoinRepository.class);

    private static final String INSERT = "INSERT INTO coin (name, price, quantity, datetime) VALUES (?, ?, ?, ?)";

    private final JdbcTemplate jdbcTemplate;

    public CoinRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Coin insert(Coin coin) {

            Object[] attr = new Object[] {
                    coin.getName(),
                    coin.getPrice(),
                    coin.getQuantity(),
                    coin.getDateTime()
            };
            jdbcTemplate.update(INSERT, attr);
            return coin;
    }
}
