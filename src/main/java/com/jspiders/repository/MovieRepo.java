package com.jspiders.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.entity.Movie;


@Repository
public class MovieRepo {
    @Autowired
	Movie m;

    public void util(Movie m,int a)
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("anu");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		trans.begin();
		
		
		switch(a)
		{	
			case 1:manager.persist(m);
					break;
					
			case 2:Movie m2 = manager.find(Movie.class, m.getMovieId()); 
			
					System.out.println(m2.getMovieId()+m2.getMovieName());
					m2.setMovieName("MR PERFECT");
					System.out.println(" ----------->>>>>>>>>>>>>>>>>  UPADTED MOVIE DETAILS  <<<<<<<<<<<<<-------------");
					System.out.println(m2.getMovieId());
					System.out.println(m2.getMovieName());
					System.out.println(m2.getMoviePrice());
					manager.merge(m2);
					break;
			case 3:Query query=manager.createQuery("select m from Movie m");
					List<Movie> m3=query.getResultList();
					System.out.println();
					System.out.println("MOVIE DETAILS  !!!!!!!!!!!!!!!!");
					for(Movie mv:m3)
					{
						System.out.println();
						System.out.println(mv.getMovieId());
						System.out.println(mv.getMovieName());
						System.out.println(mv.getMoviePrice());		
						System.out.println("===============================");
					}
					System.out.println("SUCCESSFULLY FETCHED THE DETAILS");
					break;
			case 4:Movie m4 = manager.find(Movie.class, m.getMovieId()); 
					
					manager.remove(m4);
				    break;
		  }
		trans.commit();
    }
    
	public String saveData(String name, int id, int price) {
		m.setMovieId(id);
		m.setMovieName(name);
		m.setMoviePrice(price);
		util(m,1);
		
		return "MOVIE DATA SAVED SUCCESFULL";
	}
	
	public String update(int id) {
		
		m.setMovieId(id);
		util(m,2);
		return "MOVIE UPDATED SUCCESSFULL";
	}
	
	public String fetch() {
		
		util(m,3);
		return "MOVIES FETCHED SUCCESSFULL";
		
	}
	public String delete(int id) {
		m.setMovieId(id);
		util(m,4);
		
		return "MOVIE DELETED SUCCEFULL";
	}


	
	
	
	
	
}
