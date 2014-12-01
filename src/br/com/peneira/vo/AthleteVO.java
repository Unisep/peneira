package br.com.peneira.vo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "athletes")
public class AthleteVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_athlete")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "mail")
	private String mail;

	@Column(name = "image")
	private String image;

	@Column(name = "pass")
	private String pass;

	@Column(name = "state")
	private String state;

	@Column(name = "phone")
	private Integer phone;

	@Column(name = "city")
	private String city;

	@Column(name = "born")
	private Date born;

	@Column(name = "bio")
	private Character bio;

	@Column(name = "position")
	private String position;

	@Column(name = "good_feet")
	private String goodFeet;

	@Column(name = "player")
	private String player;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public Character getBio() {
		return bio;
	}

	public void setBio(Character bio) {
		this.bio = bio;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGood_feet() {
		return goodFeet;
	}

	public void setGood_feet(String good_feet) {
		this.goodFeet = good_feet;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

}
