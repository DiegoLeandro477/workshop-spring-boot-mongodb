package com.ferruje.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ferruje.workshopmongo.domain.Post;
import com.ferruje.workshopmongo.domain.User;
import com.ferruje.workshopmongo.dto.AuthorDTO;
import com.ferruje.workshopmongo.dto.CommentDTO;
import com.ferruje.workshopmongo.repository.PostRepository;
import com.ferruje.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private PostRepository postRep;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRep.deleteAll();
		postRep.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRep.saveAll(Arrays.asList(maria, alex, bob));
		
		
		Post post1 = new Post(null, sdf.parse("21/03/2023"), "Partiu viagem", "Vou viajar para São Paulo. Abreços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2023"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		post1.getComments().add(new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2023"), new AuthorDTO(alex)));
		post1.getComments().add(new CommentDTO("Aproveite", sdf.parse("22/03/2023"), new AuthorDTO(bob)));
		post2.getComments().add(new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2023"), new AuthorDTO(alex)));
		
		postRep.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRep.save(maria);
		
	}

}
