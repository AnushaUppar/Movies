package com.jspiders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jspiders.repository.MovieRepo;

@Service
public class MovieService {
	
	@Autowired
	MovieRepo repo;

	public String save(String name, int id, int price) {
		
		String res = repo.saveData(name,id,price);
		return res;
	}


	public String delete(int id) {
		
		String res = repo.delete(id);
		return res;
	}


	public String update(int id) {
		String res = repo.update(id);
		return res;
	}


	public String fetch() {
		String res = repo.fetch();
		return res;
	}

	
	
	
}
