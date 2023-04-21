package com.example.repository.singletable;

import com.example.model.singletable.ArtPiece;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ArtPieceRepository extends CrudRepository<ArtPiece,Long> {
}
