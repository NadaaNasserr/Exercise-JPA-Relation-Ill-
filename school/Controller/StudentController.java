package com.example.school.Controller;


import com.example.school.Medol.Student;
import com.example.school.Medol.Teacher;
import com.example.school.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {


    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents() {

        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student added");

    }


    @PutMapping("update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody @Valid Student student) {

        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("Student updated");

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted");

    }

    @PutMapping("/{student_id}/assign/{course_id}")
    public ResponseEntity assignStudentAndCourse(@PathVariable Integer student_id, @PathVariable Integer course_id){
        studentService.assignStudentAndCourse(student_id,course_id);
        return ResponseEntity.status(200).body("DONE");


    }


    @GetMapping("/getAllStudent/{course_id}")
    public ResponseEntity getAllStudent(@PathVariable Integer course_id){
        return ResponseEntity.status(200).body(studentService.getAllStudent(course_id));
    }


    @PutMapping("/change/{id}/{majer}")
    public ResponseEntity changeStudentMajor(@PathVariable Integer id, @PathVariable String majer){
        studentService.changeStudentMajor(id, majer);
        return ResponseEntity.status(200).body("Change Student Major");
    }


}
