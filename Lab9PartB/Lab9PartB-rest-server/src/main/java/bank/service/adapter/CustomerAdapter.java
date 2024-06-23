package bank.service.adapter;

import bank.domain.Customer;
import bank.service.dto.CustomerDTO;

public class CustomerAdapter {
    public static CustomerDTO getCustomerDTOFromCustomer(Customer customer){
        return new CustomerDTO(customer.getName());
    }

    public static Customer getCustomerFromCustomerDTO(CustomerDTO customerDTO){
        return  new Customer(customerDTO.getName());
    }
}
