package firstapp.topic;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class topicController {
	
	@RequestMapping("/topics")
	public ArrayList<Topic> allTopics(){
		ArrayList<Topic> arr = new ArrayList();
		arr.add(new Topic("spring", "spring framework","desc"));
		return arr;
	}

}
