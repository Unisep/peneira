package com.peneira.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class VideoVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_scout")
	private Integer id;
	@ManyToMany
	@JoinColumn(name = "id_athlete")
	private Integer id_athlete;
	
	@Column(name = "url")
	private String url;

	@Column(name = "description")
	private String description;

	@Column(name = "view_count")
	private Integer view_count;

	@Column(name = "reputation")
	private Double reputation;

	public Integer getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_athlete() {
		return id_athlete;
	}

	public void setId_athlete(Integer id_athlete) {
		this.id_athlete = id_athlete;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getView_count() {
		return view_count;
	}

	public void setView_count(Integer view_count) {
		this.view_count = view_count;
	}

	public Double getReputation() {
		return reputation;
	}

	public void setReputation(Double reputation) {
		this.reputation = reputation;
	}

}
