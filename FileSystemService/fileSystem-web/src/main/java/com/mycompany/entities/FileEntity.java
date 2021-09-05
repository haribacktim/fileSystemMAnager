package com.example.fileSysyemManager.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class FileEntity {

	@Id
	private Long id;
	private String name;
	private String path;
	private String directory;
	private byte[] file;
	private String prefix;
	private String suffix;

}
