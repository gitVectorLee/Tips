package maijiayunTips.Dao.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "user") 
public class User{

@Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int id;
 @Column(name = "name", nullable = true, length = 30)
 private String name;
 @Column(name = "remarks", nullable = true, length = 10)
 private String remarks;
 private String status;
 @JSONField(format="yyyy-MM-dd HH:mm")
 private Date createDate;
 @JSONField(format="yyyy-MM-dd HH:mm")
 private Date endDate;
 private int vip;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public int getVip() {
	return vip;
}
public void setVip(int vip) {
	this.vip = vip;
}

 
}
