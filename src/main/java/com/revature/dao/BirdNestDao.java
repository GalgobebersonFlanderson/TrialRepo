package com.revature.dao;

import java.util.List;

import com.revature.beans.BirdNest;

public interface BirdNestDao {
	public Integer insertBirdNest(BirdNest bn);
	public List<BirdNest> selectAllBirdNests();
	public BirdNest selectBirdNestById(Integer id);
	public void updateBirdNest(BirdNest bn);
}
