package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	//calls on all topics 
	//map method to any request that is a GET on /topics
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}	
	
	
	//maps to topics depending on id where
	//{} mark the variable portion
	//path variable just says that this id in the arguments 
	//is the same as the id in quotes above it
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		
		return topicService.getTopic(id);
	}
	
	//this is a post request, not a get like the above
	//must specify method. Default is GET
	//map this method to any request that is a POST on "/topics"
	//what u r doing here is that data is in a stream
	//when u put @RequestBody, it saying go to that 
	//request body part of the stream, and get the instance
	//there called topic and return it to me
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		
		topicService.addTopic(topic);
		
	}
}
