package com.backend.server.domain;

public enum Step {
    CREATE_APPLICATION_FORM, // 지원폼 생성하기
    WRITE_PROMOTION_POST,//홍보글 작성하기
    MANAGE_APPLICANTS,//지원자 관리하기
    SELECT_FIRST_ROUND_PASS,//1차합격자 선택하기
    START_INTERCIEW,//면접 시작하기
    SELECT_FINAL_PASS,//최종 합격자 선택하기
}
