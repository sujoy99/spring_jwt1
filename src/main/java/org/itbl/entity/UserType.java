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
		name = "USER_TYPE"
		)
public class UserType {
	
	@Id
	@SequenceGenerator(
			name = "type_sequence",
			sequenceName = "TYPE_SEQ",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "type_sequence"
			)
	@Column(
			name = "TYPE_ID"
			)
	private Long typeId;
	@Column(
			name = "TYPE_DESC"
			)
	private String  description;

}
