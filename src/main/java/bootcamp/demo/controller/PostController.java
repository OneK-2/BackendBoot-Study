package bootcamp.demo.controller;

import bootcamp.demo.domain.post.PostRequest;
import bootcamp.demo.domain.post.PostResponse;
import bootcamp.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 작성 페이지
    @GetMapping("/write")
    public String openPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
        if (id != null) {
            PostResponse post = postService.findPostById(id);
            model.addAttribute("post", post);
        }
        return "write";
    }
    // 신규 게시글 생성
    @PostMapping("/save")
    public String savePost(final PostRequest params) {
        postService.savePost(params);
        return "redirect:/list";
    }
    // 게시글 리스트 페이지
    @GetMapping("/list")
    public String openPostList(Model model) {
        List<PostResponse> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "list";
    }
    // 게시글 상세 페이지
    @GetMapping("/view")
    public String openPostView(@RequestParam final Long id, Model model) {
        PostResponse post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "view";
    }
    // 기존 게시글 수정
    @PostMapping("/update")
    public String updatePost(final PostRequest params) {
        postService.updatePost(params);
        return "redirect:/list";
    }
    // 게시글 삭제
    @PostMapping("/delete")
    public String deletePost(@RequestParam final Long id) {
        postService.deletePost(id);
        return "redirect:/list";
    }
}

