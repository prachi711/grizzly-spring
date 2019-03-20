package com.cts.grizzlywebstore.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzlywebstore.bean.Login;


@Repository("loginDao")
@Transactional
public class LoginDaoImpl implements LoginDao {

	@Autowired //use already existing object created by spring
	SessionFactory sessionFactory;
	
	@Transactional(readOnly=true)
	public String validateUser(Login login) {
		// TODO Auto-generated method stub
		
		org.hibernate.Session session=sessionFactory.getCurrentSession();
		String Squery="from Login where userName=? and password=?";
		org.hibernate.query.Query<Login>query2=null;
		
		try{
			
			query2=session.createQuery(Squery);
			query2.setParameter(0,login.getUserName());
			query2.setParameter(1,login.getPassword());
			Login e=query2.getSingleResult(); //max one result
			//System.out.println(e);
			if(e!=null)
			{
				System.out.println("success");
				return "success";
				
				
			}
			else
			{
				System.out.println("errorsdfgg");
				return "fail";
				
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
		
		
		
		
	}
	
}
