package dev.loqo71la.sbp.base.repository;

import dev.loqo71la.sbp.base.model.Model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<T extends Model> extends CrudRepository<T, Long>, PagingAndSortingRepository<T, Long> {
}
