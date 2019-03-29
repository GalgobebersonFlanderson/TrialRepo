package com.revature.dao.imp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Worm;
import com.revature.dao.WormDao;
import com.revature.util.HibernateUtil;

public class WormDaoImp implements WormDao {

	public Integer insertWorm(Worm w) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer id = null;
		
		try
		{
			tx = session.beginTransaction();
			id = (Integer)session.save(w);
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

	public List<Worm> selectAllWorms() {
		Session session = HibernateUtil.getSession();
		List<Worm> Worms = null;
		
		try
		{
			Worms = session.createQuery("From Worm").list();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return Worms;
	}

	public Worm selectWormById(Integer id) {
		Session session = HibernateUtil.getSession();
		Worm Worm = null;
		try
		{
			Worm = (Worm)session.get(Worm.class, id);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return Worm;
	}

	public void updateWorm(Worm w) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Worm worm = null;
		
		try
		{
			tx = session.beginTransaction();
			worm = (Worm)session.get(Worm.class, w.getId());
			if (w.getType() != null)
			{
				worm.setType(w.getType());
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
