package com.example.school.Controller;


import com.example.school.Medol.Teacher;
import com.example.school.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@AllArgsConstructor
public class TeacherController {


    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeacher() {
        return ResponseEntity.status(200).body(teacherService.getALLTeacher());
    }


    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher added");

    }


    @PutMapping("update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher) {

        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body("Teacher updated");

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher deleted");

    }



    @GetMapping("/get/{id}")
    public ResponseEntity getTeacherAddress(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(teacherService.getTeacherAddress(id));
    }



    @PutMapping("/{teacher_id}/assign/{course_id}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacher_id, @PathVariable Integer course_id){
        teacherService.assignTeacherToCourse(teacher_id,course_id);
        return ResponseEntity.status(200).body("DONE");


    }


    @GetMapping("/getTeacherName/{id}")
    public ResponseEntity  getTeacherName(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherName(id));
    }



}
