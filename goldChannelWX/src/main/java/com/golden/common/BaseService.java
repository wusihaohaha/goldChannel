package com.golden.common;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

//import com.whemap.common.entity.Pager;

/** 
* @description: base service
* @author webmaster@sunow.org 
* @date 2015年11月26日 下午9:39:36 
*/ 
@Service
public  interface BaseService  {
	
	public void update(String sql,Object...args) throws Exception;
	
	public void execute(String sql) throws Exception;
	
	public Object get(String sql,Object parameters[],Class<?> c) throws Exception;
	
	public List<Map<String, Object>> queryForList(String sql,Object...args) throws Exception;
	
	public List<Map<String, Object>> queryForList(String sql,Map<String,Object> paramMap) throws Exception;
	
	public List<Map<String, Object>> queryForList(String sql) throws Exception;
	
//	public void pagingQuery(Pager<?> page,String sql,Map<String,Object> parameters,RowMapper<?> mapper);
//	
//	public void pagingQuery(Pager<?> page,String sql,Object parameters[],RowMapper<?> mapper);
	
    public JdbcTemplate getJdbcTemplate() throws Exception;
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() throws Exception;
}
