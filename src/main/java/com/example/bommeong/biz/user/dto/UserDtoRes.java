package com.example.bommeong.biz.user.dto;

import com.example.bommeong.biz.adopt.dao.AdoptEntity;
import com.example.bommeong.biz.adopt.dto.AdoptModel;
import com.example.bommeong.biz.user.domain.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserDtoRes {
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TokenDto {
        private String access_token;
        private String refresh_token;
        private String name;
        private String email;
        private Long memberId;
        private String memberType;
    }

    @Getter
    public static class UserRes {
        private String email;

        private String name;

        private String phone;

        private Integer point;
        private String memberType;

        @Builder
        public UserRes(User user) {
            this.email = user.getEmail();
            this.name = user.getName();
            this.phone = user.getPhone();
            this.memberType = user.getMemberType();
        }
    }

    @Data
    @NoArgsConstructor
    public static class MyPageDto {
        private Long memberId;
        private String name;
        private String email;
        private String memberType;
        private AdoptModel adoption;

        public MyPageDto(User user, Optional<AdoptEntity> adoptEntity) {
            this.memberId = user.getId();
            this.name = user.getName();
            this.email = user.getEmail();
            this.memberType = user.getMemberType();
            adoptEntity.ifPresent(entity -> this.adoption = entity.toModel());
        }
    }

    @Data
    @NoArgsConstructor
    public static class UserListAdmin {
        private Long memberId;
        private String name;
        private String email;
        private String phone;
        private String memberType;
        private String memberStatus;
        private AdoptModel adoption;
        private LocalDateTime createdAt;


        public UserListAdmin(User user) {
            this.memberId = user.getId();
            this.name = user.getName();
            this.email = user.getEmail();
            this.phone = user.getPhone();
            this.memberType = user.getMemberType();
            this.memberStatus = user.getMemberStatus();
            this.createdAt = user.getCreatedAT();
//                adoptEntity.ifPresent(entity -> this.adoption = entity.toModel());
        }

    }

}
