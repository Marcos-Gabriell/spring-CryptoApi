package CryptoApp.cryptoApp.repository;

import CryptoApp.cryptoApp.dto.CoinDTO;
import CryptoApp.cryptoApp.entity.Coin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoinRepository {

    private static final Logger logger = LoggerFactory.getLogger(CoinRepository.class);

    private static final String INSERT = "INSERT INTO coin (name, price, quantity, datetime) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT name, quantity FROM coin";

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

    public List<CoinDTO> getAll(){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<CoinDTO>() {

            @Override
            public CoinDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

                CoinDTO coin = new CoinDTO();
                coin.setName(rs.getString("name"));
                coin.setQuantity(rs.getBigDecimal("quantity"));

                return coin;
            }
        });
    }
}
