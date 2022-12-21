package com.todo.todominiproject.service.member;

import com.todo.todominiproject.domain.MemberEditRequest;
import com.todo.todominiproject.entity.Member;
import com.todo.todominiproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class MemberEditService {

    @Autowired
    private MemberRepository memberRepository;

    public int editMem(MemberEditRequest editRequest){
        MultipartFile file = editRequest.getNewPhoto();

        File saveDir = null;
        String newFileName = null;

        if(file != null && !file.isEmpty()){

            String absolutePate = new File("").getAbsolutePath();

            String path = "member";
            saveDir = new File(absolutePate, path);

            if(!saveDir.exists()){
                saveDir.mkdir();
            }

            newFileName = System.currentTimeMillis()+file.getOriginalFilename();

            File newFile = new File(saveDir, newFileName);

            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        Member member = editRequest.toMemberEntity();

        if(newFileName != null){
            member.setPhoto(newFileName);
        } else {
            member.setPhoto(null);
        }

        int result = 0;

        try {

            memberRepository.save(member);

            // 새로운 파일이 저장 되고 이전 파일이 존재한다면 ! -> 이전 파일을 삭제
            String oldFileName = editRequest.getOldPhoto();
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