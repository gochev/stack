package org.gochev.repository;

import org.gochev.domain.Build;
import org.gochev.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildRepository extends PagingAndSortingRepository<Build, Long>{

		public Page<Build> findByNameLike(String namePattern, Pageable page);
}
