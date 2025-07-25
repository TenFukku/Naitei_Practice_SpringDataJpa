package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "skill_levels")
public class SkillLevel {
    public enum Level{
        BEGINNER, INTERMEDIATE, ADVANCED
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "volunteer")
    private Volunteer volunteer;

    @Column(name = "skill")
    private Skill skill;

    @Column(name = "level")
    private Level level;
}