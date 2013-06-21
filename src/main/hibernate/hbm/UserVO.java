package main.hibernate.hbm;

// Generated May 29, 2013 12:42:53 PM by Hibernate Tools 3.6.0

import java.util.Date;

import main.java.common.beans.BaseVO;

/**
 * SUser generated by hbm2java
 */
public class UserVO extends BaseVO {

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "UserVO [id=" + id + ", name=" + name + ", internalInd="
		+ internalInd + ", startDate=" + startDate + ", endDate="
		+ endDate + ", password=" + password + "]";
    }

    /**
     * 
     */
    private static final long serialVersionUID = -9159609294633126167L;
    private Integer id;
    private String name;
    private Integer internalInd;
    private Date startDate;
    private Date endDate;
    private String password;

    public UserVO() {
    }

    public UserVO(String name, Date startDate) {
	this.name = name;
	this.startDate = startDate;
    }

    public UserVO(String name, Integer internalInd, Date startDate,
	    Date endDate, String password) {
	this.name = name;
	this.internalInd = internalInd;
	this.startDate = startDate;
	this.endDate = endDate;
	this.password = password;
    }

    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Integer getInternalInd() {
	return this.internalInd;
    }

    public void setInternalInd(Integer internalInd) {
	this.internalInd = internalInd;
    }

    public Date getStartDate() {
	return this.startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Date getEndDate() {
	return this.endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

}