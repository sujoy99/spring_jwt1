package org.itbl.controller;

import org.itbl.entity.ToDoItem;
import org.itbl.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ToDoItemController {
	
	
	
	@Autowired
	private ToDoItemService toDoItemService;
	
	
	
	@GetMapping("/api/v1/toDoItem")
	public ResponseEntity<?> fetchToDoItem(){
		
		System.out.println(toDoItemService.listToDoItem());
		
		return ResponseEntity.ok(toDoItemService.listToDoItem());
	}
	
	@PostMapping("/api/v1/toDoItem")
	public ResponseEntity<?> saveToDoItem(@RequestBody ToDoItem toDoItem){
		
		toDoItemService.saveToDoItem(toDoItem);
		
		return ResponseEntity.ok(toDoItemService.listToDoItem());
	}
	
	@PutMapping("api/v1/toDoItem/{id}")
	public ResponseEntity<?> editToDoItem(@PathVariable("id") Long id, @RequestBody ToDoItem toDoItem){
		
		System.out.println(toDoItem);
		
		ToDoItem updatedToDoItem = toDoItemService.editToDoItem(toDoItem);
		
		System.out.println(updatedToDoItem);
		
		return ResponseEntity.ok(updatedToDoItem);
	}
	
	@DeleteMapping("api/v1/toDoItem/{id}")
	public ResponseEntity<?> deleteToDoItem(@PathVariable("id") Long id){
		
		toDoItemService.deleteToDoItem(id);
		
		return ResponseEntity.ok(toDoItemService.listToDoItem());
	}

}
