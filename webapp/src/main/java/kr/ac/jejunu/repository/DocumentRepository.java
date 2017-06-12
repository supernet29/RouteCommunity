package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.Document;
import kr.ac.jejunu.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.print.Doc;
import java.util.List;

/**
 * Created by 우찬 on 2017-06-08.
 */
public interface DocumentRepository extends CrudRepository<Document, Long>{
    List<Document> findAllByWriter(User writer);
    List<Document> findAll();
}
