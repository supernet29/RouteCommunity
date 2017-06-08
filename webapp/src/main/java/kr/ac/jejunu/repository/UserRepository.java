package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 우찬 on 2017-06-08.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByName(String name);
}
