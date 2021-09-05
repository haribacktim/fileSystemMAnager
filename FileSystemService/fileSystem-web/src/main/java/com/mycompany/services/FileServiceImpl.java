package com.example.fileSysyemManager.services;

import com.example.fileSysyemManager.controllers.FileDto;
import com.example.fileSysyemManager.entities.FileEntity;
import com.example.fileSysyemManager.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileRepository fileRepository;
	@Autowired
	private CompressService compressService;
	@Autowired
	private EncryptService encryptService;

	public void saveFile(FileDto fileDto) throws IOException {
		File fileCompress = compressService.compressFile(fileDto.getFile());
		File fileEncrypted = encryptService.encryptFile(fileCompress);

		FileEntity fileEntity = new FileEntity();
		fileEntity.setFile(Files.readAllBytes(fileEncrypted.toPath()));
		fileEntity.setDirectory(fileDto.getDirectory());
		fileEntity.setName(fileDto.getName());
		fileEntity.setPath(fileDto.getFile().toPath().toString());

		fileRepository.save(fileEntity);
	}

	public FileDto getFile(String id) {
		final FileEntity byId = fileRepository.findById(id)
				.orElseThrow(IllegalArgumentException::new);

		try {
			File tempFile = File.createTempFile(byId.getPrefix(), byId.getSuffix(), null);
			final File decryptFile = encryptService.decryptFile(tempFile);
			final File decompressFile = compressService.decompressFile(decryptFile);

			return FileDto
					.builder()
					.id(byId.getId())
					.name(byId.getName())
					.path(byId.getPath())
					.directory(byId.getDirectory())
					.file(decompressFile)
					.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateFile(FileDto fileDto) throws IOException {
		File fileCompress = compressService.compressFile(fileDto.getFile());
		File fileEncrypted = encryptService.encryptFile(fileCompress);

		FileEntity fileEntity = new FileEntity();
		fileEntity.setFile(Files.readAllBytes(fileEncrypted.toPath()));
		fileEntity.setDirectory(fileDto.getDirectory());
		fileEntity.setName(fileDto.getName());
		fileEntity.setPath(fileDto.getFile().toPath().toString());

		fileRepository.save(fileEntity);
	}

	public void deleteFile(FileDto fileDto) {
		fileRepository.deleteById(String.valueOf(fileDto.getId()));
	}

	public List<FileDto> getFileByDirectory(String directory) {
		return null;
	}

	public FileDto downloadFile(String id) {
		return null;
	}
}
