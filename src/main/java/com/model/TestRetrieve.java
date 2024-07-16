
package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TestRetrieve {
  public static void main(String args[]) {
	 Transaction tr=null;
     	try(Session ses=HBUtil.getSf().openSession()){
	   tr=ses.beginTransaction();
	
	Query<Question>qry=ses.createQuery("from Question",Question.class);
	List<Question> li=qry.list();
			for(Question e:li) {
				System.out.println(e.getId()+"\t"+e.getQuestion());
						
			}
			Query<Answer>q=ses.createQuery("from Answer",Answer.class);
			List<Answer> l=q.list();
					for(Answer e:l) {
						System.out.println(e.getId()+"\t"+e.getAnswername()+"\t"+e.getPostedBy());
								
					}
	
	
			tr.commit();
			ses.close();
}
   catch(Exception e) {
	 e.printStackTrace();}
}
}
