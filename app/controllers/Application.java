/* edit on 2014117 */

package controllers;

import play.*;
import play.mvc.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import models.*;

public class Application extends Controller {

	public static void index() {
		/*
		 * if (User.count() == 0) { User user = new
		 * User("TedMosby","ted@mosby.com"); user.description =
		 * "It doesn't have to make sense to make sense."; user.save(); } User
		 * demoUser = getDemoUser();
		 * 
		 * render(demoUser);
		 */
		
		List<movie_titles> movies = new ArrayList<movie_titles>();


		String csvFile = "/Users/apple/Downloads/download/movie_titles.txt";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
	 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] movieInfo = line.split(cvsSplitBy);
	 
//				System.out.println(movieInfo);
//	    		System.out.println("movie [id= " + movieInfo[0] 
//	                                 + " , year=" + movieInfo[1] +  " , title =" + movieInfo[2] +"]");
				
				movie_titles mt = new movie_titles(Integer.parseInt(movieInfo[0]),movieInfo[1],movieInfo[2]);
//				System.out.println("movies+"+mt+"\n");
				movies.add(mt);
				mt.save();
	 
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 	
	
		for (movie_titles x : movies) {
			System.out.println("Value :" + x.id + "Title" + x.title);
		}
		render(movies);
		
	}

	public static User getDemoUser() {
		return User.findByName("TedMosby");
	}
}