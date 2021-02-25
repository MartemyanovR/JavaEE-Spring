package ru.mart.hibernateAnnotationProject.services;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import ru.mart.hibernateAnnotationProject.dao.AddressDao;
import ru.mart.hibernateAnnotationProject.entity.Address;
import ru.mart.hibernateAnnotationProject.utils.SessionUtil;

public class AddressService extends SessionUtil implements AddressDao{

	@Override
	public void add(Address address) throws SQLException {
		openTransactionSession();
		Session session = getSession();
		session.save(address);
		closeTransactionSession();
	}

	@Override
	public List<Address> getAll() throws SQLException {
		 System.out.println("\nЧтение записей : HQL");
		 String sql = "From " + Address.class.getSimpleName();
		openTransactionSession();
		Session session = getSession();
		@SuppressWarnings("unchecked")
		Query<Address> query =session.createQuery(sql);
		List<Address> listAddress = query.list();
		closeTransactionSession();
		return listAddress;
	}

	@Override
	public Address getById(Long id) throws SQLException {
		openTransactionSession();
		Session session = getSession();
		Address address	= session.load(Address.class, id);
		if(address!=null) {
			System.out.println(address.toString());
		}
		closeTransactionSession();
		return null;
	}

	@Override
	public void update(Address address) throws SQLException {
		openTransactionSession();
		Session session = getSession();
		session.update(address);
		closeTransactionSession();		
	}

	@Override
	public void remove(Address address) throws SQLException {
		openTransactionSession();
		Session session = getSession();
		session.remove(address);
		closeTransactionSession();		
	}

}
