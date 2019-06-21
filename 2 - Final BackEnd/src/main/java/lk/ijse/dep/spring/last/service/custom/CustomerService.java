package lk.ijse.dep.spring.last.service.custom;

import lk.ijse.dep.spring.last.dto.CustomerDTO;
import lk.ijse.dep.spring.last.service.SuperService;

import java.util.List;

public interface CustomerService extends SuperService {

    List<CustomerDTO> getAllCustomers();

    String saveCustomer(CustomerDTO dto);

    void updateCustomer(CustomerDTO dto);

    void removeCustomer(String id);

    CustomerDTO getCustomerById(String id);

    boolean isCustomerExists(String id);

}
