package org.gochev.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Comment extends AbstractEntity{
	
	private String content;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Build build;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
