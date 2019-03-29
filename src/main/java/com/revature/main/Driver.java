package com.revature.main;

import com.revature.beans.Cat;
import com.revature.beans.Worm;
import com.revature.dao.CatDao;
import com.revature.dao.imp.CatDaoImp;

public class Driver {

	public static void main(String[] args) {
		Cat c = new Cat("Bear", "Bear-colored");
		CatDao cd = new CatDaoImp();
		//cd.insertCat(c);
		
		Worm w = new Worm("Earth");
		Worm w2 = new Worm("Ugly");
	}
}
