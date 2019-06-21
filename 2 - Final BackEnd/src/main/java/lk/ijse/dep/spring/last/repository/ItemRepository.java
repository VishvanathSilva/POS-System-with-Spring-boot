package lk.ijse.dep.spring.last.repository;

import lk.ijse.dep.spring.last.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, String> {
//    Item findFirstItemByOrderByAddressDesc();
//
//    List<Item> findItemByNameLike(String word);
//
//    @Query(value = "SELECT i FROM  i WHERE i.name LIKE ?#{[0]}")
//    List<Item> itemQuery(String word);

//    List<Item> getCustomersByNameLikeAndAddressLikeOrderByIdDesc(String name, String address);
//
//    List<Item> customerQuery2(@Param("name") String name, @Param("address") String address);

}
