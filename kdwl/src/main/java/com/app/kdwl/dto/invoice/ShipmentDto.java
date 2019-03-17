package com.app.kdwl.dto.invoice;

import com.app.kdwl.dto.IBaseBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *   @description : Shipment 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-03-17
 */
public class ShipmentDto extends IBaseBean {

    private static final long serialVersionUID = 1L;

	private String kdno;
	private String teamtype;
	private String teamname;
	private String teamno;
	private String shipper;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date deliverytime;
	private String receiver;
	private String gtype;
	private Double actualweight;
	private Double volweight;
	private Double chargeweight;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createtime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date modifytime;
	private Integer receiveflag;
	private String awunit;
	private String vwunit;
	private String cwunit;
	private String pcsunit;
	private Integer uid;


	public String getKdno() {
		return kdno;
	}

	public void setKdno(String kdno) {
		this.kdno = kdno;
	}

	public String getTeamtype() {
		return teamtype;
	}

	public void setTeamtype(String teamtype) {
		this.teamtype = teamtype;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getTeamno() {
		return teamno;
	}

	public void setTeamno(String teamno) {
		this.teamno = teamno;
	}

	public String getShipper() {
		return shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public Date getDeliverytime() {
		return deliverytime;
	}

	public void setDeliverytime(Date deliverytime) {
		this.deliverytime = deliverytime;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getGtype() {
		return gtype;
	}

	public void setGtype(String gtype) {
		this.gtype = gtype;
	}

	public Double getActualweight() {
		return actualweight;
	}

	public void setActualweight(Double actualweight) {
		this.actualweight = actualweight;
	}

	public Double getVolweight() {
		return volweight;
	}

	public void setVolweight(Double volweight) {
		this.volweight = volweight;
	}

	public Double getChargeweight() {
		return chargeweight;
	}

	public void setChargeweight(Double chargeweight) {
		this.chargeweight = chargeweight;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public Integer getReceiveflag() {
		return receiveflag;
	}

	public void setReceiveflag(Integer receiveflag) {
		this.receiveflag = receiveflag;
	}

	public String getAwunit() {
		return awunit;
	}

	public void setAwunit(String awunit) {
		this.awunit = awunit;
	}

	public String getVwunit() {
		return vwunit;
	}

	public void setVwunit(String vwunit) {
		this.vwunit = vwunit;
	}

	public String getCwunit() {
		return cwunit;
	}

	public void setCwunit(String cwunit) {
		this.cwunit = cwunit;
	}

	public String getPcsunit() {
		return pcsunit;
	}

	public void setPcsunit(String pcsunit) {
		this.pcsunit = pcsunit;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}


	@Override
	public String toString() {
		return "Shipment{" +
			", kdno=" + kdno +
			", teamtype=" + teamtype +
			", teamname=" + teamname +
			", teamno=" + teamno +
			", shipper=" + shipper +
			", deliverytime=" + deliverytime +
			", receiver=" + receiver +
			", gtype=" + gtype +
			", actualweight=" + actualweight +
			", volweight=" + volweight +
			", chargeweight=" + chargeweight +
			", createtime=" + createtime +
			", modifytime=" + modifytime +
			", receiveflag=" + receiveflag +
			", awunit=" + awunit +
			", vwunit=" + vwunit +
			", cwunit=" + cwunit +
			", pcsunit=" + pcsunit +
			", uid=" + uid +
			"}";
	}
}
