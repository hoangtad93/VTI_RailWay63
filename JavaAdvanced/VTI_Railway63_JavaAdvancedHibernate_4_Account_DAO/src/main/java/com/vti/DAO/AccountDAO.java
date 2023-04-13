package com.vti.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.vti.entity.Account;
import com.vti.ultis.HibernateUtils;

public class AccountDAO {
	private HibernateUtils hibernateUtils;

	public AccountDAO() {
		hibernateUtils = HibernateUtils.getInstance();
	}

//	Hàm GetAllAccount
	@SuppressWarnings("unchecked")
	public List<Account> getAllAccount() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account Order by id");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
