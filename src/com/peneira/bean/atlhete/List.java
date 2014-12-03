package com.peneira.bean.atlhete;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.peneira.vo.AthleteVO;

import br.edu.unisep.hibernate.GenericDAO;

@ManagedBean(name="ListAthletesBean")
@ViewScoped
public class List {

	private java.util.List<AthleteVO> athletes;

	@PostConstruct
	public void list() {
		GenericDAO<AthleteVO> dao = new GenericDAO<AthleteVO>();
		athletes = dao.list(AthleteVO.class);
	}

	public java.util.List<AthleteVO> getAthletes() {
		return athletes;
	}

	public void setAthletes(java.util.List<AthleteVO> athletes) {
		this.athletes = athletes;
	}

}
