package com.example.school.Repository;


import com.example.school.Medol.Course;
import com.example.school.Medol.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {



    Course findCourseById(Integer id);






}
