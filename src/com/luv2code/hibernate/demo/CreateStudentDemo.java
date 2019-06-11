package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[]args){


        //Create SessionFactory
        SessionFactory factory = new Configuration ()
                .configure ("hibernate.cfg.xml")
                .addAnnotatedClass (Student.class )
                .buildSessionFactory ();

        //Create Session
        Session session = factory.getCurrentSession ();


        try{

            //create a student object
            System.out.println ("Create new student object.........");
            Student tempStudent =new Student ("Sobz","Dlabz", "sobz@luv2code.com" );

            //start a transaction
            session.beginTransaction ();

            //save the student object
            System.out.println ("Saving the student....");
            session.save ( tempStudent );

            //commit transaction
            session.getTransaction ().commit ();
            System.out.println ("Done!!!");

        }
        finally {
            factory.close ();
        }
    }
}
