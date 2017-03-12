package com.colorado.repository;

import com.colorado.model.File;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by colorado on 12/03/17.
 */
public interface FileRepository extends CrudRepository<File, Integer> {
}
