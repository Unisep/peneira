package com.peneira.bean.scout;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.unisep.hibernate.GenericDAO;

import com.peneira.vo.ScoutVO;

@ManagedBean(name="NewScoutsBean")
@ViewScoped
public class New {

	private ScoutVO scout;
	private HashMap<String, String> states;
	
	@PostConstruct
	public void inicializar() {
		scout = new ScoutVO();

		startStates();
	}
	
	private void startStates() {
		states = new HashMap<String, String>();

		states.put("PR", "Paraná");
		states.put("SC", "Santa Catarina");
		states.put("RS", "Rio Grande do Sul");
		states.put("SP", "São Paulo");
    }

	public String save() {

		GenericDAO<ScoutVO> dao = new GenericDAO<ScoutVO>();
		if (scout.getId() != null && scout.getId() != 0) {
			dao.update(scout);
		} else {
			dao.save(scout);
		}
		return "scout";
	}

	public ScoutVO getScout() {
		return scout;
	}

	public void setScout(ScoutVO scout) {
		this.scout = scout;
	}

	public HashMap<String, String> getStates() {
		return states;
	}

	public void setStates(HashMap<String, String> states) {
		this.states = states;
	}
}
