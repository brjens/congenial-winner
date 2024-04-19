import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable("id") Long id) {
        Review review = reviewService.getReviewById(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable("id") Long id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Additional endpoint to retrieve reviews with pagination
    @GetMapping("/page")
    public ResponseEntity<List<Review>> getAllReviewsWithPagination(@RequestParam("page") int page, @RequestParam("size") int size) {
        List<Review> reviews = reviewService.getAllReviews(page, size);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}

