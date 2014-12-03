package com.peneira.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class MessageVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_scout")
	private Integer id;

	@OneToMany
	@JoinColumn(name = "id_scout")
	private Integer id_scout;

	@ManyToMany
	@JoinColumn(name = "id_athlete")
	private Integer id_athlete;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_scout() {
		return id_scout;
	}

	public void setId_scout(Integer id_scout) {
		this.id_scout = id_scout;
	}

	public Integer getId_athlete() {
		return id_athlete;
	}

	public void setId_athlete(Integer id_athlete) {
		this.id_athlete = id_athlete;
	}

}
