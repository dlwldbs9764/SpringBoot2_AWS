package aws.springboot.web;

import aws.springboot.service.posts.PostsService;
import aws.springboot.web.dto.PostsResponseDto;
import aws.springboot.web.dto.PostsSaveRequestDto;
import aws.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// PostsApiController -> PostsService(save) -> PostsSaveRequestDto -> PostsRepository
// PostsApiController -> PostsService(update) -> PostsUpdateRequestDto -> PostsRepository
// PostsApiController -> PostsService(findById) -> PostsResponseDto -> PostsRepository

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    // 등록 API - save
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    // 수정 API - update
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    // 조회 API - findById
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
