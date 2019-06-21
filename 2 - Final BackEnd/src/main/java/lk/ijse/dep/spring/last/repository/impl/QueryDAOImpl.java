package lk.ijse.dep.spring.last.repository.impl;

import lk.ijse.dep.spring.last.entity.CustomEntity;
import lk.ijse.dep.spring.last.repository.QueryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QueryDAOImpl implements QueryRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CustomEntity> getOrdersTotal() {

        List<Object[]> list = em.createNativeQuery("SELECT id, SUM(qty * unitPrice) AS Total FROM `Order` INNER JOIN\n" +
                "  OrderDetail OD on `Order`.id = OD.orderId GROUP BY id").getResultList();

        List<CustomEntity> al = new ArrayList<>();

        for (Object[] objects : list) {
            al.add(new CustomEntity((Integer) objects[0], (Double) objects[1]));
        }

        return al;
    }
}
