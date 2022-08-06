package bootcamp.demo.domain.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
    private Long id;             // PK
    private String title;        // 제목
    private String content;      // 내용
    private String writer;       // 작성자
    private Boolean noticeYn;    // 공지글 여부
}
/*
조회 수(view_cnt)와 삭제 여부(delete_yn)는 무조건 0으로 생성이 되어야 하며,
생성일시(created_date)는 현재 시간으로, 수정일시(modified_date)는 NULL로 설정해주면 된다.
 */