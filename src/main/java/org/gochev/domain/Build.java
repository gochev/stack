package org.gochev.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Build extends AbstractEntity{
	private String name;
	private String content;

	@OneToMany(mappedBy="build")
	private Set<Rating> ratings = new HashSet<Rating>();
	
	@OneToMany(mappedBy="build")
	private Set<Comment> comments = new HashSet<Comment>();

	@ManyToOne
	private User user;
	
	public Set<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
