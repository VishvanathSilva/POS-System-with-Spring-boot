package lk.ijse.dep.spring.last.controller;

import lk.ijse.dep.spring.last.dto.CustomerDTO;
import lk.ijse.dep.spring.last.dto.ItemDTO;
import lk.ijse.dep.spring.last.service.custom.CustomerService;
import lk.ijse.dep.spring.last.service.custom.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/items")
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }
    ///////////////////////////get a Item////////////////////////

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> getItem(@PathVariable("id") String id) {
        ItemDTO dto = null;
       if (itemService.isItemExists(id)){
            dto = itemService.getItemById(id);
        }
        System.out.println(dto);
        return new ResponseEntity<ItemDTO>(dto, (dto != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
   }
   /////////////////////////save////////////////////////

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveItem(@RequestBody ItemDTO item){
        if (item.getCode().isEmpty() || item.getDescription().isEmpty()){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }else{
            String itemId = itemService.saveItem(item);
            return new ResponseEntity<String>(itemId,HttpStatus.CREATED);
        }
    }
    //////////////////////////////Update/////////////////////////////////////
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateItem(@PathVariable("id") String id, @RequestBody ItemDTO item){
        if (!itemService.isItemExists(id)){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        if (item.getCode().isEmpty() || item.getDescription().isEmpty()){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }else{
            item.setCode(id);
            itemService.updateItem(item);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }
////////////////////////////////////////delete//////////////////////////////////////////////////////////////////////////////
@DeleteMapping(path = "/{id}")
public ResponseEntity<Void> deleteItem(@PathVariable("id") String id){
    System.out.println(id);
    if (!itemService.isItemExists(id)){
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }
    itemService.removeItem(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

    }
}
