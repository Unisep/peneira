package br.com.peneira.bean.message;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.peneira.vo.MessageVO;
import br.edu.unisep.hibernate.DAOGenerico;

@ManagedBean
public class List {

	// Todo o código relacionado a listagem de mensagens.
	private java.util.List<MessageVO> messages;
	
	@PostConstruct
	public void list() {
		DAOGenerico<MessageVO> dao = new DAOGenerico<MessageVO>();
		messages = dao.listar(MessageVO.class);
	}
	
	public java.util.List<MessageVO> getMessages() {
		return messages;
	}

	public void setMessages(java.util.List<MessageVO> messages) {
		this.messages = messages;
	}
}