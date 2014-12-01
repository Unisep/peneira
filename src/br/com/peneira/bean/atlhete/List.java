package br.com.peneira.bean.atlhete;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.peneira.vo.AthleteVO;
import br.edu.unisep.hibernate.DAOGenerico;

@ManagedBean
public class List {

	private java.util.List<AthleteVO> athletes;

	@PostConstruct
	public void list() {
		DAOGenerico<AthleteVO> dao = new DAOGenerico<AthleteVO>();
		athletes = dao.listar(AthleteVO.class);
	}

	public java.util.List<AthleteVO> getAthletes() {
		return athletes;
	}

	public void setAthletes(java.util.List<AthleteVO> athletes) {
		this.athletes = athletes;
	}

}
