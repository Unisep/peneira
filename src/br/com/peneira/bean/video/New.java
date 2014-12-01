package br.com.peneira.bean.video;

import javax.faces.bean.ManagedBean;

import br.com.peneira.vo.VideoVO;
import br.edu.unisep.hibernate.DAOGenerico;

@ManagedBean
public class New {

	private VideoVO video = new VideoVO();

	public String save() {

		DAOGenerico<VideoVO> dao = new DAOGenerico<VideoVO>();
		if (video.getId() != null && video.getId() != 0) {
			dao.atualizar(video);
		} else {
			dao.salvar(video);
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
