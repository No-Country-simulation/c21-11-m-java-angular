package com.no_country.demo.controller;

import com.no_country.demo.dto.DataResponseSubject;
import com.no_country.demo.dto.DataSubject;
import com.no_country.demo.entities.Subject;
import com.no_country.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping("/create")
    public ResponseEntity createSubject(@RequestBody DataSubject dataSubject, UriComponentsBuilder uriComponentsBuilder){
        Subject subject = subjectRepository.save(new Subject(dataSubject));

        DataResponseSubject dataResponseSubject =new DataResponseSubject(subject.getId(), subject.getSubject(),subject.getDays());

        URI url = uriComponentsBuilder.path("/subject/{id}").buildAndExpand(subject.getId()).toUri();
        return ResponseEntity.created(url).body(dataResponseSubject);
    }

    @GetMapping("/view")
    public ResponseEntity viewSubject(){

        var response = subjectRepository.findById(5L);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity viewSubjetId(@PathVariable Long  id){
        var response = subjectRepository.findById(id);
        return ResponseEntity.ok(response);
    }


}
