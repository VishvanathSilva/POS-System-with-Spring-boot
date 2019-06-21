package lk.ijse.dep.spring.last.repository;

import lk.ijse.dep.spring.last.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findFirstCustomerByOrderByAddressDesc();

    List<Customer> findCustomersByNameLike(String word);

    @Query(value = "SELECT c FROM Customer c WHERE c.name LIKE ?#{[0]}")
    List<Customer> customerQuery(String word);

    List<Customer> getCustomersByNameLikeAndAddressLikeOrderByIdDesc(String name, String address);

    List<Customer> customerQuery2(@Param("name") String name, @Param("address") String address);

}
