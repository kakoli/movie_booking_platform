package com.example.persistence;

import com.example.persistence.entity.ShowDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatInventoryRepository extends JpaRepository<ShowDetails, Integer> {

    @Query(value = "UPDATE SHOW_DETAILS SET seat_count = ?1, ticket_price = ?2 where movie_id = ?3 and theater_id = ?4", nativeQuery = true)
    public int updateShow(String dept, Integer empId);

}
