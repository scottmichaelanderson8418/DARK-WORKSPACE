package com.printsearch;

public class AniloxRoll {

	private String bearingMax;
	private String bearingMin;
	private String cust;
	private String custPin;
	private String custRev;
	private String date;
	private String dateCreated;
	private String dia1;
	private String dia2;
	private String dmgDrawingPath;
	private String drawingName;
	private String face1;
	private String face2;
	private String newBasePrice;
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
	public AniloxRoll() {
		// Initialize variables to default values
		this.xlsxPath = "";
		this.xlsmPath = "";
		this.pdfPath = "";
		this.scannedPath = "";
		this.dmgDrawingPath = "";
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
		this.newBasePrice = "";
		this.date = "";
		this.subcontractor = "";
		this.productCode = "";
		this.prevPartNo = "";
		this.dateCreated = "";
		this.partNo = "";
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

	public String getDmgDrawingPath() {
		return dmgDrawingPath;
	}

	public String getDrawingName() {
		return drawingName;
	}

	public String getFace1() {
		return face1;
	}

	public String getFace2() {
		return face2;
	}

	public String getNewBasePrice() {
		return newBasePrice;
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

	public void setDmgDrawingPath(String dmgDrawingPath) {
		this.dmgDrawingPath = dmgDrawingPath;
	}

	public void setDrawingName(String drawingName) {
		this.drawingName = drawingName;
	}

	public void setFace1(String face1) {
		this.face1 = face1;
	}

	public void setFace2(String face2) {
		this.face2 = face2;
	}

	public void setNewBasePrice(String newBasePrice) {
		this.newBasePrice = newBasePrice;
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

	@Override
	public String toString() {
		return "XLSX: " + xlsxPath + "\n" + "XLSM: " + xlsmPath + "\n" + "PDF: " + pdfPath + "\n" +
				"DWG: " + dmgDrawingPath + "\n" + "SCANNED: " + scannedPath + "\n" +
				"DRAWING NAME: " + drawingName + "\n" + "Rev: " + revNumber + "\n" + "DIA: " +
				dia1 + "\n" + "DIA_1: " + dia2 + "\n" + "FACE: " + face1 + "\n" + "FACE_1: " +
				face2 + "\n" + "BEARINGMAX: " + bearingMax + "\n" + "BEARINGMIN: " + bearingMin +
				"\n" + "STEPS: " + steps + "\n" + "OEM: " + oem + "\n" + "TYPE: " + type + "\n" +
				"CUST: " + cust + "\n" + "OriginatingCustomer: " + originatingCustomer + "\n" +
				"CUSTPN: " + custPin + "\n" + "CUSTREV: " + custRev + "\n" + "NEWBASEPRICE: " +
				newBasePrice + "\n" + "Date: " + date + "\n" + "SUBCONTRACTOR: " + subcontractor +
				"\n" + "PRODUCTCODE: " + productCode + "\n" + "PREVPARTNo: " + prevPartNo + "\n" +
				"DATECREATED: " + dateCreated + "\n" + "PartNo: " + partNo + "\n";
	}

	public void print() {

		System.out.printf("%-30s%-30s%n", "xlsxPath = ", this.xlsxPath);
		System.out.printf("%-30s%-30s%n", "xlsmPath = ", this.xlsmPath);
		System.out.printf("%-30s%-30s%n", "scannedPath = ", this.scannedPath);
		System.out.printf("%-30s%-30s%n", "dmgDrawingPath = ", this.dmgDrawingPath);
		System.out.printf("%-30s%-30s%n", "drawingName = ", this.drawingName);
		System.out.printf("%-30s%-30s%n", "revNumber = ", this.revNumber);
		System.out.printf("%-30s%-30s%n", "dia1 = ", this.dia1);
		System.out.printf("%-30s%-30s%n", "dia2 = ", dia2);
		System.out.printf("%-30s%-30s%n", "face1 = ", face1);
		System.out.printf("%-30s%-30s%n", "face2 = ", face2);
		System.out.printf("%-30s%-30s%n", "bearingMax = ", bearingMax);
		System.out.printf("%-30s%-30s%n", "bearingMin = ", bearingMin);
		System.out.printf("%-30s%-30s%n", "steps = ", steps);
		System.out.printf("%-30s%-30s%n", "oem = ", oem);
		System.out.printf("%-30s%-30s%n", "type = ", type);

		System.out.printf("%-30s%-30s%n", "cust = ", cust);
		System.out.printf("%-30s%-30s%n", "originatingCustomer = ", originatingCustomer);
		System.out.printf("%-30s%-30s%n", "custPin = ", custPin);
		System.out.printf("%-30s%-30s%n", "custRev = ", custRev);
		System.out.printf("%-30s%-30s%n", "newBasePrice = ", newBasePrice);
		System.out.printf("%-30s%-30s%n", "date = ", date);
		System.out.printf("%-30s%-30s%n", "subcontractor = ", subcontractor);
		System.out.printf("%-30s%-30s%n", "productCode = ", productCode);
		System.out.printf("%-30s%-30s%n", "prevPartNo = ", prevPartNo);
		System.out.printf("%-30s%-30s%n", "dateCreated = ", dateCreated);
		System.out.printf("%-30s%-30s%n", "partNo = ", partNo);

	}

}