package com.shendyuk.cityManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "The field 'street' must not be blank.") // текст не выводится пользователю на экран
    private String street;

//    @NotNull(message = "The field 'number' must not be empty.") // текст не выводится пользователю на экран
//    @Min(value = 1, message = "The number of home must be greater than or equal '1'.") // текст не выводится пользователю на экран
    private int number;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "person_home",
            joinColumns = @JoinColumn(name = "home_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id")
    )
    private Set<Person> persons = new HashSet<>();
}
