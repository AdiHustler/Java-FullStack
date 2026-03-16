package com.prac;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

public class BlogService {

    private EntityManager em;

    public BlogService(EntityManager em) {
        this.em = em;
    }

 
    public void registerUser(String name, String password, String email) {
        em.getTransaction().begin();

        User u = new User();
        u.setName(name);
        u.setPassword(password);
        u.setEmail(email);

        em.persist(u);
        em.getTransaction().commit();
    }

   
    public void createPost(Long userId, String title, String content) {
        em.getTransaction().begin();

        User user = em.find(User.class, userId);

        Post p = new Post();
        p.setTitle(title);
        p.setContent(content);
        p.setCreatedAt(LocalDateTime.now());
        p.setUpdatedAt(LocalDateTime.now());
        p.setAuthor(user);

        em.persist(p);
        em.getTransaction().commit();
    }

    
    public void updatePost(Long postId, String content) {
        em.getTransaction().begin();

        Post p = em.find(Post.class, postId);
        p.setContent(content);
        p.setUpdatedAt(LocalDateTime.now());

        em.getTransaction().commit();
    }

    
    public void deletePost(Long postId) {
        em.getTransaction().begin();

        Post p = em.find(Post.class, postId);
        em.remove(p);

        em.getTransaction().commit();
    }

    
    public void addComment(Long userId, Long postId, String content) {
        em.getTransaction().begin();

        User user = em.find(User.class, userId);
        Post post = em.find(Post.class, postId);

        Comment c = new Comment();
        c.setContent(content);
        c.setCreatedAt(LocalDateTime.now());
        c.setAuthor(user);
        c.setPost(post);

        em.persist(c);
        em.getTransaction().commit();
    }

 
    public List<Post> getPostsByUser(Long userId) {
        return em.createQuery(
                "SELECT p FROM Post p WHERE p.author.id = :uid", Post.class)
                .setParameter("uid", userId)
                .getResultList();
    }

    
    public List<Comment> getCommentsByPost(Long postId) {
        return em.createQuery(
                "SELECT c FROM Comment c WHERE c.post.id = :pid", Comment.class)
                .setParameter("pid", postId)
                .getResultList();
    }

    
    public List<Comment> getCommentsByUser(Long userId) {
        return em.createQuery(
                "SELECT c FROM Comment c WHERE c.author.id = :uid", Comment.class)
                .setParameter("uid", userId)
                .getResultList();
    }
}