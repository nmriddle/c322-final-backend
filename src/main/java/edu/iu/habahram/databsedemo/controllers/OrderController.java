package edu.iu.habahram.databsedemo.controllers;

import edu.iu.habahram.databsedemo.model.Address;
import edu.iu.habahram.databsedemo.model.Order;
import edu.iu.habahram.databsedemo.model.Recipient;
import edu.iu.habahram.databsedemo.repository.AddressRepository;
import edu.iu.habahram.databsedemo.repository.OrderRepository;
import edu.iu.habahram.databsedemo.repository.RecipientRepository;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {

    OrderRepository orderRepository;
    AddressRepository addressRepository;
    RecipientRepository recipientRepository;

    public OrderController(OrderRepository orderRepository, AddressRepository addressRepository, RecipientRepository recipientRepository) {
        this.orderRepository = orderRepository;
        this.addressRepository = addressRepository;
        this.recipientRepository = recipientRepository;
    }

    @PostMapping
    public int add(@RequestBody Order order) {
        String username = getTheCurrentLoggedInCustomer();
        order.setCustomerUserName(username);
        Order saved = orderRepository.save(order);
        return saved.getId();
    }

    private String getTheCurrentLoggedInCustomer() {
        Object principal = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof Jwt) {
            username = ((Jwt) principal).getSubject();
        }
        return username;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAllByCustomer() {
        String username = getTheCurrentLoggedInCustomer();
        System.out.println(username);
        if (username.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        List<Order> orders = orderRepository.findAllByCustomerUserName(username);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Order>> search(@RequestBody Order order) {
        String username = getTheCurrentLoggedInCustomer();
        System.out.println(username);
        if (username.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Example<Order> example = Example.of(order);
        List<Order> orders = (List<Order>) orderRepository.findAll(example);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @PostMapping("/recipient")
    public int addRecipient(@RequestBody Recipient recipient) {
        Recipient saved = recipientRepository.save(recipient);
        return saved.getId();
    }

    @PostMapping("/address")
    public int addAddress(@RequestBody Address address) {
        Address saved = addressRepository.save(address);
        return saved.getId();
    }

    @GetMapping("/recipient")
    public Iterable<Recipient> getAllRecipients() {
        return recipientRepository.findAll();
    }

    @GetMapping("/address")
    public Iterable<Address> getAllAddresses() {
        return addressRepository.findAll();
    }


}
