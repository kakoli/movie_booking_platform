package com.example.persistence;

import com.example.persistence.entity.ShowDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SeatInventoryRepository extends JpaRepository<ShowDetails, Integer> {

    @Query(value = "select * from SHOW_DETAILS s where s.theater_id = ?1 and s.movie_id = ?2", nativeQuery = true)
    public List<ShowDetails> findAllShows(int theaterId, int movieId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE SHOW_DETAILS s SET s.seat_count = ?1, s.ticket_price = ?2 where s.theater_id = ?3 and s.movie_id = ?4", nativeQuery = true)
    public int updateShow(int seat_num, float price, int theaterId, int movieId);

}
