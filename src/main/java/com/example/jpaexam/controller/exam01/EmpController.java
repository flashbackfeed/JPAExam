package com.example.jpaexam.controller.exam01;

import com.example.jpaexam.model.Emp;
import com.example.jpaexam.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName : com.example.jpaexam.controller.exam01
 * fileName : EmpController
 * author : GGG
 * date : 2023-10-16
 * description :
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
    public ResponseEntity<Object> getEmpAll(){
        try {
            List<Emp> list = empService.findAll();
            if (list != null){
                return new ResponseEntity<>(list, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
