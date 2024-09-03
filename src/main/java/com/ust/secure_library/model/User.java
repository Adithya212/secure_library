package com.ust.secure_library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String username;
    private String password;
    private boolean subscription;
}
