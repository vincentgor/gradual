package com.vinxent.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.vinxent.dao.UserDao;
import com.vinxent.vo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration().configure();
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        .applySettings(conf.getProperties()).build();
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(user);
		int id =user.getId();
		tx.commit();
		sess.close();
		sf.close();
		return id;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		//这里不是真的删除，而是设置其is_delete为false
		User user = queryUserById(id);
		user.setIs_delete(true);
		update(user);
		return 0;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration().configure();
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        .applySettings(conf.getProperties()).build();
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(user);
		int id =user.getId();
		tx.commit();
		sess.close();
		sf.close();
		return id;
	}

	@Override
	public int updatePsw(int userId, String password) {
		// TODO Auto-generated method stub
		User user = queryUserById(userId);
		user.setPassword(password);
		update(user);
		return 0;
	}

	@Override
	public List<User> queryAllUsers() {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration().configure();
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        .applySettings(conf.getProperties()).build();
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		String hql="from User as user";//使用命名参数，推荐使用，易读。
		Query query=sess.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> user = query.list();
		tx.commit();
		sess.close();
		sf.close();
		return user;
	}

	@Override
	public User queryUserById(int id) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration().configure();
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        .applySettings(conf.getProperties()).build();
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		String hql="from User as user where user.id=:id";//使用命名参数，推荐使用，易读。
		Query query=sess.createQuery(hql);
		query.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<User> user = query.list();
		tx.commit();
		sess.close();
		sf.close();
		if (user.size()==0)
			return null;
		return user.get(0);
	}

	@Override
	public User queryUserByUserName(String name) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration().configure();
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        .applySettings(conf.getProperties()).build();
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		String hql="from User as user where user.name=:name";//使用命名参数，推荐使用，易读。
		Query query=sess.createQuery(hql);
		query.setString("name", name);
		@SuppressWarnings("unchecked")
		List<User> user = query.list();
		tx.commit();
		sess.close();
		sf.close();
		if (user.size()==0)
			return null;
		return user.get(0);
	}

}
