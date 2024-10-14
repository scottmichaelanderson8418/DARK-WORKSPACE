package io.javabrains.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	// this is how we get an instance of the service "TopicService"
	@Autowired
	private TopicService topicService;

	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	// The path variable tells string that "String id" is a variable in the path

	@GetMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);

	}

	@PostMapping("/topics")
	// @RequestMapping(method = RequestMethod.POST, value = "/topics")

	public void addTopic(@RequestBody Topic topic) {

		topicService.addTopic(topic);
	}

	@PutMapping("/topics/{id}")
	// @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {

		topicService.updateTopic(id, topic);
	}

	@DeleteMapping("/topics/{id}")
	// @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@PathVariable String id) {

		topicService.deleteTopic(id);
	}
}
