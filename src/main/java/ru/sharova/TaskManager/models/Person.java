package ru.sharova.TaskManager.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
/*import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;*/

@Entity
@Data
@RequiredArgsConstructor
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   /* @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")*/
    @Column(name = "name")
    private String name;
    @Column(name = "email")
   /* @NotEmpty(message = "Email should not be empty")
    @Email*/
    private String email;
    @Column(name = "password")
    private String password;
}
