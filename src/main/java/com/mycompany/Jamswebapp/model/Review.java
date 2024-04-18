package com.example.myapplication;
import java.time.LocalDate;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private Character name;
	@Column
	private String text;
	@Column;
	private Date date;
	@Column
	private String email;
	@Column
	private Integer star;
	

	 // Constructor(s)
    public Review() {
        // Default constructor
    }

    public Review(Long id, Character name, String text, Date date, String email, Integer star) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.date = date;
        this.email = email;
        this.star = star;
    }

	// Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getName() {
        return name;
    }

    public void setName(Character name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}

