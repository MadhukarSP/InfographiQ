package models;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;

import play.data.validation.*;
import play.db.jpa.*;

@Entity
public class movie_titles extends GenericModel {
	
    public movie_titles(int id, String year, String title) {
//		super();
		this.id = id;
		this.year = year;
		this.title = title;
	}

	@Id
    public int id;

    public String year;

    public String title;   

    
    public static List<movie_titles> findAllRecords(){
  
    	return movie_titles.findAll();
    }
    
	@Override
	public String toString() {
		return "Movie Id is " + id + ", movie year of release is " + year
				+ " and movie title is " + title;
	}
    
}