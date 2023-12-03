package CryptoApp.cryptoApp.repository;

import CryptoApp.cryptoApp.dto.CoinTransactionDTO;
import CryptoApp.cryptoApp.entity.Coin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CoinRepository {

    @Autowired
    private EntityManager entityManager;



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


    public List<Coin> getByName(String name) {
        String jpql = "select c from Coin c where c.name like :name";
        TypedQuery<Coin> query = entityManager.createQuery(jpql, Coin.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    @Transactional
    public boolean remove(int id) {
        Coin coin = entityManager.find(Coin.class, id);

        if(coin == null)
            throw new RuntimeException();

        entityManager.remove(coin);
        return true;
    }

}
