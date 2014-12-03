package br.com.peneira.bean.scout;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.peneira.vo.ScoutVO;
import br.edu.unisep.hibernate.GenericDAO;

@ManagedBean(name="ListScoutsBean")
@ViewScoped
public class List {

	private java.util.List<ScoutVO> scouts;

	@PostConstruct
	public void list() {
		GenericDAO<ScoutVO> dao = new GenericDAO<ScoutVO>();
		scouts = dao.list(ScoutVO.class);
	}

	public java.util.List<ScoutVO> getScouts() {
		return scouts;
	}

	public void setScouts(java.util.List<ScoutVO> scouts) {
		this.scouts = scouts;
	}

}
