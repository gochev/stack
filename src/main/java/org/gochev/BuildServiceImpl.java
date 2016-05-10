package org.gochev;

import org.gochev.domain.Build;
import org.gochev.repository.BuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuildServiceImpl implements BuildService {
	
	@Autowired
	private BuildRepository buildRepository;
	
	/* (non-Javadoc)
	 * @see org.gochev.BuildService#search(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Build> search(Pageable page){
		return buildRepository.findAll(page);
	}
	/* (non-Javadoc)
	 * @see org.gochev.BuildService#search(java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Build> search(String buildName, Pageable page){
		return buildRepository.findByNameLike("%" + buildName + "%", page);
	}
	/* (non-Javadoc)
	 * @see org.gochev.BuildService#create(org.gochev.domain.Build)
	 */
	@Override
	public Build create(Build build){
		return buildRepository.save(build);
	}
}
