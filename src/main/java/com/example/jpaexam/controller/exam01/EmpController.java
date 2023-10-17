package com.example.jpaexam.controller.exam01;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.model.Emp;
import com.example.jpaexam.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.controller.exam01
 * fileName : EmpController
 * author : GGG
 * date : 2023-10-16
 * description : 회원 컨트롤러
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-16         GGG          최초 생성
 */
@RestController
@Slf4j
@RequestMapping("/exam01")
public class EmpController {
    @Autowired
    EmpService empService;

    @GetMapping("/emp")
    public ResponseEntity<Object> getEmpAll() {
        try {
            List<Emp> list = empService.findAll();
            if (list != null) {
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/emp/{eno}")
    public ResponseEntity<Object> getEmpId(@PathVariable int eno) {
        try {
            Optional<Emp> optionalEmp = empService.findById(eno);
            if (optionalEmp.isEmpty() == false) {
                return new ResponseEntity<>(optionalEmp, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }


        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/emp")
    public ResponseEntity<Object> createEmp(@RequestBody Emp emp) {
        try {
//          jpa 서비스 저장 함수 호출
            Emp emp2 = empService.save(emp);
            return new ResponseEntity<>(emp2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/emp/edit/{eno}")
    public ResponseEntity<Object> updateEmp(@PathVariable int eno,
                                            @RequestBody Emp emp){
        try {
//          jpa 서비스 저장 함수 호출
            Emp emp2 = empService.save(emp);
            return new ResponseEntity<>(emp2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}