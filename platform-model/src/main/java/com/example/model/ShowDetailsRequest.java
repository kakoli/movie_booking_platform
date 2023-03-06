package com.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowDetailsRequest {

    @JsonProperty("movie_name")
    private String movieName;

    @JsonProperty("theater_name")
    private String theaterName;

    @JsonProperty("show")
    private String show;

    @JsonProperty("show_date")
    private String showDate;

    @JsonProperty("seat_cnt")
    private Integer seatCnt;

    @JsonProperty("ticket_price")
    private Float ticketPrice;

}
