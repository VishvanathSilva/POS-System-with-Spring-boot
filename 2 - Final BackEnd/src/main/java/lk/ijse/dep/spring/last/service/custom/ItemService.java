package lk.ijse.dep.spring.last.service.custom;

import lk.ijse.dep.spring.last.dto.ItemDTO;
import lk.ijse.dep.spring.last.service.SuperService;

import java.util.List;

public interface ItemService extends SuperService {

    List<ItemDTO> getAllItems();

    String saveItem(ItemDTO item);/////////////////////////////////////////

    void updateItem(ItemDTO item);

    void removeItem(String code);
    /////////////
    ItemDTO getItemById(String id);

    boolean isItemExists(String id);
    /////////////////////////

}
