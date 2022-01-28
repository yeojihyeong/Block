package co.micol.syperest.movie.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;

import co.micol.syperest.api.MovieAPI;

@Controller
public class MovieController {

	@GetMapping("/movieList")
	@ResponseBody
	public JsonNode movieList()  throws Exception {
		return MovieAPI.movieList();
	}
	
	
	@GetMapping("/restMovieList")
	@ResponseBody
	public JsonNode restMovieList()  throws Exception {
		return MovieAPI.restMovieList();
	}
	
	
}
