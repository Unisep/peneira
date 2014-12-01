package br.com.peneira.bean.scout;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.peneira.vo.ScoutVO;
import br.edu.unisep.hibernate.DAOGenerico;

@ManagedBean
public class List {

	private java.util.List<ScoutVO> scouts;

	@PostConstruct
	public void list() {
		DAOGenerico<ScoutVO> dao = new DAOGenerico<ScoutVO>();
		scouts = dao.listar(ScoutVO.class);
	}

	public java.util.List<ScoutVO> getScouts() {
		return scouts;
	}

	public void setScouts(java.util.List<ScoutVO> scouts) {
		this.scouts = scouts;
	}

}
