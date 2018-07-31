package com.sidneyspe.web;

import com.sidneyspe.domain.Customer;
import com.sidneyspe.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    private CustomerService customerService;

    @Inject
    public void setService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerWithId(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"name"},
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Customer>> findCustomerWithName(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(customerService.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomerFromDB(@PathVariable("id") long id, @RequestBody Customer customer) {

        Customer currentCustomer = customerService.findOne(id);
        currentCustomer.setName(customer.getName());
        currentCustomer.setCpf(customer.getCpf());

        return new ResponseEntity<>(customerService.save(currentCustomer), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteCustomerWithId(@PathVariable Long id) {
        customerService.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllCustomers() {
        customerService.deleteAll();
    }
}
