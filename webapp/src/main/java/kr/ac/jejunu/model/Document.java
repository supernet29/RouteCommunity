package kr.ac.jejunu.model;

import javax.persistence.Entity;

/**
 * Created by kimwoochan on 2017-06-08.
 */
@Entity
public class Document {
    private Long id;
    private Position startPosition;
    private Position endPosition;
    private User writer;
    private String content;



}
