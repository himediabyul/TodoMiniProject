package com.todo.todominiproject.service.member;

import com.todo.todominiproject.domain.member.MemberSaveRequest;
import com.todo.todominiproject.entity.Member;
import com.todo.todominiproject.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Log4j2
public class MemberSaveService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder encoder;


    public int save(MemberSaveRequest saveRequest){

        MultipartFile file = saveRequest.getPhoto();

        File saveDir = null;
        String newFileName = null;

        if(file != null && !file.isEmpty() && file.getSize()>0){

            // 저장경로
            String absolutePath = new File("").getAbsolutePath();

            String path = "photo";
            saveDir = new File(absolutePath, path);

            // 폴더가 없으면 생성
            if(!saveDir.exists()){

                saveDir.mkdir();

            }

            // 파일이름 중복되지 않게
            newFileName = System.currentTimeMillis()+file.getOriginalFilename();

            File newFile = new File(saveDir, newFileName);

            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        // Entity 저장
        Member member = saveRequest.toMemberEntity();

        // 패스워드 암호화
        member.setPw(encoder.encode(saveRequest.getPw()));

        if(newFileName != null){
            member.setPhoto(newFileName);
        }

        int result = 0;

        try {

        result = memberRepository.save(member) != null ? 1 : 0;

        } catch (Exception e) {
        // 파일이 존재한다면 삭제
        if(newFileName != null) {

            File delFile = new File(saveDir, newFileName);

            if(delFile.exists()){
                delFile.delete();
            }
        }
    }
    return result;
    }

    public Map<String, String> validateHandling(Errors errors){
        Map<String, String> validateResult = new HashMap<>();

        for(FieldError error : errors.getFieldErrors()){
            String validKeyName = String.format("valid_", error.getField());
            validateResult.put(validKeyName, error.getDefaultMessage());
        }
        return validateResult;
    }

    @Transactional
    public void checkIdDuplication(MemberSaveRequest saveRequest) {
        boolean idDuplicate = memberRepository.existsById(saveRequest.toMemberEntity().getId());
        if (idDuplicate) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }
}
