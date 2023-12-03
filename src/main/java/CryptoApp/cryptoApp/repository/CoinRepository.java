package CryptoApp.cryptoApp.repository;

import CryptoApp.cryptoApp.dto.CoinTransactionDTO;
import CryptoApp.cryptoApp.entity.Coin;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CoinRepository {

    private EntityManager entityManager;
    private JdbcTemplate jdbcTemplate;

    public CoinRepository(JdbcTemplate jdbcTemplate, EntityManager entityManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.entityManager = entityManager;
    }

    @Transactional
    public Coin insert(Coin coin) {
        entityManager.persist(coin);
        return coin;
    }

    @Transactional
    public Coin update(Coin coin) {
        entityManager.merge(coin);
        return coin;
    }

    public List<CoinTransactionDTO> getAll(){
        String jpql = "select new CryptoApp.cryptoApp.dto.CoinTransactionDTO(c.name, sum(c.quantity)) from Coin c group by c.name";
        TypedQuery<CoinTransactionDTO> query = entityManager.createQuery(jpql, CoinTransactionDTO.class);
        return query.getResultList();
    }

    /*
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
    }    */
}
