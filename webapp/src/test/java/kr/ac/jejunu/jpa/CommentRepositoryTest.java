package kr.ac.jejunu.jpa;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.Document;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.CommentRepository;
import kr.ac.jejunu.repository.DocumentRepository;
import kr.ac.jejunu.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by kimwoochan on 2017-06-09.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DocumentRepository documentRepository;

    @Test
    public void getComment() throws Exception{
        User user = userRepository.findOne(1L);
        Document document = documentRepository.findOne(1L);
        long id = 1L;
        String content = "test";

        Comment comment = commentRepository.findOne(id);

        assertThat(comment.getId(), is(id));
        assertThat(comment.getDocument(), is(document));
        assertThat(comment.getContent(), is(content));
        assertThat(comment.getWriter(), is(user));
    }

    @Test
    public void addComment() throws Exception{
        User user = userRepository.findOne(1L);
        Document document = documentRepository.findOne(1L);
        String content = "Hello1234";

        Comment comment = new Comment(document, user, content);

        commentRepository.save(comment);
    }

    @Test
    public void getCommentsByDocument() {
        User user = userRepository.findOne(1L);
        Document document = documentRepository.findOne(1L);
        List<Comment> comments = commentRepository.findByDocument(document);
        assertThat(comments.size(), is(1));
    }
}
