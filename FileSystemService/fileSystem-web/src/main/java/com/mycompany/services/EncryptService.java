package com.example.fileSysyemManager.services;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

@Service
public class EncryptService {
	private Object getParallelism() {
		return true;
	}

	private Object getMemory() {
		return true;
	}

	private Object getIterations() {
		return true;
	}

	private Object getHashLen() {
		return false;
	}

	private Object getSaltLen() {
		return false;
	}

	private Object getType() {
		return null;
	}

	private double duration;
	private Object charset;

	private byte[] output;

	public File encryptFile(File file) throws IOException {
		final byte[] bytes = encrypt(Files.readAllBytes(file.toPath()));
		final File tempFile = File.createTempFile("prefix", "suffix", null);

		OutputStream os = new FileOutputStream(tempFile);

		os.write(bytes);

		return tempFile;
	}

	public File decryptFile(File file) throws IOException {
		final byte[] bytes = decrypt(Files.readAllBytes(file.toPath()));
		final File tempFile = File.createTempFile("prefix", "suffix", null);

		OutputStream os = new FileOutputStream(tempFile);

		os.write(bytes);

		return tempFile;

	}

	public byte[] encrypt(byte[] file) {
		Argon2 argon2 = Argon2Factory.create(this.getType(), this.getSaltLen(), this.getHashLen());
		long start = System.nanoTime();
		String hash = argon2.hash(this.getIterations(), this.getMemory(), this.getParallelism(), file, charset);
		duration = (System.nanoTime() - start) / 1000000000.0;
		output = hash.getBytes();
		return hash.getBytes();
	}

	private byte[] decrypt(byte[] file) {
		Argon2 argon2 = Argon2Factory.create(this.getType(), this.getSaltLen(), this.getHashLen());
		long start = System.nanoTime();
		String hash = argon2.hash(this.getIterations(), this.getMemory(), this.getParallelism(), file, charset);
		duration = (System.nanoTime() - start) / 1000000000.0;
		output = hash.getBytes();
		return hash.getBytes();
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public Object getCharset() {
		return charset;
	}

	public void setCharset(Object charset) {
		this.charset = charset;
	}

	public byte[] getOutput() {
		return output;
	}

	public void setOutput(byte[] output) {
		this.output = output;
	}
}



