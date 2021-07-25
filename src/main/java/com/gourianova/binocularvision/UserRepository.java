package com.gourianova.binocularvision;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Integer> {

    @Query("SELECT user FROM User user WHERE user.login=?1")
    Optional<User> findUsersByEmail(String email);

    @Query(value = "SELECT * FROM User",
            nativeQuery = true)
    List<User> findAllByIdExists();

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id = ?1")
    int  deleteUserById(Integer id);
}

