package ptj;

import java.util.List;

public class VideoDaoImpl implements VideoDao{
	private List<Video> list;
	private static VideoDaoImpl instance = new VideoDaoImpl();
	
	private VideoDaoImpl() {
	}
	
	public static VideoDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public List<Video> selectVideo() {
		return null;
	}
	
	@Override
	public Video selectVideoByNo(int no) {
		return null;
	}
}
