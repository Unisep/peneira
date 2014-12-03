package br.com.peneira.bean.scout;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.peneira.vo.ScoutVO;
import br.edu.unisep.hibernate.GenericDAO;

@ManagedBean(name="NewScoutsBean")
@ViewScoped
public class New {

	private ScoutVO scout = new ScoutVO();

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

}
