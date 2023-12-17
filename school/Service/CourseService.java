package com.example.school.Service;


import com.example.school.API.ApiException;
import com.example.school.Medol.Course;
import com.example.school.Medol.Teacher;
import com.example.school.Repository.CourseRepository;
import com.example.school.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class CourseService {


        private final CourseRepository courseRepository;

        public List<Course> getAllCourses(){

            return courseRepository.findAll();
        }

        public void addCourse(Course course){

            courseRepository.save(course);
        }

        public void updateCourse(Integer id,Course course){
            Course oldCourse = courseRepository.findCourseById(id);
            if(oldCourse == null){
                throw new ApiException("course id not found");
            }
            oldCourse.setName(course.getName());
            courseRepository.save(oldCourse);
        }


        public void deleteCourse(Integer id){
            Course course = courseRepository.findCourseById(id);
            if(course == null){
                throw new ApiException("course id not found");
            }
            courseRepository.delete(course);
        }




    }
