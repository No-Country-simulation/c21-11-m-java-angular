package com.no_country.demo.controller;
import com.no_country.demo.dto.student.CreateStudentDTO;
import com.no_country.demo.dto.student.UpdateStudentDTO;
import com.no_country.demo.entities.Student;
import com.no_country.demo.services.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

//     CREATE
    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@Valid @RequestBody CreateStudentDTO createStudentDTO) {
        studentService.createStudent(createStudentDTO);
        return ResponseEntity.ok("el usuario se creo correctamente");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }


    @PatchMapping("/update/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody UpdateStudentDTO updateStudentDTO) {
        return studentService.updateStudent(id, updateStudentDTO);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
