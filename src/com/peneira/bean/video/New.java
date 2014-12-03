package com.peneira.bean.video;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.peneira.vo.VideoVO;

import br.edu.unisep.hibernate.GenericDAO;

@ManagedBean(name="NewVideoBean")
@ViewScoped
public class New {

	private VideoVO video = new VideoVO();

	public String save() {

		GenericDAO<VideoVO> dao = new GenericDAO<VideoVO>();
		if (video.getId() != null && video.getId() != 0) {
			dao.update(video);
		} else {
			dao.save(video);
		}
		return "video";
	}

	public VideoVO getVideo() {
		return video;
	}

	public void setVideo(VideoVO video) {
		this.video = video;
	}

}
