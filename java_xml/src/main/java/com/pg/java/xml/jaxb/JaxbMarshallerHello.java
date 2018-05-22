package com.pg.java.xml.jaxb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class JaxbMarshallerHello {

	public static void main(String[] args) throws ParseException {
		pojoToXmlTest();
	}

	private static void pojoToXmlTest() throws ParseException {
		AccountCmmBo act = new AccountCmmBo();
		act.setActId("13706");
		act.setActType("13706");
		act.setActOwnerCd("13706");
		act.setFirmCd("01");
		act.setImsNum("03165891");
		act.setLastTradeDt(new SimpleDateFormat("mm-dd-yyyy").parse("01-01-2000"));
		act.setMnemonic("ST13400");
		act.setPrimeLoc("Tampa");
		act.setUsPersonFlg(false);
		
		marshallToXml(act);
	}

	public static void marshallToXml(Object object){
		
		
		try {
			
			JAXBContext jaxbContext =  JAXBContext.newInstance(object.getClass());
			
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			marshaller.marshal(object, System.out);
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
	}
}

@XmlRootElement(name="Account")
class AccountCmmBo {
	
	@XmlElement(name="ActId")
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}

	@XmlElement(name="AccountType")
	public String getActType() {
		return actType;
	}
	public void setActType(String actType) {
		this.actType = actType;
	}
	
	@XmlElement(name="AccountOwnershipCode")
	public String getActOwnerCd() {
		return actOwnerCd;
	}
	public void setActOwnerCd(String actOwnerCd) {
		this.actOwnerCd = actOwnerCd;
	}
	
	@XmlElement(name="USPersonFlag")	
	public boolean isUsPersonFlg() {
		return usPersonFlg;
	}
	public void setUsPersonFlg(boolean usPersonFlg) {
		this.usPersonFlg = usPersonFlg;
	}
	
	@XmlElement(name="FirmCode")
	public String getFirmCd() {
		return firmCd;
	}
	public void setFirmCd(String firmCd) {
		this.firmCd = firmCd;
	}
	
	@XmlElement(name="PrimaryLocation")
	public String getPrimeLoc() {
		return primeLoc;
	}
	public void setPrimeLoc(String primeLoc) {
		this.primeLoc = primeLoc;
	}
	
	@XmlElement(name="Mnemonic")
	public String getMnemonic() {
		return mnemonic;
	}
	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}
	
	@XmlElement(name="IMSNumber")
	public String getImsNum() {
		return imsNum;
	}
	public void setImsNum(String imsNum) {
		this.imsNum = imsNum;
	}
	
	@XmlElement(name="LastTradeDate")
	public Date getLastTradeDt() {
		return lastTradeDt;
	}
	public void setLastTradeDt(Date lastTradeDt) {
		this.lastTradeDt = lastTradeDt;
	}

	public String toString(){
		return this.actId+" , "+this.actOwnerCd+" , "+this.actType+" , "+this.firmCd;
	}

	private String actId; 
	private String actType;
	private String actOwnerCd;
	private boolean usPersonFlg;
	private String firmCd;
	private String primeLoc;
	private String mnemonic; 
	private String imsNum; 
	private Date lastTradeDt;


}
