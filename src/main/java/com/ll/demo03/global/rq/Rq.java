package com.ll.demo03.global.rq;

import com.ll.demo03.domain.member.member.entity.Member;
import com.ll.demo03.domain.member.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@RequiredArgsConstructor
public class Rq {
    private final HttpServletRequest req;
    private final HttpServletRequest resp;
    private final MemberService memberService;

    public Member getMember() {
        return memberService.getReferenceById(1L);
    }

    public String getCurrentUrlPath() {
        return req.getRequestURI();
    }
}
