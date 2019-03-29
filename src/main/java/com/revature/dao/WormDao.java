package com.revature.dao;

import java.util.List;

import com.revature.beans.Worm;

public interface WormDao {
	public Integer insertWorm(Worm w);
	public List<Worm> selectAllWorms();
	public Worm selectWormById(Integer id);
	public void updateWorm(Worm w);
}
