package com.revature.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Bird")
public class Bird {
	
	public Bird() {
		super();
	}
	
	public Bird(Integer id, Integer age, BirdNest birdnest, List<Worm> worms) {
		super();
		this.id = id;
		this.age = age;
		this.birdnest = birdnest;
		this.worms = worms;
	}

	public Bird(Integer age, BirdNest birdnest, List<Worm> worms) {
		super();
		this.age = age;
		this.birdnest = birdnest;
		this.worms = worms;
	}
	
	@Id
	@Column(name="b_id")
	@SequenceGenerator(sequenceName="bird_seq", name="b_seq")
	@GeneratedValue(generator="b_seq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="b_age")
	private Integer age;
	
	@ManyToOne
	@JoinColumn(name="b_birdnest")
	private BirdNest birdnest;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="b_worm_jt", 
			   joinColumns=@JoinColumn(name="b_id"),
			   inverseJoinColumns=@JoinColumn(name="w_id"))
	private List<Worm> worms;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public BirdNest getBirdnest() {
		return birdnest;
	}
	public void setBirdnest(BirdNest birdnest) {
		this.birdnest = birdnest;
	}
	public List<Worm> getWorms() {
		return worms;
	}
	public void setWorms(List<Worm> worms) {
		this.worms = worms;
	}

	@Override
	public String toString() {
		return "Bird [id=" + id + ", age=" + age + ", birdnest=" + birdnest + ", worms=" + worms + "]";
	}
}
