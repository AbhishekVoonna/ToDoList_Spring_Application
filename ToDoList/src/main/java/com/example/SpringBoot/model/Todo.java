package com.example.SpringBoot.model;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Min(value=1,message="Id should be positive")
    private String Todo_ID;
    private String Todo_Description;
    private String Todo_Deadline;
}
