package io.pp1.rating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {


		@Autowired
		private RatingRepository ratingRepository;
		
		
		@RequestMapping(method = RequestMethod.POST, path = "/rating/net_id")
		public Integer getRating(@RequestBody Rating net_id) {
			List<Rating> ratings =ratingRepository.getRatingByID(net_id.getNet_id());
			int totalRatings=0;
			for(int i=0;i<ratings.size();i++) {
				totalRatings+= ratings.get(i).getRating();
			}
			double checking= Math.round(totalRatings/(ratings.size()+0.0));
			totalRatings= (int)checking;
			return totalRatings;
		}
		
		@RequestMapping(method = RequestMethod.POST, path = "/rating")
		public void saveRating(@RequestBody final Rating rating) {
			 ratingRepository.save(rating);
		}
		
		
}
