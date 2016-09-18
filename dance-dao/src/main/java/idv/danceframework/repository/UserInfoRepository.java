package idv.danceframework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import idv.danceframework.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

}
