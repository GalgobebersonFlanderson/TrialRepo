package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Worm")
public class Worm {
	
	
	public Worm() {
		super();
	}
	public Worm(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public Worm(String type) {
		super();
		this.type = type;
	}
	@Id
	@Column(name="w_id")
	@SequenceGenerator(sequenceName="worm_seq", name="w_seq")
	@GeneratedValue(generator="w_seq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="w_type")
	private String type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Worm [id=" + id + ", type=" + type + "]";
	}
}
