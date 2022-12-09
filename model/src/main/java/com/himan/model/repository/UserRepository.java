package com.himan.model.repository;

import com.himan.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * 根据用户名称查询
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    @Transactional
    @Modifying
    @Query(value = "update hm_user set password=?1 where user_name=?2", nativeQuery = true)
    int update(String password, String userName);
}
