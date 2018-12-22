package com.example.demo.entity;

import lombok.ToString;

import javax.persistence.*;

@Entity //必加
@Table(name = "test") //如果entity类名不是数据库的名字转换驼峰式，需要添加此注解
@ToString
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "u_id")//如果entity属性名不是数据库的字段转换驼峰式，需要添加此注解
    private Integer myId;//u_id

    private String uName;//u_name

    private Integer uAge;//u_age
}
//注意
// 1.entity中驼峰式的大写字母会变小写，并用下划线连接来与数据库中字段映射，所以一定要转换正确，不然找不到
// 2.如果entity不想从数据库中字段映射转化，想自定义，可以添加@Table/@Column映射数据库中字段即可.