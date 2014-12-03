package com.peneira.bean.video;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.peneira.vo.VideoVO;

import br.edu.unisep.hibernate.GenericDAO;

//@ManagedBean(name="com.peneira.bean.message.List")

@ManagedBean(name="ListVideoBean")
@ViewScoped
public class List {

	private java.util.List<VideoVO> videos;

	@PostConstruct
	public void list() {
		GenericDAO<VideoVO> dao = new GenericDAO<VideoVO>();
		videos = dao.list(VideoVO.class);
	}

	public java.util.List<VideoVO> getVideos() {
		return videos;
	}

	public void setVideos(java.util.List<VideoVO> videos) {
		this.videos = videos;
	}

}
