/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface StudentDao {
    public List<Student_BTTH2>getAllStudents();

    public Student_BTTH2 getStudent(int rollNo);

    public void updateStudent(Student_BTTH2 student);

    public void deleteStudent(Student_BTTH2 student);
}
