package com.example.bommeong.biz.post.repository;

import com.example.bommeong.biz.post.dao.LikeEntity;
import com.example.bommeong.biz.post.dao.LikeId;
import com.example.bommeong.biz.post.dao.PostEntity;
import com.example.bommeong.biz.user.domain.User;
import com.example.bommeong.common.dao.BaseRepository;
import org.hibernate.Remove;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends BaseRepository<LikeEntity, LikeEntity> {
    Optional<LikeEntity> findAllByUserIsAndPost(User user, PostEntity post);

//    Optional<LikeEntity> findByUserAndPost(User user, PostEntity post);

    Optional<List<LikeEntity>> findByLikeId(LikeId likeId);

    @Query(nativeQuery = true, value = "SELECT * FROM likes l WHERE l.member_id = (:memberId)")
    Optional<List<LikeEntity>> findAllPostIdByMemberId(Long memberId);
}
