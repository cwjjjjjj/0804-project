package ptj;

import java.util.List;

public interface VideoReviewDao {
	
	int InsertReview(VideoReview videoReview);
	List<VideoReview> selectReview(int videoNo);
	
}
