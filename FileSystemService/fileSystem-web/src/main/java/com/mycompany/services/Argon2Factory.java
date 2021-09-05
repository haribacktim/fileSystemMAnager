package com.example.fileSysyemManager.services;

public class Argon2Factory {
	public static Argon2 create(Object type, Object saltLen, Object hashLen) {
		return new Argon2();
	}
}
