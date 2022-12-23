package com.todo.todominiproject.service.todo;

import com.todo.todominiproject.domain.todo.TodoEditRequest;
import com.todo.todominiproject.entity.Todo;
import com.todo.todominiproject.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class TodoEditService {

    @Autowired
    private TodoRepository todoRepository;

    public int edit(TodoEditRequest editRequest){

        MultipartFile file = editRequest.getNewPhoto();

        File saveDir = null;
        String newFileName = null;

        if(file != null && !file.isEmpty()){

            String absolutePate = new File("").getAbsolutePath();

            String path = "photo";
            saveDir = new File(absolutePate, path);

            if(!saveDir.exists()){
                saveDir.mkdir();
            }

            String uuid = UUID.randomUUID().toString();
            newFileName = uuid+file.getOriginalFilename();
            File newFile = new File(saveDir, newFileName);

            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        Todo todo = editRequest.toTodoEntity();
        if(newFileName != null){
            todo.setPhoto(newFileName);
        } else {
            todo.setPhoto(null);
        }

        int result = 0;

        try {

            todoRepository.save(todo);

            // 새로운 파일이 저장 되고 이전 파일이 존재한다면 ! -> 이전 파일을 삭제
            String oldFileName = editRequest.getOldFile();
            if(newFileName !=null && oldFileName != null && !oldFileName.isEmpty()){
                File delOldFile = new File(saveDir,oldFileName);
                if(delOldFile.exists()){
                    delOldFile.delete();
                }
            }

        } catch (Exception e) {

            if(newFileName!=null){
                File delFile = new File(saveDir, newFileName);
                if(delFile.exists()){
                    delFile.delete();
                }
            }
        }

        return result;

    }
}
