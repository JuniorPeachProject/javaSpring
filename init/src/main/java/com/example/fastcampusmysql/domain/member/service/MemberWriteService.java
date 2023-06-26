package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.dto.RegisterMemberCommand;

public class MemberWriteService {
    public void create(RegisterMemberCommand command) {
        /*
        회원 정보를 등록한다. (이메일, 닉네임, 생년월일)
        -닉네임은 10자를 넘길 수 없다.

        memberRegisterCommand
        val member = Member.of(memberRegisterCommand)
        memberRepository.save()
         */
    }
}
