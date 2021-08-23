package org.itbl.service;

import java.util.List;

import org.itbl.entity.ToDoItem;

public interface ToDoItemService {
	
	public List<ToDoItem> listToDoItem();
	public ToDoItem saveToDoItem(ToDoItem toDoItem);
	public ToDoItem editToDoItem(ToDoItem toDoItem);
	public void deleteToDoItem(Long id);

}
