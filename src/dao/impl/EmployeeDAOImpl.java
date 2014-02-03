package dao.impl;

import dao.EmployeeDAO;
import java.util.List;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import resources.HibernateUtil;

/**
 * @author tombisnis@yahoo.com
 */
public class EmployeeDAOImpl implements EmployeeDAO{

    private Session session;
    private SessionFactory sessionFactory;
    
    public EmployeeDAOImpl(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    @Override
    public void save(Employee employee) {         
        session = sessionFactory.openSession();
        
        session.getTransaction().begin();  
        session.save(employee);
        session.getTransaction().commit();
    }

    @Override
    public void saveOrUpdate(Employee employee){
        session = sessionFactory.openSession();
        
        session.getTransaction().begin();  
        session.saveOrUpdate(employee);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Employee employee){
        session = sessionFactory.openSession();
        
        session.getTransaction().begin();  
        session.delete(employee);
        session.getTransaction().commit();
    }

    @Override
    public List<Employee> getAllEmployees(){
        session = HibernateUtil.getSessionFactory().openSession();
        return (List<Employee>) session.createCriteria(Employee.class).list();
    }
}