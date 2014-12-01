package br.com.peneira.bean.message;

import javax.faces.bean.ManagedBean;

import br.com.peneira.vo.MessageVO;
import br.edu.unisep.hibernate.DAOGenerico;

@ManagedBean
public class New {

	private MessageVO message = new MessageVO();

	// se for preciso algum ojbeto que seja carregado antes de a tela ser
	// renderizada crie um método post construct então.

	public String save() {

		DAOGenerico<MessageVO> dao = new DAOGenerico<MessageVO>();
		if (message.getId() != null && message.getId() != 0) {
			dao.atualizar(message);
		} else {
			dao.salvar(message);
		}
		return "message";
	}

	public MessageVO getMessage() {
		return message;
	}

	public void setMessage(MessageVO message) {
		this.message = message;
	}
}