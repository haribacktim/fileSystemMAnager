package com.example.fileSysyemManager.repositories;

import com.example.fileSysyemManager.entities.FileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends MongoRepository<FileEntity, String> {
	List<FileEntity> findByNameAndDirectory(String name, String directory);
}
