package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.Document;
import kr.ac.jejunu.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByDocument(Document document);
    List<Comment> findByWriter(User writer);
}
