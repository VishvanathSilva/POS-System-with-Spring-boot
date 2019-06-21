package lk.ijse.dep.spring.last.service.custom.impl;

import lk.ijse.dep.spring.last.repository.CustomerRepository;
import lk.ijse.dep.spring.last.dto.CustomerDTO;
import lk.ijse.dep.spring.last.entity.Customer;
import lk.ijse.dep.spring.last.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

//    public CustomerServiceImpl(){
//        String repository = DAOFactory.getInstance().<String>getDAO(DAOTypes.CUSTOMER);
//    }

    @Override
    public CustomerDTO getCustomerById(String id) {
        Customer customer = customerRepository.getOne(id);
        CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress());
        return customerDTO;

    }

    @Override
    public boolean isCustomerExists(String id) {
        return customerRepository.existsById(id);
    }

    public List<CustomerDTO> getAllCustomers()  {
        List<CustomerDTO> customers = customerRepository.findAll().stream().map(customer -> new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress())).collect(Collectors.toList());
        return customers;

    }

    public String saveCustomer(CustomerDTO dto)   {
        return customerRepository.save(new Customer(dto.getId(), dto.getName(), dto.getAddress())).getId();
    }

    public void updateCustomer(CustomerDTO dto)   {
        customerRepository.save(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    public void removeCustomer(String id)   {
        customerRepository.deleteById(id);
    }

}
