package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    private int id;
    private String name;
    private int age;
    private int cid;
    private String cname;
}
