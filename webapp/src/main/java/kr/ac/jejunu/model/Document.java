package kr.ac.jejunu.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kimwoochan on 2017-06-08.
 */
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double startLatitude;
    private double startLongitude;

    private double endLatitude;
    private double endLongitude;

    private User writer;
    private String content;





}
