package com.example.twentyonegame.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class RoleEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roleEntities", fetch = FetchType.LAZY)
    private List<UserEntity> users;

    @Override
    public String toString() {
        return "Role{" +
                "id: " + super.getId() + ", " +
                "name: " + name + "}";
    }
}
