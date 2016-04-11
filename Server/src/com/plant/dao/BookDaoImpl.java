package com.plant.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.plant.entity.Book;
import com.plant.util.HibernateSessionFactory;

public class BookDaoImpl implements BookDao {

	private Transaction transaction;
	
	@Override
	public Book getBook(int bookId) {
		Session session = HibernateSessionFactory.getSession();
		return (Book)session.load(Book.class, bookId); 
	}

	@Override
	public int[] getBookIdByBookName(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Book> getBookByBookName(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveBook(Book book) {
		Session session = HibernateSessionFactory.getSession();
		try{
			transaction = session.beginTransaction();
			session.save(book);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			System.out.println("saveBook Failed!");
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}	
	}

	@Override
	public Set<Book> allBooks(int pageNum) {
		String hql = "from Book";
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery(hql);
        query.setFirstResult((pageNum - 1) * 10);
        query.setMaxResults(10);
        @SuppressWarnings("rawtypes")
		List list = query.list();
		Set<Book> allBook = new HashSet<Book>();
        for(int i = 0; i < list.size(); i++){  
        	Book book = (Book) list.get(i);  
            allBook.add(book);     
        }   
		return allBook;
	}
	
	@Override
	public Set<Book> getBooksByTypeId(int typeId, int pageNum) {
		String hql = "from Book as a where a.typeId='" + typeId + "'";
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery(hql);
        query.setFirstResult((pageNum - 1) * 10);
        query.setMaxResults(10);
        @SuppressWarnings("rawtypes")
		List list = query.list();
		Set<Book> allBook = new HashSet<Book>();
        for(int i = 0; i < list.size(); i++){  
        	Book book = (Book) list.get(i);  
            allBook.add(book);     
        }   
		return allBook;
	}

	@Override
	public Set<Book> getBooksByUserId(int userId, int pageNum) {
		String hql = "from Book as a where a.user.userId='" + userId + "'";
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery(hql);
        query.setFirstResult((pageNum - 1) * 10);
        query.setMaxResults(10);
        @SuppressWarnings("rawtypes")
		List list = query.list();
		Set<Book> allBook = new HashSet<Book>();
        for(int i = 0; i < list.size(); i++){  
        	Book book = (Book) list.get(i);  
            allBook.add(book);     
        }   
		return allBook;
	}
	
}
