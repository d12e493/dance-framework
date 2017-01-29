package idv.danceframework.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import idv.danceframework.entity.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

}
