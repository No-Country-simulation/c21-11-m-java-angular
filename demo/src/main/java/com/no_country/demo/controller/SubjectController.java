package com.no_country.demo.controller;

import com.no_country.demo.dto.DataResponseSubject;
import com.no_country.demo.dto.DataSubject;
import com.no_country.demo.dto.ResponseDTO;
import com.no_country.demo.dto.subject.CreateSubjectDTO;
import com.no_country.demo.dto.subject.GetSubjectDTO;
import com.no_country.demo.entities.Subject;
import com.no_country.demo.repository.SubjectRepository;
import com.no_country.demo.services.SubjectService;
import com.no_country.demo.util.mapper.SubjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/subject")
@AllArgsConstructor
public class SubjectController {

    private SubjectService subjectService;
    SubjectMapper subjectMapper;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createSubject(@RequestBody CreateSubjectDTO createSubjectDTO, UriComponentsBuilder uriComponentsBuilder){
        Subject subject = subjectService.crear(new Subject(createSubjectDTO));
        return ResponseEntity.ok(new ResponseDTO(
                true,
                "La asignatura se creo correctamente",
                subjectMapper.toDTO(subject)
        ));
    }
    @Operation(
            summary = "Asigna Profesor a Asignatura",
            description = "Este endpoint asigna Profesor a Asignatura"
    )
    @PostMapping("/{subjectDTO}/teachers/{teacherId}")
    public ResponseEntity<Void> assignTeacher(@PathVariable Long subjectId, @PathVariable Long teacherId) {
        subjectService.assignTeacherToSubject(subjectId, teacherId);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/view")
//    public ResponseEntity viewSubject(){
//
//        GetSubjectDTO response = subjectService.findById(5L);
//
//        return ResponseEntity.ok(response);
//    }

    @GetMapping("/view/{id}")
    public ResponseEntity<ResponseDTO> viewSubjetId(@PathVariable Long  id){
        Subject subject = subjectService.buscarPorId(id);
        GetSubjectDTO response = subjectMapper.toDTO(subject);
        return ResponseEntity.ok(new ResponseDTO(
                true,
                "se obtubo la asignatura",
                response
        ));
    }


}
