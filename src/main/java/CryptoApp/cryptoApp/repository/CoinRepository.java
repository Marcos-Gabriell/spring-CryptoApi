package CryptoApp.cryptoApp.repository;

import CryptoApp.cryptoApp.dto.CoinTransactionDTO; // Importação da classe CoinTransactionDTO
import CryptoApp.cryptoApp.entity.Coin;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoinRepository {

    private static final String INSERT = "INSERT INTO coin (name, price, quantity, datetime) VALUES (?,?,?,?)";
    private static final String SELECT_ALL = "SELECT name, SUM(quantity) AS quantity FROM coin GROUP BY name";
    private static final String SELECT_BY_NAME = "SELECT * FROM coin WHERE name = ?";
    private static final String DELETE = "DELETE FROM coin WHERE id = ?";
    private static final String UPDATE = "UPDATE coin SET name = ?, price = ?, quantity = ? WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    public CoinRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public Coin insert(Coin coin) {
        Object[] attr = new Object[]{
                coin.getName(),
                coin.getPrice(),
                coin.getQuantity(),
                coin.getDateTime()
        };
        jdbcTemplate.update(INSERT, attr);
        return coin;
    }

    @Transactional
    public Coin update(Coin coin) {
        Object[] attr = new Object[]{
                coin.getName(),
                coin.getPrice(),
                coin.getQuantity(),
                coin.getId()
        };
        jdbcTemplate.update(UPDATE, attr);
        return coin;
    }

    public List<CoinTransactionDTO> getAll() {
        return jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> {
            CoinTransactionDTO coin = new CoinTransactionDTO();
            coin.setName(rs.getString("name"));
            coin.setQuantity(rs.getBigDecimal("quantity"));
            return coin;
        });
    }

    public List<Coin> getByName(String name) {
        Object[] attr = new Object[]{name};
        return jdbcTemplate.query(SELECT_BY_NAME, (rs, rowNum) -> {
            Coin coin = new Coin();
            coin.setId(rs.getInt("id"));
            coin.setName(rs.getString("name"));
            coin.setPrice(rs.getBigDecimal("price"));
            coin.setQuantity(rs.getBigDecimal("quantity"));
            coin.setDateTime(rs.getTimestamp("datetime"));
            return coin;
        }, attr);
    }

    @Transactional
    public int remove(int id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
