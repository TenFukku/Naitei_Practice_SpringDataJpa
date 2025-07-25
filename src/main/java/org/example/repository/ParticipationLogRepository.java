package org.example.repository;

import org.example.entity.Campaign;
import org.example.entity.ParticipationLog;
import org.example.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipationLogRepository extends JpaRepository<ParticipationLog, Long> {

    List<ParticipationLog> findByVolunteer(Volunteer volunteer);

    List<ParticipationLog> findByCampaign(Campaign campaign);

    List<ParticipationLog> findByRole(String role);

    ParticipationLog findByVolunteerAndCampaign(Volunteer volunteer, Campaign campaign);

    @Query("SELECT COUNT(pl) FROM ParticipationLog pl" +
            "WHERE pl.campaign.id = :campaign_id")
    Long countVolunteersByCampaign(@Param("campaign_id") Long campaign_id);
}