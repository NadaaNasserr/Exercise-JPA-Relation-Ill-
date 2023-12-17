package com.example.school.Service;


import com.example.school.API.ApiException;
import com.example.school.Medol.Course;
import com.example.school.Medol.Student;
import com.example.school.Medol.Teacher;
import com.example.school.Repository.CourseRepository;
import com.example.school.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {


    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseService courseService;



    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
     studentRepository.save(student);

    }

    public void updateStudent(Integer id, Student student){

        Student student1 = studentRepository.findStudentById(id);

        if(student==null){
            throw new ApiException("student id not found");
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setMajor(student.getMajor());

        studentRepository.save(student1);

    }
    public void deleteStudent(Integer id){
        Student student=studentRepository.findStudentById(id);
        if(student==null){
            throw new ApiException("student id not found");
        }
        studentRepository.delete(student);
    }

    public void assignStudentAndCourse(Integer student_id , Integer course_id){
        Student student=studentRepository.findStudentById(student_id);
        Course course=courseRepository.findCourseById(course_id);


        if(course==null || student==null){
            throw new ApiException("course id or student id  not found");
        }
        course.getStudent().add(student);
        student.getCourses().add(course);


        studentRepository.save(student);
        courseRepository.save(course);
    }


    public void changeStudentMajor(Integer id, String major){

        Student student = studentRepository.findStudentById(id);

        if(student==null){
            throw new ApiException("student id  not found");
        }

        for (Course course:student.getCourses()) {
            course.getStudent().remove(student);
            courseRepository.save(course);
        }
        student.setCourses(null);
        student.setMajor(major);
        studentRepository.save(student);
        }




    public List<Course> getAllStudent(Integer course_id){
        List<Course> studentList = new ArrayList<>();
        Course course=courseRepository.findCourseById(course_id);
        if(course==null){
            throw new ApiException("course id  not found");
        }
        for (int i = 0; i <courseService.getAllCourses().size() ; i++) {
            if(courseService.getAllCourses().get(i).getId().equals(course_id)){
                studentList.add(courseService.getAllCourses().get(i));
            }

        }
      return studentList;
    }


}
