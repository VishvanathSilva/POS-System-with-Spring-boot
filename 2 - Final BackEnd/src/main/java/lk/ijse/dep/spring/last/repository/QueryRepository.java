package lk.ijse.dep.spring.last.repository;

import lk.ijse.dep.spring.last.entity.CustomEntity;

import java.util.List;

public interface QueryRepository {

    List<CustomEntity> getOrdersTotal();

}
