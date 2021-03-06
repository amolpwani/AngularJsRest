package com.ford.afd.model;

import javax.persistence.*;

@Entity
public class Mapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private Integer routineCode;
    private String screenName;
    private Integer numberOfRows;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="catagory_id",nullable = false)
    private Catagory catagory;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public Integer getRoutineCode() {
 		return routineCode;
 	}

 	public void setRoutineCode(Integer routineCode) {
 		this.routineCode = routineCode;
 	}

 	public String getScreenName() {
 		return screenName;
 	}

 	public void setScreenName(String screenName) {
 		this.screenName = screenName;
 	}

 	public Integer getNumberOfRows() {
 		return numberOfRows;
 	}

 	public void setNumberOfRows(Integer numberOfRows) {
 		this.numberOfRows = numberOfRows;
 	}

	public Catagory getCatagory() {
		return catagory;
	}

	public void setCatagory(Catagory category) {
		this.catagory = category;
	}
}
