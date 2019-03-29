package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Beehive")
public class BirdNest {
	@Id
	@Column(name="bn_id")
	@SequenceGenerator(sequenceName="birdnest_seq", name="bn_seq")
	@GeneratedValue(generator="bn_seq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="bn_eggs")
	private Integer eggs;
	
	
	public BirdNest() {
		super();
	}
	public BirdNest(Integer id, Integer eggs) {
		super();
		this.id = id;
		this.eggs = eggs;
	}
	public BirdNest(Integer eggs) {
		super();
		this.eggs = eggs;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEggs() {
		return eggs;
	}
	public void setEggs(Integer eggs) {
		this.eggs = eggs;
	}
	@Override
	public String toString() {
		return "BirdNest [id=" + id + ", eggs=" + eggs + "]";
	}
	
}
