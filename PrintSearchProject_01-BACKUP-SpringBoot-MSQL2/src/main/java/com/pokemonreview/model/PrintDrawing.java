package com.pokemonreview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "printdrawingstable")

public class PrintDrawing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bearingMax;
	private String bearingMin;
	private String cust;
	private String custPin;
	private String custRev;
	private String date;
	private String dateCreated;
	private String dia1;
	private String dia2;
	private String drawingName;
	private String dwgPath;
	private String face1;
	private String face2;
	private String newBase;
	private String oem;
	private String originatingCustomer;
	private String partNo;
	private String pdfPath;
	private String prevPartNo;
	private String productCode;
	private String revNumber;
	private String scannedPath;
	private String steps;
	private String subcontractor;
	private String type;
	private String xlsmPath;
	private String xlsxPath;

	// Default constructor
	public PrintDrawing() {

		// Initialize variables to default values
		this.xlsxPath = "";
		this.xlsmPath = "";
		this.pdfPath = "";
		this.scannedPath = "";
		this.dwgPath = "";
		this.drawingName = "";
		this.revNumber = "";
		this.dia1 = "";
		this.dia2 = "";
		this.face1 = "";
		this.face2 = "";
		this.bearingMax = "";
		this.bearingMin = "";
		this.steps = "";
		this.oem = "";
		this.type = "";
		this.cust = "";
		this.originatingCustomer = "";
		this.custPin = "";
		this.custRev = "";

		this.date = "";
		this.subcontractor = "";
		this.productCode = "";
		this.prevPartNo = "";
		this.dateCreated = "";
		this.partNo = "";
		this.newBase = "";
	}

	public PrintDrawing(
			String bearingMax,
			String bearingMin,
			String cust,
			String custPin,
			String custRev,
			String date,
			String dateCreated,
			String dia1,
			String dia2,
			String drawingName,
			String dwgPath,
			String face1,
			String face2,
			int id,
			String newBase,
			String oem,
			String originatingCustomer,
			String partNo,
			String pdfPath,
			String prevPartNo,
			String productCode,
			String revNumber,
			String scannedPath,
			String steps,
			String subcontractor,
			String type,
			String xlsmPath,
			String xlsxPath) {
		super();
		this.bearingMax = bearingMax;
		this.bearingMin = bearingMin;
		this.cust = cust;
		this.custPin = custPin;
		this.custRev = custRev;
		this.date = date;
		this.dateCreated = dateCreated;
		this.dia1 = dia1;
		this.dia2 = dia2;
		this.drawingName = drawingName;
		this.dwgPath = dwgPath;
		this.face1 = face1;
		this.face2 = face2;
		this.id = id;
		this.newBase = newBase;
		this.oem = oem;
		this.originatingCustomer = originatingCustomer;
		this.partNo = partNo;
		this.pdfPath = pdfPath;
		this.prevPartNo = prevPartNo;
		this.productCode = productCode;
		this.revNumber = revNumber;
		this.scannedPath = scannedPath;
		this.steps = steps;
		this.subcontractor = subcontractor;
		this.type = type;
		this.xlsmPath = xlsmPath;
		this.xlsxPath = xlsxPath;
	}

	public String getBearingMax() {
		return bearingMax;
	}

	public String getBearingMin() {
		return bearingMin;
	}

	public String getCust() {
		return cust;
	}

	public String getCustPin() {
		return custPin;
	}

	public String getCustRev() {
		return custRev;
	}

	public String getDate() {
		return date;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public String getDia1() {
		return dia1;
	}

	public String getDia2() {
		return dia2;
	}

	public String getDrawingName() {
		return drawingName;
	}

	public String getDwgPath() {
		return dwgPath;
	}

	public String getFace1() {
		return face1;
	}

	public String getFace2() {
		return face2;
	}

	public int getId() {
		return id;
	}

	public String getNewBase() {
		return newBase;
	}

	public String getOem() {
		return oem;
	}

	public String getOriginatingCustomer() {
		return originatingCustomer;
	}

	public String getPartNo() {
		return partNo;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public String getPrevPartNo() {
		return prevPartNo;
	}

	public String getProductCode() {
		return productCode;
	}

	public String getRevNumber() {
		return revNumber;
	}

	public String getScannedPath() {
		return scannedPath;
	}

	public String getSteps() {
		return steps;
	}

	public String getSubcontractor() {
		return subcontractor;
	}

	public String getType() {
		return type;
	}

	public String getXlsmPath() {
		return xlsmPath;
	}

	public String getXlsxPath() {
		return xlsxPath;
	}

	public void setBearingMax(String bearingMax) {
		this.bearingMax = bearingMax;
	}

	public void setBearingMin(String bearingMin) {
		this.bearingMin = bearingMin;
	}

	public void setCust(String cust) {
		this.cust = cust;
	}

	public void setCustPin(String custPin) {
		this.custPin = custPin;
	}

	public void setCustRev(String custRev) {
		this.custRev = custRev;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDia1(String dia1) {
		this.dia1 = dia1;
	}

	public void setDia2(String dia2) {
		this.dia2 = dia2;
	}

	public void setDrawingName(String drawingName) {
		this.drawingName = drawingName;
	}

	public void setDwgPath(String dwgPath) {
		this.dwgPath = dwgPath;
	}

	public void setFace1(String face1) {
		this.face1 = face1;
	}

	public void setFace2(String face2) {
		this.face2 = face2;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNewBase(String newBase) {
		this.newBase = newBase;
	}

	public void setOem(String oem) {
		this.oem = oem;
	}

	public void setOriginatingCustomer(String originatingCustomer) {
		this.originatingCustomer = originatingCustomer;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	public void setPrevPartNo(String prevPartNo) {
		this.prevPartNo = prevPartNo;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setRevNumber(String revNumber) {
		this.revNumber = revNumber;
	}

	public void setScannedPath(String scannedPath) {
		this.scannedPath = scannedPath;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public void setSubcontractor(String subcontractor) {
		this.subcontractor = subcontractor;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setXlsmPath(String xlsmPath) {
		this.xlsmPath = xlsmPath;
	}

	public void setXlsxPath(String xlsxPath) {
		this.xlsxPath = xlsxPath;
	}

}