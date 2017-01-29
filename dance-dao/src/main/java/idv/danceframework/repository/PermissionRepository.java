package idv.danceframework.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import idv.danceframework.entity.Permission;

public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {

}
