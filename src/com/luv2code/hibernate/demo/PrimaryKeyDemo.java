package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

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
            System.out.println ("Create 3  student object.........");
            Student tempStudent1 =new Student ("Sobonga","Blaa", "sobonga@luv2code.com" );
            Student tempStudent2 =new Student ("Soso","Dladla", "soso@luv2code.com" );
            Student tempStudent3 =new Student ("Don","Vito", "don@luv2code.com" );

            //start a transaction
            session.beginTransaction ();

            //save the student object
            System.out.println ("Saving the student....");
            session.save ( tempStudent1 );
            session.save ( tempStudent2 );
            session.save ( tempStudent3 );


            //commit transaction
            session.getTransaction ().commit ();
            System.out.println ("Done!!!");

        }
        finally {
            factory.close ();
        }
    }
}
