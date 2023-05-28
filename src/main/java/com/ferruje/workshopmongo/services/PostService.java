package com.ferruje.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferruje.workshopmongo.domain.Post;
import com.ferruje.workshopmongo.repository.PostRepository;
import com.ferruje.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository rep;

	public Post findById(String id) {
		return rep.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return rep.findByTitleContainingIgnoreCase(text);
	}

}
