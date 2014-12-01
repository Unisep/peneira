package br.com.peneira.bean.video;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.peneira.vo.VideoVO;
import br.edu.unisep.hibernate.DAOGenerico;

@ManagedBean
public class List {

	private java.util.List<VideoVO> videos;

	@PostConstruct
	public void list() {
		DAOGenerico<VideoVO> dao = new DAOGenerico<VideoVO>();
		videos = dao.listar(VideoVO.class);
	}

	public java.util.List<VideoVO> getVideos() {
		return videos;
	}

	public void setVideos(java.util.List<VideoVO> videos) {
		this.videos = videos;
	}

}
