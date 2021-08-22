package org.itbl.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
		name = "USER_MST",
		uniqueConstraints = @UniqueConstraint(
				columnNames = {
						"NAME"
				}
				)
		)
public class User {
	
	@Id
	@SequenceGenerator(
			name = "user_sequence",
			sequenceName = "USER_SEQ",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_sequence"
			)
	private Long id;
	private String name;
	private String password;
	
	@ManyToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
			)
	@JoinColumn(
			name = "TYPE",
			referencedColumnName = "TYPE_ID"
			)
	private UserType userType;

}
