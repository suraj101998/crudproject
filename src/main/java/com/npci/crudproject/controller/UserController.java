package com.npci.crudproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.crudproject.entity.Users;
import com.npci.crudproject.response.UserDepartmentResponse;
import com.npci.crudproject.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService customerService;
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<Users>> getAllUsers(){
		
		List<Users> users = null;
		
		try {
			users = customerService.getAllUsers();
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable("id") int userId){
		
		Users users = null;
		
		try {
			users = customerService.getUserById(userId);
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}
	
	@PostMapping("/addorupdate") 
	public ResponseEntity<Users> addOrUpdate(@RequestBody Users user){
		
		Users users = null;
		
		try {
			users = customerService.addOrUpdateUser(user);
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Users> deleteUserById(@PathVariable("id") int userId){
		
		Users users = null;
		
		try {
			users = customerService.deleteUser(userId);
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}
	
	// Get Users by salary condition
	@GetMapping("/allUsersBySalary/{salary}")
	public ResponseEntity<List<Users>> getAllUsersBySalary(@PathVariable("salary") float salary){
		
		List<Users> users = null;
		
		try {
			users = customerService.getuserBySalary(salary);
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/allUserDepartments")
	public ResponseEntity<List<UserDepartmentResponse>> getAllUserDepartments(){
		
		List<UserDepartmentResponse> users = null;
		
		try {
			users = customerService.getUserDepartMent();
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<List<UserDepartmentResponse>>(users, HttpStatus.OK);
	}
}