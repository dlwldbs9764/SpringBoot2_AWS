package aws.springboot.service.posts;

import aws.springboot.domain.posts.Posts;
import aws.springboot.domain.posts.PostsRepository;
import aws.springboot.web.dto.PostsResponseDto;
import aws.springboot.web.dto.PostsSaveRequestDto;
import aws.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() ->new IllegalArgumentException(
                "해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(long id){
        Posts entity=postsRepository.findById(id).orElseThrow(() ->new IllegalArgumentException(
                "해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

}
