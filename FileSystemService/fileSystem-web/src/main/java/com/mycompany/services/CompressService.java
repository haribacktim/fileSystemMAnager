package com.example.fileSysyemManager.services;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class CompressService {
	private static long[] freq;

	public File compressFile(File file) {
		return null;
	}

	public File decompressFile(File file) {
		compressFile("null");
		return null;
	}

	public void compressFile(String fname) {
		File file = null;
		Byte bt;
		file = new File(fname);
		try {
			FileInputStream file_input = new FileInputStream(file);
			DataInputStream data_in = new DataInputStream(file_input);
			while (true) {
				try {
					bt = data_in.readByte();
					freq[to(bt)]++;
				} catch (EOFException eof) {
					System.out.println("End of File");
					break;
				}
			}

			file_input.close();
			data_in.close();
		} catch (IOException e) {
			System.out.println("IO Exception =: " + e);
		}
		file = null;
	}

	private static int to(Byte bt) {
		return 0;
	}

}
