//package com.golden.common;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Service;
//
//import com.whemap.common.dao.BaseDao;
//import com.whemap.common.entity.Pager;
//import com.whemap.common.service.BaseService;
//
//@Service
//public  class BaseServiceImpl  implements BaseService  {
//	
//	
//	@Resource
//	private BaseDao baseDao;
//	
//	@Override
//	public void update(String sql, Object... args) throws Exception {
//		// TODO Auto-generated method stub
//		baseDao.update(sql, args);
//	}
//
//	@Override
//	public void execute(String sql) throws Exception{
//		baseDao.equals(sql);
//	}
//
//	@Override
//	public List<Map<String, Object>> queryForList(String sql, Object... args) throws Exception {
//		return baseDao.queryForList(sql, args);
//	}
//
//
//	@Override
//	public List<Map<String, Object>> queryForList(String sql) throws Exception {
//		// TODO Auto-generated method stub
//		return baseDao.queryForList(sql);
//	}
//
//	@Override
//	public List<Map<String, Object>> queryForList(String sql,
//			Map<String, Object> paramMap) throws Exception {
//		// TODO Auto-generated method stub
//		return baseDao.queryForList(sql, paramMap);
//	}
//
//	@Override
//	public JdbcTemplate getJdbcTemplate() throws Exception {
//		// TODO Auto-generated method stub
//		return baseDao.getJdbcTemplate();
//	}
//
//	@Override
//	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate()
//			throws Exception {
//		// TODO Auto-generated method stub
//		return baseDao.getNamedParameterJdbcTemplate();
//	}
//
//	@Override
//	public void pagingQuery(Pager<?> page, String sql,
//			Map<String, Object> parameters, RowMapper<?> mapper) {
//		// TODO Auto-generated method stub
//		baseDao.pagingQuery(page, sql, parameters, mapper);
//		
//	}
//
//	@Override
//	public void pagingQuery(Pager<?> page, String sql, Object[] parameters,
//			RowMapper<?> mapper) {
//		// TODO Auto-generated method stub
//		baseDao.pagingQuery(page, sql, parameters, mapper);
//	}
//
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@Override
//	public Object get(String sql,Object parameters[],Class<?> c) throws Exception {
//		// TODO Auto-generated method stub
//		Object o=null;
//		try {
//			o=getJdbcTemplate().queryForObject(sql,parameters,new BeanPropertyRowMapper(c));
//		} catch (EmptyResultDataAccessException  e) {
//			return null;
//			// TODO: handle exception
//		}
//		return o;
//	}
//
//
//
//}
