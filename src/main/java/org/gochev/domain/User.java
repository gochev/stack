package org.gochev.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class User extends AbstractEntity {

	private String email;

	private String fullName;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private Set<Comment> comments = new HashSet<Comment>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private Set<Rating> ratings = new HashSet<Rating>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private Set<Build> builds = new HashSet<Build>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
}
