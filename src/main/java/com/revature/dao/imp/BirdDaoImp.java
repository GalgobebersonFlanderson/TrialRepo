package com.revature.dao.imp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Cat;
import com.revature.dao.CatDao;
import com.revature.util.HibernateUtil;

public class BirdDaoImp implements CatDao {

	public Integer insertCat(Cat c) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer id = null;
		
		try
		{
			tx = session.beginTransaction();
			id = (Integer)session.save(c);
			tx.commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			session.close();
		}
		
		return id;
	}

	public List<Cat> selectAllCats() {
		Session session = HibernateUtil.getSession();
		List<Cat> cats = null;
		
		try
		{
			cats = session.createQuery("From Cat").list();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return cats;
	}

	public Cat selectCatById(Integer id) {
		Session session = HibernateUtil.getSession();
		Cat cat = null;
		try
		{
			cat = (Cat)session.get(Cat.class, id);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return cat;
	}

	public void updateCat(Cat c) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Cat cat = null;
		
		try
		{
			tx = session.beginTransaction();
			cat = (Cat)session.get(Cat.class, c.getId());
			if (c.getName() != null)
			{
				cat.setName(c.getName());
			}
			if (c.getColor() != null)
			{
				cat.setColor(c.getColor());
			}
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			session.close();
		}
	}
	
}
