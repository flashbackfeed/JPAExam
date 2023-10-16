package com.example.jpaexam.model;

import lombok.*;

import javax.persistence.*;

/**
 * packageName : com.example.jpaexam.model
 * fileName : Emp
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
@Entity
@SequenceGenerator(
        name = "SQ_EMP_GENERATOR"
        , sequenceName = "SQ_EMP"
        , initialValue = 1
        , allocationSize = 1)
@Table(name = "TB_EMP")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Emp extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_EMP_GENERATOR")
    @Column(columnDefinition = "NUMBER")
    private Integer eno;
    @Column(columnDefinition = "VARCHAR2(255)")
    private String ename;
    @Column(columnDefinition = "VARCHAR2(255)")
    private String job;
    @Column(columnDefinition = "NUMBER")
    private Integer manager;
    @Column(columnDefinition = "VARCHAR2(255)")
    private String hiredate;
    @Column(columnDefinition = "NUMBER")
    private Integer salary;
    @Column(columnDefinition = "NUMBER")
    private Integer commission;
    @Column(columnDefinition = "NUMBER")
    private Integer dno;

}
