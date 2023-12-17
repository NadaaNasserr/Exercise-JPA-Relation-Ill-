package com.example.school.Repository;


import com.example.school.Medol.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findStudentById(Integer id);

//    @Query("select s from Student s where s.courses=?1")
//    List<Student> get(Integer id);
//
//    List<Student> findAllById(Integer id);
//
//    Student findByCourses(Integer id);

   // List<Student> findAllById(Integer id);

}
