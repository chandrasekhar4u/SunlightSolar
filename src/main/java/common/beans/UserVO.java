/**
 * 
 */
package main.java.common.beans;

import java.sql.Date;

/**
 * The Class UserVO.
 * 
 * @author CHANDRA
 */
public class UserVO extends BaseVO {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2736180064980360718L;

    /** The id. */
    private Long id;

    /** The name. */
    private String name;
    
    private Boolean internalInd;

    public Boolean getInternalInd() {
	return internalInd;
    }

    public void setInternalInd(Boolean internalInd) {
	this.internalInd = internalInd;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    private String password;

    private Date startDate;

    private Date endDate;

    /** The address. */
    private String address;

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public Long getId() {
	return id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Sets the name.
     * 
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Gets the address.
     * 
     * @return the address
     */
    public String getAddress() {
	return address;
    }

    /**
     * Sets the address.
     * 
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
	this.address = address;
    }

}
