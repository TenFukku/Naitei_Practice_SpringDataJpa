package org.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "participation_logs")
public class ParticipationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "volunteer")
    private Volunteer volunteer;

    @Column(name = "campaign")
    private Campaign campaign;

    @Column(name = "role")
    private String role;

    @Column(name = "joined_date")
    private Date joinedDate;

    @Column(name = "days_participated")
    private int daysParticipated;
}