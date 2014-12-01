package br.com.peneira.bean.atlhete;

import javax.faces.bean.ManagedBean;

import br.com.peneira.vo.AthleteVO;
import br.edu.unisep.hibernate.DAOGenerico;

@ManagedBean
public class New {

	private AthleteVO athlete = new AthleteVO();

	public String save() {

		DAOGenerico<AthleteVO> dao = new DAOGenerico<AthleteVO>();
		if (athlete.getId() != null && athlete.getId() != 0) {
			dao.atualizar(athlete);
		} else {
			dao.salvar(athlete);
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