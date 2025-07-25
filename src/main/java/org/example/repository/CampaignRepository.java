package org.example.repository;

import org.example.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    List<Campaign> findByNameContaining(String name);

    @Query("SELECT c FROM Campaign c" +
    "WHERE CURRENT_DATE BETWEEN c.startDate AND c.endDate")
    List<Campaign> findActiveCampaigns();

    List<Campaign> findByLocation(String location);

    List<Campaign> findByStartDateBetween(Date startDate, Date endDate);
}