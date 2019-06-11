package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

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
            Student tempStudent =new Student ("Duffy","Duck", "duffy@luv2code.com" );

            //start a transaction
            session.beginTransaction ();

            //save the student object
            System.out.println ("Saving the student....");
            System.out.println (tempStudent);
            session.save ( tempStudent );

            //commit transaction
            session.getTransaction ().commit ();

            //My new code

            //find out the student's id: primary key
            System.out.println ("Saved student. Generate id: " + tempStudent.getId ());


            //now get new session and start transaction
            session = factory.getCurrentSession ();
            session.beginTransaction ();

            //retrieve student based on the id: primary key
            System.out.println ("\nGetting student with id: "+tempStudent.getId () );

            Student myStudent = session.get ( Student.class, tempStudent.getId () );
            System.out.println ("Get Complete: " +myStudent);

            //commit the transaction
            session.getTransaction ().commit ();



            System.out.println ("Done!!!");

        }
        finally {
            factory.close ();
        }
    }
}
