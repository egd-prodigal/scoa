package io.github.egd.prodigal.repository.entity;

import io.github.egd.prodigal.model.domain.People;

/**
 * 阵营里的人实体类，因此此处继承People
 */
public class CampPO extends People {

    // 角色，lord（主公）或者general（将领）
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
