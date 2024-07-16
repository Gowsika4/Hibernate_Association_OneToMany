package com.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class Test {
     public static void main(String args[])
     
     {
    	 Transaction tr=null;
    	 try(Session ses=HBUtil.getSf().openSession()){
    		 tr=ses.beginTransaction();
    		 Question q=new Question();
    		 q.setQuestion("What is hibernate?");
    		 Question q2=new Question();
    		 q2.setQuestion("What is Entity class?");
    		 
    		 Answer a1=new Answer(101,"HB is a ORM.","Ramesh");
    		 Answer a2=new Answer(102,"Hb implements JPA.","Sumesh");
    		 Answer b1=new Answer(201,"Entity class is a simple java classs","Gowsii");
    		 Answer b2=new Answer(202,"POJO classes are caled Entity class","Karishma");
    		 List<Answer> l1=new ArrayList<Answer>();
    		 l1.add(a1);
    		 l1.add(a2);
    		 List<Answer> l2=new ArrayList<Answer>();
    		 l2.add(b1);
    		 l2.add(b2);
       		 q.setAnswers(l1);
    		 q2.setAnswers(l2);
    		 ses.merge(q);
    		 ses.merge(q2);
    		 tr.commit();
    		 ses.close();
    		 
    		 
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
     }
}