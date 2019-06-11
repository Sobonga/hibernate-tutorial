package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[]args){


        //Create SessionFactory
        SessionFactory factory = new Configuration ()
                .configure ("hibernate.cfg.xml")
                .addAnnotatedClass (Student.class )
                .buildSessionFactory ();

        //Create Session
        Session session = factory.getCurrentSession ();


        try{

            int studentId = 3000;

            //now get a new session and start transaction
            session = factory.getCurrentSession ();
            session.beginTransaction ();


            //retrieve student based on the id: primary key
            System.out.println ("\nGetting student with id: "+studentId );

            Student myStudent = session.get ( Student.class, studentId );

            System.out.println ("Update Student.......... " +myStudent);
            myStudent.setFirstName ( "Scooby" );

            //commit the transaction
            session.getTransaction ().commit ();


            //New Code
            session = factory.getCurrentSession ();
            session.beginTransaction ();


            //update email for all students

            System.out.println ("update email for all students");
            session.createQuery ( "update Student set email='foo@gmail.com'" )
                    .executeUpdate ();




            //commit the transaction
            session.getTransaction ().commit ();



            System.out.println ("Done!!!");

        }
        finally {
            factory.close ();
        }
    }
}
