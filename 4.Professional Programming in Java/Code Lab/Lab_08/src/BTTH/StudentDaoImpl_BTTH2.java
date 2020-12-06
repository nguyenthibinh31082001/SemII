/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class StudentDaoImpl_BTTH2 implements StudentDao{
    List<Student_BTTH2>students;
    
    public StudentDaoImpl_BTTH2() {
        students = new ArrayList<Student_BTTH2>();
        Student_BTTH2 student1 = new Student_BTTH2("Robert", 0);
        Student_BTTH2 student2 = new Student_BTTH2("John", 1);
        students.add(student1);
        students.add(student2);
    }
    
    @Override
    public void deleteStudent(Student_BTTH2 student) {
        students.remove(student.getRollNo());
        System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
    }

    @Override
    public List<Student_BTTH2> getAllStudents() {
        return students;
    }

    @Override
    public Student_BTTH2 getStudent(int rollNo) {
        return students.get(rollNo);
    }

    @Override
    public void updateStudent(Student_BTTH2 student) {
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
    }
    
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl_BTTH2();

        for (Student_BTTH2 student : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : "
            + student.getName() + " ]");
        }

        Student_BTTH2 student = studentDao.getAllStudents().get(0);
        student.setName("Michael");
        studentDao.updateStudent(student);

        studentDao.getStudent(0);
        System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " +
        student.getName() + " ]");
    }
}
