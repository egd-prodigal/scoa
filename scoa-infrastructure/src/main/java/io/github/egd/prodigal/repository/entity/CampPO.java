package io.github.egd.prodigal.repository.entity;

import io.github.egd.prodigal.model.domain.People;

public class CampPO extends People {

    // 角色，lord或者general
    private String role;

    // 阵营名称，取lord的姓+名
    private String name;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
