package com.todo.todominiproject.service;

import com.todo.todominiproject.domain.TodoSaveRequest;
import com.todo.todominiproject.entity.Todo;
import com.todo.todominiproject.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class TodoSaveService {

    @Autowired
    private TodoRepository todoRepository;

    public int save(TodoSaveRequest saveRequest) throws IOException {

        MultipartFile file = saveRequest.getPhoto();

        File saveDir = null;
        String newFileName = null;

        if (file != null && !file.isEmpty() && file.getSize() > 0) {

            String absolutePath = new File("").getAbsolutePath();

            String path = "photo";
            saveDir = new File(absolutePath, path);

            if (!saveDir.exists()) {
                saveDir.mkdir();
            }

            String uuid = UUID.randomUUID().toString();

            newFileName = uuid + file.getOriginalFilename();

            File newFile = new File(saveDir, newFileName);

            file.transferTo(newFile);

        }


        Todo todo = saveRequest.toTodoEntity();


        if (newFileName != null) {
            todo.setPhoto(newFileName);
        }

        int result=0;
        try {

            result = todoRepository.save(todo) != null ? 1 : 0;

        } catch (Exception e) {
            if (newFileName != null) {
                File delFile = new File(saveDir, newFileName);
                if (delFile.exists()) {

                    delFile.delete();
                }
            }
        }
    return 0;
    }
}
