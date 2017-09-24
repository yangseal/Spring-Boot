package com.cnten.platform.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings({ "unchecked", "deprecation" })
public class CommonDAOImpl extends HibernateDaoSupport implements CommonDAO{

	@Resource(name = "sessionFactory")
	@Override
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public Session getHibernateSession() {
		return super.getSession();
	}
	
	@Override
	public Session openHibernateSession() {
		return super.getSessionFactory().openSession();
	}
	
	@Override
	public void releaseHibernateSession(Session session) {
		super.releaseSession(session);
	}

	@Override
	public void updateBatch(Collection<?> all) {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			int index = 0;
			for (Iterator<?> i = all.iterator(); i.hasNext(); index++) {
				session.saveOrUpdate(i.next());
				if (index % 20 == 0) {
					// 将本批插入的对象立即写入数据库并释放内存
					session.flush();
					session.clear();
				}
			}
			tx.commit();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				releaseSession(session);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	@Override
	public void save(Object object) {
		getHibernateTemplate().save(object);
	}

	@Override
	public void update(Object object) {
		getHibernateTemplate().update(object);
	}

	@Override
	public void updateByQuery(String queryString, HashMap<String, Object> params) {
		Query query = createQuery(queryString, params);
		query.executeUpdate();
	}
	
	@Override
	public void updateBySQLQuery(String sql, HashMap<String, Object> params) {
		Query query = createSQLQuery(sql, params);
		query.executeUpdate();
	}
	
	@Override
	public void updateByVPQuery(String queryString, Object... params){
		Query query = getSession().createQuery(queryString);
		if (params != null)
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		query.executeUpdate();
	}
	
	@Override
	public void updateByVPSQLQuery(String sql, Object... params){
		Query query = createSQLQuery(sql, null);
		if (params != null)
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		query.executeUpdate();
	}

	@Override
	public void delete(Object object) {
		getHibernateTemplate().delete(object);
	}

	@Override
	public void delete(Class<?> clazz, Serializable id) {
		getHibernateTemplate().delete(load(clazz, id));
	}

	@Override
	public <T> T get(Class<T> clazz, Serializable id) {
		if (null == id)
			return null;
		return getHibernateTemplate().get(clazz, id);
	}

	@Override
	public <T> T get(String queryString, HashMap<String, Object> params) {
		List<T> list = queryList(queryString, params);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public Map<String,Object> sqlGet(String sql, HashMap<String, Object> params){
		List<Map<String,Object>> list = sqlQueryList(sql, params);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public <T> T getByVariableParam(String hql, Object... params) {
		List<T> list = queryListByVariableParam(hql, params);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public Map<String,Object> sqlGetByVP(String sql, Object... params){
		List<Map<String,Object>> list = sqlQueryListByVP(sql, params);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public <T> List<T> queryListByVariableParam(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		if (params != null)
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		List<T> list = query.list();
		return list;
	}
	
	@Override
	public List<Map<String,Object>> sqlQueryListByVP(String sql, final Object... params){
		Query query = createSQLQuery(sql, null);
		if (params != null)
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		List<Map<String,Object>> res = query.list();
		return res;
	}

	@Override
	public <T> List<T> queryList(String hql, HashMap<String, Object> params) {
		Query q = createQuery(hql, params);
		List<T> res = q.list();
		return res;
	}
	
	@Override
	public List<Map<String,Object>> sqlQueryList(String sql, HashMap<String, Object> params){
		Query q = createSQLQuery(sql, params);
		List<Map<String,Object>> res = q.list();
		return res;
	}

	private Query createQuery(String hsql, HashMap<String, Object> params) {
		Query query = getSession().createQuery(hsql);
		String[] keys = query.getNamedParameters();
		if (keys != null && params != null) {
			for (String key : keys) {
				if (!params.containsKey(key)) {
					throw new RuntimeException("没有设置参数" + key + "的值");
				}
				Object value = params.get(key);
				if(value instanceof Collection){
					query.setParameterList(key, (Collection<?>) value);
				}else if(value instanceof Object[]){
					query.setParameterList(key, (Object[]) value);
				}else{
					query.setParameter(key, value);
				}
			}
		}
		return query;
	}
	
	private Query createSQLQuery(String sql, HashMap<String, Object> params) {
		Query query = getSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		String[] keys = query.getNamedParameters();
		if (keys != null && params != null) {
			for (String key : keys) {
				if (!params.containsKey(key)) {
					throw new RuntimeException("没有设置参数" + key + "的值");
				}
				Object value = params.get(key);
				if(value instanceof Collection){
					query.setParameterList(key, (Collection<?>) value);
				}else if(value instanceof Object[]){
					query.setParameterList(key, (Object[]) value);
				}else{
					query.setParameter(key, value);
				}
			}
		}
		return query;
	}

	@Override
	public <T> T load(Class<T> clazz, Serializable id) {
		return getHibernateTemplate().load(clazz, id);
	}
	
	private String delOrderbySQL(String queryString) {
		String result = queryString;
		int idx = queryString.indexOf("order by");
		if (idx > 0) {
			result = queryString.substring(0, idx);
		}
		return result;
	}

	@Override
	public Long getCount(String hql, HashMap<String, Object> params) {
		String newSql = delOrderbySQL(hql);
		int idx = newSql.toUpperCase().indexOf("FROM ");
		newSql = "select count(*) " + newSql.substring(idx);
		Query q = createQuery(newSql, params);
		List<?> l = q.list();
		Long lon = 0L;
		if (null != l && l.size() > 0) {
			lon = (Long) l.get(0);
		}
		return lon;
	}
	
	@Override
	public Long sqlGetCount(String sql, HashMap<String, Object> params) {
		String newSql = "select count(1) c from (" + sql + ") platform";
		Query q = createSQLQuery(newSql, params);
		List<HashMap<?,?>> l = q.list();
		Long lon = 0L;
		
		if (null != l && l.size() > 0) {
			BigInteger bi = (BigInteger) l.get(0).get("c");
			lon = bi.longValue();
		}
		return lon;
	}

	@Override
	public Long getCountByVariableParam(String hql, Object... params) {
		String newSql = delOrderbySQL(hql);
		int idx = newSql.toUpperCase().indexOf("FROM ");
		newSql = "select count(*) " + newSql.substring(idx);
		Query query = getSession().createQuery(newSql);
		if (params != null){
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		List<?> l = query.list();
		Long lon = 0L;
		if (null != l && l.size() > 0) {
			lon = (Long) l.get(0);
		}
		return lon;
	}
	
	@Override
	public Long sqlGetCountByVP(String sql, Object... params) {
		String newSql = "select count(1) c from (" + sql + ") platform";
		Query query = createSQLQuery(newSql, null);
		if (params != null){
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		List<HashMap<?,?>> l = query.list();
		Long lon = 0L;
		if (null != l && l.size() > 0) {
			BigInteger bi = (BigInteger) l.get(0).get("c");
			lon = bi.longValue();
		}
		return lon;
	}

	@Override
	public Page getPage(String hql, Integer pageIndex, Integer pageSize,
			HashMap<String, Object> params) {
		PageBean pageBean = new PageBean(pageIndex, pageSize);
		int cnt = Integer.parseInt(String.valueOf(getCount(hql, params)));
		pageBean.setCount(cnt);
		if (pageBean.getCount() == 0) {
			return new Page(new ArrayList<Object>(), pageBean);
		}
		int pages = pageBean.getPages();
		if (pages * pageBean.getPageSize() < pageBean.getCount()) {
			pages = pages + 1;
		}
		if (pageBean.getPageIndex() > pages) {
			pageBean.setPageIndex(pages);
		}
		Query query = createQuery(hql, params);
		query.setMaxResults(pageBean.getPageSize());
		query.setFirstResult(pageBean.getStartNo() - 1);
		return new Page(query.list(), pageBean);
	}
	
	@Override
	public Page sqlGetPage(String sql, Integer pageIndex, Integer pageSize,
			HashMap<String, Object> params) {
		PageBean pageBean = new PageBean(pageIndex, pageSize);
		int cnt = Integer.parseInt(String.valueOf(sqlGetCount(sql, params)));
		pageBean.setCount(cnt);
		if (pageBean.getCount() == 0) {
			return new Page(new ArrayList<Object>(), pageBean);
		}
		int pages = pageBean.getPages();
		if (pages * pageBean.getPageSize() < pageBean.getCount()) {
			pages = pages + 1;
		}
		if (pageBean.getPageIndex() > pages) {
			pageBean.setPageIndex(pages);
		}
		Query query = createSQLQuery(sql, params);
		query.setMaxResults(pageBean.getPageSize());
		query.setFirstResult(pageBean.getStartNo() - 1);
		return new Page(query.list(), pageBean);
	}

	@Override
	public Page getPageByVariableParam(String hql, Integer pageIndex, Integer pageSize,
			Object... params) {
		PageBean pageBean = new PageBean(pageIndex, pageSize);
		int cnt = Integer.parseInt(String.valueOf(getCountByVariableParam(hql, params)));
		pageBean.setCount(cnt);
		if (pageBean.getCount() == 0) {
			return new Page(new ArrayList<Object>(), pageBean);
		}
		int pages = pageBean.getPages();
		if (pages * pageBean.getPageSize() < pageBean.getCount()) {
			pages = pages + 1;
		}
		if (pageBean.getPageIndex() > pages) {
			pageBean.setPageIndex(pages);
		}
		Query query = getSession().createQuery(hql);
		if (params != null){
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		query.setMaxResults(pageBean.getPageSize());
		query.setFirstResult(pageBean.getStartNo() - 1);
		return new Page(query.list(), pageBean);
	}
	
	@Override
	public Page sqlGetPageByVP(String sql, Integer pageIndex, Integer pageSize,
			Object... params) {
		PageBean pageBean = new PageBean(pageIndex, pageSize);
		int cnt = Integer.parseInt(String.valueOf(sqlGetCountByVP(sql, params)));
		pageBean.setCount(cnt);
		if (pageBean.getCount() == 0) {
			return new Page(new ArrayList<Object>(), pageBean);
		}
		int pages = pageBean.getPages();
		if (pages * pageBean.getPageSize() < pageBean.getCount()) {
			pages = pages + 1;
		}
		if (pageBean.getPageIndex() > pages) {
			pageBean.setPageIndex(pages);
		}
		Query query = createSQLQuery(sql,null);
		if (params != null){
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		query.setMaxResults(pageBean.getPageSize());
		query.setFirstResult(pageBean.getStartNo() - 1);
		return new Page(query.list(), pageBean);
	}

}
