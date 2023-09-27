package com.jspiders.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jspiders.service.MovieService;


@Controller
public class MovieController {
	
	@Autowired
	MovieService mService;
	
	@RequestMapping("/Fetch")
	public ModelAndView fetchMovieDetails(HttpServletRequest req,HttpServletResponse res)
	{
		String result= mService.fetch();
		
		ModelAndView view=new ModelAndView();
		view.setViewName("output.jsp");
		view.addObject("output",result);

		return view;
		
	}
	
	@RequestMapping("/Update")
	public ModelAndView updateMovieDetails(HttpServletRequest req,HttpServletResponse res)
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String result= mService.update(id);
		
		ModelAndView view=new ModelAndView();
		view.setViewName("output.jsp");
		view.addObject("output",result);

		return view;
		
	}
	@RequestMapping("/Delete")
	public ModelAndView deleteMovieDetails(HttpServletRequest req,HttpServletResponse res)
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String result= mService.delete(id);
		
		ModelAndView view=new ModelAndView();
		view.setViewName("output.jsp");
		view.addObject("output",result);
		
		
		return view;
		
	}
	@RequestMapping("/Insert")
	public ModelAndView insertMovieDetails(HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("name");
		int id=Integer.parseInt(req.getParameter("id"));
		int price =Integer.parseInt(req.getParameter("price"));
		
		String result=mService.save(name,id,price);
		ModelAndView view=new ModelAndView();
		view.setViewName("output.jsp");
		view.addObject("output",result);
		return view;
		
	}
}
