package com.example.service;

import com.example.exception.InputValidationException;
import com.example.model.ShowDetailsRequest;
import com.example.persistence.MovieRepository;
import com.example.persistence.SeatInventoryRepository;
import com.example.persistence.TheaterRepository;
import com.example.persistence.entity.Movie;
import com.example.persistence.entity.ShowDetails;
import com.example.persistence.entity.Theater;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
@Slf4j
public class SeatInventoryServiceImpl implements SeatInventoryService {

    @Autowired
    private SeatInventoryRepository showRepo;

    @Autowired
    private MovieRepository movieRepo;

    @Autowired
    private TheaterRepository theaterRepo;

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public ShowDetails createShowInventory(ShowDetailsRequest input) throws InputValidationException, ParseException {

        Optional<Movie> movie = movieRepo.findMovieByName(input.getMovieName());
        Optional<Theater> theater = theaterRepo.findTheaterByName(input.getTheaterName());
        System.out.println("Show date string from json input " +input.getShowDate());

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date showDate = sdf.parse(input.getShowDate());

        System.out.println(" In service, date object " +showDate);

        ShowDetails show = ShowDetails.builder()
                .movie_id(movie.get().getMovieId())
                .theater_id(theater.get().getTheaterId())
                .show_time(input.getShowTime())
                .show_date(showDate)
                .build();
        System.out.println(show.getShow_date());
        show = showRepo.save(show);
        log.info(show.getShow_date() + " Created show id " +show.getShowId());
        return show;
    }

    @Override
    public int updateShowInventory(ShowDetailsRequest input) throws InputValidationException {
        Optional<Theater> theater = theaterRepo.findTheaterByName(input.getTheaterName());
        Optional<Movie> movie = movieRepo.findMovieByName(input.getMovieName());

        int updatedRows = showRepo.updateShow(input.getSeatCnt(), input.getTicketPrice(), theater.get().getTheaterId(),
                            movie.get().getMovieId());
        log.info("Rows updated " + updatedRows);
        return  updatedRows;
    }


    @Override
    public List<ShowDetails> getAllShows(String theaterName, String movieName) {
        Optional<Movie> movie = movieRepo.findMovieByName(movieName);
        Optional<Theater> theater = theaterRepo.findTheaterByName(theaterName);

        List<ShowDetails> showList = showRepo.findAllShows(theater.get().getTheaterId(),
                                                            movie.get().getMovieId());
        log.info("Shows returned " +showList.size());
        return showList;
    }

}
