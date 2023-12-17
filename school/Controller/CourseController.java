package com.example.school.Controller;



import com.example.school.Medol.Course;
import com.example.school.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {


    private final CourseService courseService;



    @GetMapping("/get")
    public ResponseEntity getAllCourses(){
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }
    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody@Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("course added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id,@RequestBody@Valid Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body("course updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("course deleted!");
    }




}
