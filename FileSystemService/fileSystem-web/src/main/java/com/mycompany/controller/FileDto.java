package com.example.fileSysyemManager.controllers;

import lombok.*;

import java.io.File;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileDto {

	private File file;
	private String name;
	private String path;
	private String directory;
	private long id;


}
