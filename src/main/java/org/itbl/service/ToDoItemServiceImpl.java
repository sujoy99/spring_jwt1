package org.itbl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.itbl.entity.ToDoItem;
import org.itbl.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoItemServiceImpl implements ToDoItemService {
	
	@Autowired
	private ToDoItemRepository toDoItemRepository;
	
	
	

	@Override
	@Transactional
	public ToDoItem saveToDoItem(ToDoItem toDoItem) {
		
		toDoItem.setIsDone("0");
		
		return toDoItemRepository.save(toDoItem);
		
	}




	@Override
	public List<ToDoItem> listToDoItem() {
		
		return toDoItemRepository.findAll();
	}




	@Override
	@Transactional
	public ToDoItem editToDoItem(ToDoItem toDoItem) {
		
		if(toDoItem.getIsDone().equals("false")) {
			toDoItem.setIsDone("0");
		}else {
			toDoItem.setIsDone("1");
		}
		
		return toDoItemRepository.save(toDoItem);
	}




	@Override
	public void deleteToDoItem(Long id) {
		
		toDoItemRepository.deleteById(id);
		
	}

}
