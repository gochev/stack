package org.gochev;

import org.gochev.domain.Build;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BuildService {

	Page<Build> search(Pageable page);

	Page<Build> search(String buildName, Pageable page);

	Build create(Build build);

}