package com.assignment_13Feb2026;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        StudentDao dao = new StudentDao();

        // Create AadharCard
        AadharCard card = new AadharCard();
        card.setAadharId(1);
        card.setAadharNumber(1234567890L);
        card.setAddress("Delhi");
        card.setIssueDate(new Date());
        dao.saveAadharcard(card);

        // Create HostelRoom
        HostelRoom room = new HostelRoom();
        room.setRoomNumber(101);   
        room.setBlockName("Block A");
        room.setFloorNumber(1);
        dao.saveHostelRoom(room);

        // Create Student
        Student student = new Student();
        student.setStudentId(1);
        student.setName("Rahul");
        student.setEmail("rahul@email.com");
        student.setBranch("CSE");
        student.setAc(card);
        student.setHr(room);

        dao.saveStudent(student);

        // Fetch Student details
        Student fetched = dao.getStudent(student.getStudentId());

        if (fetched != null) {
            System.out.println("Student Details: ");
            System.out.println("ID: " + fetched.getStudentId());
            System.out.println("Name: " + fetched.getName());
            System.out.println("Email: " + fetched.getEmail());
            System.out.println("Branch: " + fetched.getBranch());

            System.out.println("\n Aadhar Details: ");
            System.out.println("Aadhar Number: " +
                    fetched.getAc().getAadharNumber());
            System.out.println("Address: " +
                    fetched.getAc().getAddress());
            System.out.println("Issue Date: " +
                    fetched.getAc().getIssueDate());

            System.out.println("\n Hostel Details: ");
            System.out.println("Room Number: " +
                    fetched.getHr().getRoomNumber());
            System.out.println("Block Name: " +
                    fetched.getHr().getBlockName());
            System.out.println("Floor Number: " +
                    fetched.getHr().getFloorNumber());
        }

        // Delete Student
        dao.deleteStudent(student.getStudentId());
    }
}
