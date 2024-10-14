package io.javabrains.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

//declares this class as a business service
@Service
public class TopicService {

	// Calls this method
	// Spring MVC Converts the list into a JSON and a JSON is what is returned

	// now we have a mutatble arrayslist
	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
					new Topic("java", "Core Java", "Core Java Description"),
					new Topic("javascript", "JavaScript", "JavaScript Description")

			));

	public List<Topic> getAllTopics() {

		return topics;
	}

	// public Topic getTopic(String id) {
	// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	// }

	public Topic getTopic(String id) {

		for (int i = 0; i < topics.size(); i++) {

			if (topics.get(i).getId().equals(id)) {
				return topics.get(i);
			}

		}
		return null;

		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {

		for (int i = 0; i < topics.size(); i++) {

			Topic t = topics.get(i);
			// find the topic by id
			if (t.getId().equals(id)) {

				topics.set(i, topic);
				return;

			}

		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
