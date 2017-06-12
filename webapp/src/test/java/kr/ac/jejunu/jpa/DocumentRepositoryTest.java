package kr.ac.jejunu.jpa;

import kr.ac.jejunu.model.Document;
import kr.ac.jejunu.model.Position;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.DocumentRepository;
import kr.ac.jejunu.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by 우찬 on 2017-06-08.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DocumentRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Test
    public void getDocument() throws Exception{

        long id = 1L;
        User writer = userRepository.findOne(1L);
        Position source= new Position(0, 0);
        Position destination = new Position(1, 1);

        Document document = documentRepository.findOne(id);

        assertThat(document.getId(), is(id));
        assertThat(document.getSource(), is(source));
        assertThat(document.getDestination(), is(destination));
        assertThat(document.getContent(), is("test"));
        assertThat(document.getWriter(), is(writer));
    }

    @Test
    public void getDocuemntByWriter() throws Exception{
        User user = userRepository.findOne(1L);
        List<Document> documents =  documentRepository.findAllByWriter(user);
        assertThat(documents.size(), is(1));
    }

    @Test
    public void addDocument() throws Exception{
        User user = userRepository.findOne(1L);
        Position source = new Position(1, 2);
        Position destination = new Position(3, 4);
        String content = "content";
        String title = "test";
        Document document = new Document(source, destination, user, title,content);

        documentRepository.save(document);
    }

    @Test
    public void getAllDocument() throws Exception{
        List<Document>documents = documentRepository.findAll();
        assertThat(documents.size(), is(1));
    }
}
