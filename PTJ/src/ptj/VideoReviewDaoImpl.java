package ptj;

import java.util.List;
import java.util.Map;

public class VideoReviewDaoImpl implements VideoReviewDao{
	
	private static int reviewNO;
	private Map<Integer, List<VideoReview>> videoReviewDB;
	private static VideoReviewDaoImpl instance = new VideoReviewDaoImpl();
	
	private VideoReviewDaoImpl() {
	}
	
	public static VideoReviewDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public int InsertReview(VideoReview videoReview) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<VideoReview> selectReview(int videoNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
