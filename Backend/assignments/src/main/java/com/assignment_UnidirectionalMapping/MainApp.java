package com.assignment_UnidirectionalMapping;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        
        // Create a user
        EntityManager em = emf.createEntityManager();
       	em.getTransaction().begin();

        User user = new User("John", 1234, "john@email.com");
        em.persist(user);

        em.getTransaction().commit();

        System.out.println("User Registered!");

        // Create a post
        em.getTransaction().begin();

        Post post = new Post(
                "My First Post",
                "This is post content",
                user
        );

        em.persist(post);

        em.getTransaction().commit();

        System.out.println("Post Created!");

        // Add a comment to a post
        em.getTransaction().begin();

        Comment comment = new Comment(
                "Nice Post!",
                post,
                user
        );

        em.persist(comment);

        em.getTransaction().commit();

        System.out.println("Comment Added!");

        // Fetch all posts by the user
        List<Post> posts = em.createQuery(
                "SELECT p FROM Post p WHERE p.author.id = :uid",
                Post.class)
                .setParameter("uid", user.getId())
                .getResultList();

        System.out.println("Posts by User:");
        for (Post p : posts) {
            System.out.println(p.getTitle());
        }

        // All the comments of a post
        List<Comment> comments = em.createQuery(
                "SELECT c FROM Comment c WHERE c.post.id = :pid",
                Comment.class)
                .setParameter("pid", post.getId())
                .getResultList();

        System.out.println("Comments on Post:");
        for (Comment c : comments) {
            System.out.println(c.getContent());
        }


        // Update a post
        em.getTransaction().begin();

        Post existingPost = em.find(Post.class, post.getId());
        existingPost.setTitle("Updated Title");
        existingPost.setUpdatedAt(LocalDateTime.now());

        em.getTransaction().commit();

        System.out.println("Post Updated!");


        //Delete a post
        em.getTransaction().begin();

        Post deletePost = em.find(Post.class, post.getId());
        em.remove(deletePost);
        em.getTransaction().commit();
        System.out.println("Post Deleted!");
        
        
        em.close();
        emf.close();
    }
}

