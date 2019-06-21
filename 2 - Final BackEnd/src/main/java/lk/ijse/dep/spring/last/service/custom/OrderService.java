package lk.ijse.dep.spring.last.service.custom;

import lk.ijse.dep.spring.last.dto.OrderDTO;
import lk.ijse.dep.spring.last.service.SuperService;

import java.util.List;

public interface OrderService extends SuperService {

    void placeOrder(OrderDTO order);

    int generateOrderId();

    List<OrderDTO> getAllOrders();///////////////////////////

}
