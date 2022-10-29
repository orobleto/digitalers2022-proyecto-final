package com.educaciontit.digitalers.dtos.repositories;

import java.util.List;
import java.util.Optional;

public interface GenericRepositoryDTO<DTO, ID> {

	Optional<DTO> findById(ID id);

	Optional<DTO> save(DTO dto);

	void delete(DTO dto);

	List<DTO> findAll();

}
