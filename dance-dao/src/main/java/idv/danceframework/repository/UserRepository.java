package idv.danceframework.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import idv.danceframework.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
