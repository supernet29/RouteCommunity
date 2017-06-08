package kr.ac.jejunu.jpa;

import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.UserRepository;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;

/**
 * Created by 우찬 on 2017-06-08.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void getUser() throws Exception{
        Long id = 1L;
        String name = "test";
        String password = "test1234";
        String email = "test@test.com";
        String imageUrl = null;

        User user = userRepository.findOne(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
        assertThat(user.getEmail(), is(email));
        assertThat(user.getImageUrl(), is(imageUrl));
    }

    @Test
    public void getUserWithName() throws Exception{
        Long id = 1L;
        String name = "test";
        String password = "test1234";
        String email = "test@test.com";
        String imageUrl = null;
        User user = userRepository.findByName(name);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
        assertThat(user.getEmail(), is(email));
        assertThat(user.getImageUrl(), is(imageUrl));
    }

    @Test
    public void addUser() throws Exception{
        String name = "Hello";
        String password = "1234";
        String email = "hello@test.com";
        User user = new User(null, name, password, email, null);
        userRepository.save(user);

        user = userRepository.findByName(name);
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
        assertThat(user.getEmail(), is(email));
    }
}
