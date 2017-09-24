package com.cnten.platform.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public interface CommonDAO {
	
	public void setSuperSessionFactory(SessionFactory sessionFactory);

	public Session getHibernateSession();
	
	public Session openHibernateSession();
	
	public void releaseHibernateSession(Session session);
	
	public HibernateTemplate getHibernateTemplate();

	public void updateBatch(final Collection<?> all);

	public void save(Object object);

	public void update(Object object);

	public void updateByQuery(String queryString, HashMap<String, Object> params);
	
	public void updateBySQLQuery(String sql, HashMap<String, Object> params);
	
	public void updateByVPQuery(String queryString, Object... params);
	
	public void updateByVPSQLQuery(String sql, Object... params);

	public void delete(Object object);

	public void delete(Class<?> clazz, Serializable id);
	
	public <T> T load(Class<T> clazz, Serializable id);

	public <T> T get(Class<T> clazz, Serializable id);

	public <T> T get(String queryString, HashMap<String, Object> params);
	
	public Map<String,Object> sqlGet(String sql, HashMap<String, Object> params);

	public <T> T getByVariableParam(String hql, Object... params);
	
	public Map<String,Object> sqlGetByVP(String sql, Object... params);

	public <T> List<T> queryListByVariableParam(String hql, Object... params);
	
	public List<Map<String,Object>> sqlQueryListByVP(String sql, Object... params);

	public <T> List<T> queryList(String hql, HashMap<String, Object> params);
	
	public List<Map<String,Object>> sqlQueryList(String sql, HashMap<String, Object> params);
	
	public Long getCount(String hql, HashMap<String, Object> params);
	
	public Long sqlGetCount(String sql, HashMap<String, Object> params);
	
	public Long getCountByVariableParam(String hql, final Object... params);
	
	public Long sqlGetCountByVP(String sql, final Object... params);
	
	public Page getPage(String hql, Integer pageIndex, Integer pageSize, HashMap<String, Object> params);
	
	public Page sqlGetPage(String sql, Integer pageIndex, Integer pageSize, HashMap<String, Object> params);
	
	public Page getPageByVariableParam(String hql, Integer pageIndex, Integer pageSize, final Object... params);
	
	public Page sqlGetPageByVP(String sql, Integer pageIndex, Integer pageSize, final Object... params);

}
