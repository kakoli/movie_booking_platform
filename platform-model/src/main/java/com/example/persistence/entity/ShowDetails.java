package com.example.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="SHOW_DETAILS")
public class ShowDetails {
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    //@JsonIgnore
    private Integer showId;

    private Integer movie_id;

    private Integer theater_id;

    private String show_time;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT) //"yyyy-MM-dd")
    private Date show_date;

    private Integer seat_count;

    private Float ticket_price;
}
