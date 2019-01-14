package com.biz.MavenCBT.DB;

import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.biz.MavenCBT.DAO.CBTDao;
import com.biz.MavenCBT.vo.CBTVO;

public class Factory {

	SqlSessionFactory sessionFactory;
	
	public SqlSessionFactory getSessionFactory() {
		return this.sessionFactory ;
	}
	
	public Factory() {
		// TODO Auto-generated constructor stub
		Properties props = new Properties();

		props.put("DRIVER",DBContract.ORACLE.Driver);
		props.put("URL",DBContract.ORACLE.url);
		props.put("USER", DBContract.ORACLE.user);
		props.put("PASSWORD",DBContract.ORACLE.password);
		
		DataSourceFactory dataSourceFactory 
				= new CBTDataSourceFactory();
		dataSourceFactory.setProperties(props);
		
		DataSource dataSource = dataSourceFactory.getDataSource();
				
		TransactionFactory transactionFactory 
				= new JdbcTransactionFactory();
		
		Environment environment 
			= new Environment("CBTEnv",transactionFactory,dataSource);
		
		Configuration config = new Configuration(environment);
		
		config.addMapper(CBTDao.class);
	
				
		this.sessionFactory 
			= new SqlSessionFactoryBuilder().build(config);
	
	}
	
public List<CBTVO> CBTAll(){
		
		SqlSession session=this.sessionFactory.openSession();
		CBTDao Dao=session.getMapper(CBTDao.class);
		
		List<CBTVO> cbtList=Dao.selectAll();
		
	
		return cbtList;
	}

	public CBTVO findById(long cb_id) {
	
		SqlSession session=this.sessionFactory.openSession();
		CBTDao Dao=session.getMapper(CBTDao.class);
	
		CBTVO vo = Dao.findById(cb_id);
	
		return vo;
	
	}	
	
	public int insert(CBTVO vo) {
		
		SqlSession session=this.sessionFactory.openSession();
		CBTDao Dao=session.getMapper(CBTDao.class);
		
		int ret = Dao.insert(vo);
		session.commit();
		session.close();
		return ret;
	}
	
	
	public int update(CBTVO vo) {
		
		SqlSession session=this.sessionFactory.openSession();
		CBTDao Dao=session.getMapper(CBTDao.class);
		
		int ret = Dao.update(vo);
		session.commit();
		session.close();
		return ret;
	}
	
	public int delete(long cb_id) {
		
		SqlSession session=this.sessionFactory.openSession();
		CBTDao Dao=session.getMapper(CBTDao.class);
		
		int ret = Dao.delete(cb_id);
		session.commit();
		session.close();
		return ret;
		
	}
	
	
	
	
	

}
