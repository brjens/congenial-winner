package com.mycompany.Jamswebapp.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.mycompany.Jamswebapp.exception.NotFoundException;
import com.mycompany.Jamswebapp.model.Review;
import com.mycompany.Jamswebapp.repository.ReviewRepository;
@Service
public class ReviewService{
	private final ReviewRepository reviewRepository;

	@Autowired
	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository=revieRepository;
	}


	//buisness logic here
	public review getReviewById(Long id){
		return reviewRepository.findById(id)
			.orElseThrow(() -> new NotFoundException("user not found"));
	}

	public review createReview(Review review){
		return reviewRepository.save(review);
	}

	public void deleteReview(Long id){
		reviewRepository.deleteById(id)
			.orElseThrow(() -> new NotFoundException("user not found"));
	}

	public List<Review> getAllReviews(){
		List<Review> reviews = reviewRepository.findAll();
		return reviews;
	}

 	// Retrieve all reviews with pagination
	public List<Review> getAllReviews(int page, int size) {
        	PageRequest pageRequest = PageRequest.of(page, size);
        	Page<Review> reviewPage = reviewRepository.findAll(pageRequest);
        	return reviewPage.getContent();
      	}
}
