package com.example.restaurantmanagementsystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.restaurantmanagementsystem.entity.User;
import com.example.restaurantmanagementsystem.service.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register
    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        User loggedInUser = userService.loginUser(user);
        return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
    }

    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long userId, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user, userId), HttpStatus.OK);
    }

    // Get All Users
    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    // Get Users by Role
    @GetMapping("/role/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable String role) {
        List<User> users = userService.getAllUser().stream()
                .filter(user -> role.equalsIgnoreCase(user.getRole()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    // Get Suppliers
    @GetMapping("/suppliers")
    public ResponseEntity<List<User>> getAllSuppliers() {
        return new ResponseEntity<>(getUsersByRole("supplier").getBody(), HttpStatus.OK);
    }

    // Get Waiters
    @GetMapping("/waiters")
    public ResponseEntity<List<User>> getAllWaiters() {
        return new ResponseEntity<>(getUsersByRole("waiter").getBody(), HttpStatus.OK);
    }

    // Get Delivery Partners
    @GetMapping("/delivery-partners")
    public ResponseEntity<List<User>> getAllDeliveryPartners() {
        return new ResponseEntity<>(getUsersByRole("delivery-partner").getBody(), HttpStatus.OK);
    }

    // Get Chefs
    @GetMapping("/chefs")
    public ResponseEntity<List<User>> getAllChefs() {
        return new ResponseEntity<>(getUsersByRole("chef").getBody(), HttpStatus.OK);
    }

    // Get Customers
    @GetMapping("/customers")
    public ResponseEntity<List<User>> getAllCustomers() {
        return new ResponseEntity<>(getUsersByRole("customer").getBody(), HttpStatus.OK);
    }

    // Get Owners
    @GetMapping("/owners")
    public ResponseEntity<List<User>> getAllOwners() {
        return new ResponseEntity<>(getUsersByRole("owner").getBody(), HttpStatus.OK);
    }

    // Get Restaurants
    @GetMapping("/restaurants")
    public ResponseEntity<List<User>> getAllRestaurants() {
        return new ResponseEntity<>(getUsersByRole("restaurant").getBody(), HttpStatus.OK);
    }

    // Forgot Password
    @PostMapping("/forgotpassword")
    public ResponseEntity<?> getUserByEmail(@RequestBody User user) {
        User foundUser = userService.getUserByEmail(user);
        if (foundUser != null) {
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Email not found!", HttpStatus.NOT_FOUND);
        }
    }

    // Change User Password
    @PostMapping("/{uid}/{newpassword}")
    public ResponseEntity<User> changeUserPassword(@PathVariable long uid, @PathVariable String newpassword) {
        User u = userService.getUserById(uid);
        u.setPassword(newpassword);
        userService.updateUser(u, uid);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    // Verify User Details
    @PostMapping("/verifydetails")
    public ResponseEntity<String> verifyUserDetails(@RequestBody User user) {
        boolean isVerified = userService.verifyUserDetails(user);
        if (isVerified) {
            return new ResponseEntity<>("Verification successful.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Verification failed. Details do not match.", HttpStatus.UNAUTHORIZED);
        }
    }
}
