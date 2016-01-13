package com.plant.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.plant.entity.Privilege;
import com.plant.entity.User;
import com.plant.util.HibernateSessionFactory;

public class UserDaoImpl implements UserDao {
	
	private Transaction transaction;
	
	@Override
	public User getUser(int userId) {
		Session session = HibernateSessionFactory.getSession();
		User user = (User)session.load(User.class, userId);
		return user;
	}

	@Override
	public boolean getUserByAccount(String userAccount) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User as a where a.userAccount='" + userAccount + "'";
		Query query = (Query) session.createQuery(hql);
		User user = (User) query.uniqueResult();
		if(user != null){
			HibernateSessionFactory.closeSession();
			return true;
		}				
		HibernateSessionFactory.closeSession();
		return false;
	}

	@Override
	public int getUserIdByAccount(String userAccount) {
		int studentId = 0;
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User as a where a.userAccount='" + userAccount + "'";
		Query query = session.createQuery(hql);
		User user = (User) query.uniqueResult();
		if(user != null){
			studentId = user.getUserId();
			HibernateSessionFactory.closeSession();
			return studentId;
		}
		HibernateSessionFactory.closeSession();
		return -1;
	}

	@Override
	public void saveUser(User user) {
		Session session = HibernateSessionFactory.getSession();
		try{
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			System.out.println("saveUser Failed!");
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}	
	}

	@Override
	public void savePrivilege(Privilege privilege) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean login(User user) {
		if(user.getUserAccount()!=null && user.getUserPassword()!=null){
			Session session = HibernateSessionFactory.getSession();
			try{
				String hql = "from User as a where a.userAccount='"
						+ user.getUserAccount() + "' and a.userPassword='"
						+ user.getUserPassword() + "'";
				System.out.println("hql:"+hql);
				Query query = (Query) session.createQuery(hql);
				User s = (User) query.uniqueResult();
				if(s != null){
					HibernateSessionFactory.closeSession();
					return true;
				}
			}catch(Exception e){
				System.out.println("login Failed!");
				e.printStackTrace();
			}finally{
				HibernateSessionFactory.closeSession();
			}
		}
		return false;
	}

}
