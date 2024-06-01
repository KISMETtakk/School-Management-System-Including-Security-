/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.model.entity.Student;

/**
 *
 * @author Student
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeLocal {

    @PersistenceContext(unitName = "ClassListEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }

    @Override
    public Student displayStudent(Long studentNum)
    {
       Query q = em.createQuery("SELECT s FROM Student s WHERE s.id = ?1 ");
       q.setParameter(1,studentNum );
       Student stu = (Student)q.getSingleResult();
       return stu;
    }
    
    

    @Override
    public Student getYoungestStudent() 
    {
       Query q = em.createQuery("SELECT s FROM Student s  WHERE s.age = (SELECT MIN(s.age) FROM Student s) " );
       Student stu = (Student)q.getSingleResult();
        return stu;
    }

    @Override
    public Double avgAgeGender(Character gender) 
    {
       Query q = em.createQuery("SELECT AVG(s.age) FROM Student s WHERE s.gender = ?1 ");
       q.setParameter(1, gender);
       Double avgFe = (Double)q.getSingleResult();
       return avgFe;
        
    }

   @Override
    public Double percentagePerGender(Character gender) {
    Query q = em.createQuery("SELECT COUNT(s) FROM Student s WHERE s.gender = ?1");
    q.setParameter(1, gender);
    Long genderCount = (Long) q.getSingleResult();
    
    q = em.createQuery("SELECT COUNT(s) FROM Student s");
    Long totalCount = (Long) q.getSingleResult();
    
    Double percentagePerGen = (genderCount.doubleValue() / totalCount.doubleValue()) * 100.0;
    return percentagePerGen;
}





    
}
