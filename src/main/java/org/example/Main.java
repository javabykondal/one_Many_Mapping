package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import  java.util.*;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {


        Transaction tx=null;
        try{

            Configuration cf=new Configuration();
            Properties ps=new Properties();
            ps.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
            ps.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernate");
            ps.put(Environment.USER,"root");
            ps.put(Environment.PASS,"kondalu309");
            ps.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
            ps.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
            ps.put(Environment.SHOW_SQL,"true");
            ps.put(Environment.HBM2DDL_AUTO,"update");
            cf.setProperties(ps);
            cf.addAnnotatedClass(Accounts.class);
            cf.addAnnotatedClass(Customer.class);
            StandardServiceRegistryBuilder sc=new StandardServiceRegistryBuilder();
            ServiceRegistry sr=sc.applySettings(cf.getProperties()).build();
            SessionFactory sessionFactory= cf.buildSessionFactory(sr);
            Session session=sessionFactory.openSession();
            tx=session.beginTransaction();
            Accounts ac=session.load(Accounts.class,6);
            session.delete(ac);

//            Customer cs=session.load(Customer.class,2);
//            session.remove(cs);
//            Accounts ac=session.load(Accounts.class,1);
//            Customer cs=ac.getCustomer();

//            Customer cs=session.load(Customer.class,1);
//            System.out.println(cs);
//            Set<Accounts> sm=cs.getAccountsSet();
//            sm.forEach(my-> System.out.println(my));

//            Accounts ac2=new Accounts("ban","kondalu98@gamail.com","ts");
//            session.save(ac2);
//            ac2.setCustomer(cs);


//            Customer customer=new Customer("yess","kondau309@gmail.com",773189819);
//            session.save(customer);
//            Accounts accounts=new Accounts("saving","kondalu@gmail.com","AP");
//            session.save(accounts);
//            accounts.setCustomer(customer);
//            Accounts accounts2=new Accounts("default","kondalu@gmail.com","AP");
//            session.save(accounts2);
//            accounts2.setCustomer(customer);
//            tx.commit();session.close();



        }
        catch (Exception ex)
        {
            tx.rollback();
            ex.printStackTrace();
        }


    }
}