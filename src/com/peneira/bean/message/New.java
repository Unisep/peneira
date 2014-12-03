package com.peneira.bean.message;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.peneira.vo.MessageVO;

import br.edu.unisep.hibernate.GenericDAO;

@ManagedBean(name="NewMessageBean")
@ViewScoped
public class New {

	private MessageVO message = new MessageVO();

	// se for preciso algum ojbeto que seja carregado antes de a tela ser
	// renderizada crie um método post construct então.

	public String save() {

		GenericDAO<MessageVO> dao = new GenericDAO<MessageVO>();
		if (message.getId() != null && message.getId() != 0) {
			dao.update(message);
		} else {
			dao.save(message);
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