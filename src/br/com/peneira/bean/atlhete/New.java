package br.com.peneira.bean.atlhete;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.peneira.vo.AthleteVO;
import br.edu.unisep.hibernate.GenericDAO;

@ManagedBean(name="NewAthletesBean")
@ViewScoped
public class New {

	private AthleteVO athlete = new AthleteVO();

	public String save() {

		GenericDAO<AthleteVO> dao = new GenericDAO<AthleteVO>();
		if (athlete.getId() != null && athlete.getId() != 0) {
			dao.update(athlete);
		} else {
			dao.save(athlete);
		}
		return "athlete";
	}

	public AthleteVO getAthlete() {
		return athlete;
	}

	public void setAthlete(AthleteVO athlete) {
		this.athlete = athlete;
	}

}