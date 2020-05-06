package com.sanutana.customers.controller;

import com.sanutana.customers.service.CustomerService;
import com.sanutana.customers.domain.ContactInfo;
import com.sanutana.customers.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomers());
    }


    /**
     * @param id
     * @return
     *
     */
    @GetMapping("/getone/{id}")
    public ResponseEntity<?> getCustomerById(@Valid @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerById(id));
    }

    @PostMapping("/savecustomer")
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.saveCustomer(customer));
    }


    @GetMapping("/getmaskedcontact/{id}")
    public ResponseEntity<?> getMaskedContactById( @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getMaskedContactById(id));
    }

    @PostMapping("/addcustomercontact/{id}")
    public ResponseEntity<?> addContact (@PathVariable Long id, @Valid @RequestBody ContactInfo contact, BindingResult result, RedirectAttributes attr) {
        if(result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.contact", result);
            attr.addFlashAttribute("contact", contact);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }else{
            customerService.addContact(id, contact);
            return new ResponseEntity(HttpStatus.OK);
        }

    }






}
