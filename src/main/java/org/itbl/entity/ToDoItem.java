package org.itbl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
		name = "ITEM"
		)
public class ToDoItem {
	
	@Id
	@SequenceGenerator(
			name = "item_sequence",
			sequenceName = "ITEM_SEQ",
			allocationSize = 1
			)
	@GeneratedValue(
			generator = "item_sequence",
			strategy = GenerationType.SEQUENCE
			)
	@Column(
			name = "ID"
			)
	private Long id;
	@Column(name = "NAME")
	private String task;
	
	@Column(name = "IS_DONE")
	private String isDone;

}
