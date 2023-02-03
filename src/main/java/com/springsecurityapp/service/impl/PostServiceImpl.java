package com.springsecurityapp.service.impl;

import com.springsecurityapp.model.Post;
import com.springsecurityapp.repository.PostRepository;
import com.springsecurityapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public Post getPost(long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public boolean existsPostById(long id) {
        return postRepository.existsById(id);
    }
}
