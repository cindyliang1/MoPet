package tw.com.MoPet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

//@Entity
//@Table(name="like")
public class Like {

	@Id
	@Column(name="c_id")
	private Integer c_id;
	
	@Id
	@Column(name="r_id")
	private Integer r_id;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createondate")
	private Date createondate;
	
	public Like() {
	}

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public Integer getR_id() {
		return r_id;
	}

	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}

	public Date getCreateondate() {
		return createondate;
	}

	public void setCreateondate(Date createondate) {
		this.createondate = createondate;
	}

	public Like(Integer c_id, Integer r_id, Date createondate) {
		super();
		this.c_id = c_id;
		this.r_id = r_id;
		this.createondate = createondate;
	}

	
}
