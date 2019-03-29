package com.revature.dao;

import java.util.List;

import com.revature.beans.Bird;

public interface BirdDao {
	public Integer insertBird(Bird b);
	public List<Bird> selectAllBirds();
	public Bird selectBirdById(Integer id);
	public void updateBird(Bird b);
}
