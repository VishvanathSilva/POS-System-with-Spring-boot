package lk.ijse.dep.spring.last.controller;

import lk.ijse.dep.spring.last.dto.OrderDTO;
import lk.ijse.dep.spring.last.dto.OrderDetailDTO;
import lk.ijse.dep.spring.last.service.custom.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        System.out.println("get all orders");
        return orderService.getAllOrders();

    }

    /////////////////////////////////////////////////////////////////////////////////
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveOrder(@RequestBody OrderDTO order) {
        System.out.println("working Order");
        System.out.println(order);
        System.out.println(order.getOrderId());
        System.out.println(order.getCustomerId());
        System.out.println(order.getOrderDate());
        System.out.println(order.getOrderDetails());
        List<OrderDetailDTO> OD = order.getOrderDetails();
        if (order.getCustomerId().isEmpty() || order.getOrderDate() == null || order.getOrderId() <= 0) {

            System.out.println("bad");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        if (OD.isEmpty()) {

            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        } else {
            orderService.placeOrder(order);
//            String itemId = orderService.placeOrder(order);
            return new ResponseEntity<String>(HttpStatus.CREATED);
        }

    }
}
