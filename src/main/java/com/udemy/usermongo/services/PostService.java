package com.udemy.usermongo.services;

import com.udemy.usermongo.domain.Post;
import com.udemy.usermongo.repository.PostRepository;
import com.udemy.usermongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> postOptional = postRepository.findById(id);
        return postOptional.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    public List<Post> findByTitle(String text) {
//        return postRepository.findByTitleContainingIgnoreCase(text);
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(maxDate);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return postRepository.fullSearch(text, minDate, cal.getTime());
    }

}
