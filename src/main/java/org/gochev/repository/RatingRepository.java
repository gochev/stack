package org.gochev.repository;

import org.gochev.domain.Rating;
import org.gochev.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends PagingAndSortingRepository<Rating, Long>{

}
