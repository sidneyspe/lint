package com.sidneyspe.web;

import com.sidneyspe.domain.Customer;
import com.sidneyspe.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    private CustomerRepository customerRepository;

    @Inject
    public void setService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerWithId(@PathVariable Long id) {
        return new ResponseEntity<>(customerRepository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"name"},
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Customer>> findCustomerWithName(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(customerRepository.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomerFromDB(@PathVariable("id") long id, @RequestBody Customer customer) {

        Customer currentCustomer = customerRepository.findOne(id);
        currentCustomer.setName(customer.getName());
        currentCustomer.setCpf(customer.getCpf());

        return new ResponseEntity<>(customerRepository.save(currentCustomer), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteCustomerWithId(@PathVariable Long id) {
        customerRepository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }
}
