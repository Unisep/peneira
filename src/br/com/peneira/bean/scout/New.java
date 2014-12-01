package br.com.peneira.bean.scout;

import javax.faces.bean.ManagedBean;

import br.com.peneira.vo.ScoutVO;
import br.edu.unisep.hibernate.DAOGenerico;

@ManagedBean
public class New {

	private ScoutVO scout = new ScoutVO();

	public String save() {

		DAOGenerico<ScoutVO> dao = new DAOGenerico<ScoutVO>();
		if (scout.getId() != null && scout.getId() != 0) {
			dao.atualizar(scout);
		} else {
			dao.salvar(scout);
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
