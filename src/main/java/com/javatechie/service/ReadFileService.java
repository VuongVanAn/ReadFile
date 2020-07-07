package com.javatechie.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.javatechie.model.User;

public interface ReadFileService {

	List<User> findAll();

	boolean saveDataFromUploadFile(MultipartFile file);

}
