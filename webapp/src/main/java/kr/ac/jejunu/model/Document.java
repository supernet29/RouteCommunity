package kr.ac.jejunu.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by kimwoochan on 2017-06-08.
 */
@Entity
public class Document implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @AttributeOverrides({
            @AttributeOverride(name="latitude", column =@Column(name="source_latitude")),
            @AttributeOverride(name="longitude", column = @Column(name = "source_longitude"))
    })
    @Embedded
    private Position source;

    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "destination_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "destination_longitude"))
    })
    @Embedded
    private Position destination;

    @ManyToOne
    @JoinColumn(name="writer")
    private User writer;
    private String title;
    private String content;

    public Document() {
    }

    public Document(Position source, Position destination, User writer, String title, String content) {
        this.source = source;
        this.destination = destination;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id) &&
                Objects.equals(source, document.source) &&
                Objects.equals(destination, document.destination) &&
                Objects.equals(writer, document.writer) &&
                Objects.equals(content, document.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, source, destination, writer, content);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Position getSource() {
        return source;
    }

    public void setSource(Position source) {
        this.source = source;
    }

    public Position getDestination() {
        return destination;
    }

    public void setDestination(Position destination) {
        this.destination = destination;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
