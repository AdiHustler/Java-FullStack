package com.prac;

import javax.persistence.*;


public class main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-unit");
        EntityManager em = emf.createEntityManager();

        User us = new User();
        Post ps = new Post();
        Comment cs = new Comment();

        em.close();
        emf.close();
    }
}