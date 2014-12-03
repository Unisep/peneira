package com.peneira.bean.message;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.peneira.vo.MessageVO;

import br.edu.unisep.hibernate.GenericDAO;

@ManagedBean(name="ListMessageBean")
@ViewScoped
public class List {

	// Todo o código relacionado a listagem de mensagens.
	private java.util.List<MessageVO> messages;
	
	@PostConstruct
	public void list() {
		GenericDAO<MessageVO> dao = new GenericDAO<MessageVO>();
		messages = dao.list(MessageVO.class);
	}
	
	public java.util.List<MessageVO> getMessages() {
		return messages;
	}

	public void setMessages(java.util.List<MessageVO> messages) {
		this.messages = messages;
	}
}