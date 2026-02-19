package com.assignment_UnidirectionalMapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="uni_User")
public class User {

	@Id
	private int id;
	private String name;
	private int password;
	private String email;
	User(){}
	// One user -> many posts
    @OneToMany
    private List<Post> posts = new ArrayList<>();

    // One user -> many comments
    @OneToMany
    private List<Comment> comments = new ArrayList<>();

    public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public User(String name, int password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
