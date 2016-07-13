package cn.dhon.oa.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.dhon.oa.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;
	private Class clazz;
	
	protected BaseDaoImpl(){
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];
	}
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void delete(Long id) {
		if(id == null){
			return;
		}
		Object entity = getById(id);
		if(entity != null){
			getSession().delete(entity);
		}
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public T getById(Long id) {
		return (T)getSession().get(clazz, "id");
		
	}

	public List<T> getByIds(Long[] id) {
		return getSession().createQuery(//
				"FROM "+clazz.getSimpleName()+"WHERE id IN (:id)")
				.setParameterList("ids", id)
				.list();
	}

	public List<T> getAll() {
		return getSession().createQuery("FROM "+clazz.getSimpleName()).list();
	}

}
