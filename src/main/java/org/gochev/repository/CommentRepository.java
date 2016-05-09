package org.gochev.repository;

import org.gochev.domain.Comment;
import org.gochev.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long>{

}
