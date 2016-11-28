package models;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;

import play.data.validation.*;
import play.db.jpa.*;

@Entity
public class User extends GenericModel {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    public String id;

    @Required
    public String name;

    @Required
    @MaxSize(value=255, message = "email.maxsize")
    @play.data.validation.Email

    public String email;   

    public String description;
    
    public User(String name, String email) {
      	this.name = name;
        this.email = email;
        }
    
    public static User findByName(String name) {
        return find("byName", name).first();
        }

	@Override
	public String toString() {
		return "Hello, I am " + name + ". My ID is " + id + ", my email is " + email
				+ " and my description: " + description;
	}
    
}