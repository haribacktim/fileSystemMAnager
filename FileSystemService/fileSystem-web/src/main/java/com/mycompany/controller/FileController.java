package com.example.fileSysyemManager.controllers;

import com.example.fileSysyemManager.services.FileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController("/file")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileController {

	private final FileServiceImpl fileService;

	@PutMapping
	public void updateFile(@RequestBody FileDto fileDto) throws IOException {
		fileService.updateFile(fileDto);
	}

	@PostMapping
	public void saveFile(@RequestBody FileDto fileDto) throws IOException {
		fileService.saveFile(fileDto);
	}

	@DeleteMapping
	public void deleteFile(@RequestBody FileDto fileDto) {
		fileService.deleteFile(fileDto);
	}

	@GetMapping("/{id}")
	public FileDto getFile(@PathVariable String id) {
		return fileService.getFile(id);
	}

	@GetMapping("/{directory}")
	public List<FileDto> getFileByDirectory(@PathVariable String directory) {
		return fileService.getFileByDirectory(directory);
	}

	@GetMapping("/{id}")
	public FileDto downloadFile(@PathVariable String id) {
		return fileService.downloadFile(id);
	}
}
