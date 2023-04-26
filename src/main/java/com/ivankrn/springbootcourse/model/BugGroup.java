package com.ivankrn.springbootcourse.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "bug_group")
@EqualsAndHashCode(exclude = "bugs")
public class BugGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq_gen")
    @SequenceGenerator(name = "global_seq_gen", sequenceName = "global_seq")
    private long id;
    @NotBlank
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bug> bugs = new HashSet<>();

    public void addBug(Bug bug) {
        this.bugs.add(bug);
        bug.setGroup(this);
    }
}
