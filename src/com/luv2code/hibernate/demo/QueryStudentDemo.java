package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[]args){


        //Create SessionFactory
        SessionFactory factory = new Configuration ()
                .configure ("hibernate.cfg.xml")
                .addAnnotatedClass (Student.class )
                .buildSessionFactory ();

        //Create Session
        Session session = factory.getCurrentSession ();


        try{


            //start a transaction
            session.beginTransaction ();

            //query students
            List<Student> theStudent = session.createQuery ( "from Student" ).list ();

            //display the students
            displayStudents ( theStudent );

            //query students: lastName='Doe'
            theStudent = session.createQuery ( "from Student s where s.lastName='Vito'" ).list ();

            //display the student
            System.out.println ("\n\nStudents who have lastName 'Doe'");
            displayStudents ( theStudent );


            //query students: lastName='Vito' OR firstName='Duffy'
            theStudent= session.createQuery ( "from Student s where s.lastName= 'Vito' or s.firstName='Soso' " ).list ();

            System.out.println ("\n\nquery students: lastName='Vito' OR firstName='Duffy'");
            displayStudents ( theStudent );

            //query students where email LIKE '%luv2code.com'
            theStudent=session.createQuery ( "from Student s where s.email like '%luv2code.com'" ).list ();

            System.out.println ("\n\nquery students where email LIKE '%luv2code.com'");
            displayStudents ( theStudent );

            //commit transaction
            session.getTransaction ().commit ();
            System.out.println ("Done!!!");

        }
        finally {
            factory.close ();
        }
    }

    private static void displayStudents(List<Student> theStudent) {
        for(Student tempStudent : theStudent){
            System.out.println (tempStudent);
        }
    }
}
