package ch.bebaforst.bebaweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dummy {
	@Id
	@GeneratedValue
	@Column
	private Long id;

	@Column
	private String value;
}
