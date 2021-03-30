package com.leekoko.block.entity;

import lombok.Data;

//@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;

    public void setId(Long id) {
        this.id = id;
    }
}
