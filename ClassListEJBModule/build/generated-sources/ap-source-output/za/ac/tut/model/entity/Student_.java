package za.ac.tut.model.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-25T02:40:06")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, byte[]> image;
    public static volatile SingularAttribute<Student, Character> gender;
    public static volatile SingularAttribute<Student, String> surname;
    public static volatile SingularAttribute<Student, String[]> subjects;
    public static volatile SingularAttribute<Student, String> name;
    public static volatile SingularAttribute<Student, Long> id;
    public static volatile SingularAttribute<Student, Date> creationDate;
    public static volatile SingularAttribute<Student, Integer> age;

}