package com.printsearch;

public class PrintDrawing {
	private String bearingMax;
	private String bearingMin;
	private String customer;
	private String customerPin;
	private String customerRevision;
	private String date;
	private String dateCreated;
	private String diameterHigh;
	private String diameterLow;
	private String dmgDrawingPath;
	private String drawingName;
	private String faceLengthHigh;
	private String faceLengthLow;

	private int id;
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

	public PrintDrawing() {
		// Initialize fields
		this.xlsxPath = "";
		this.xlsmPath = "";
		this.pdfPath = "";
		this.scannedPath = "";
		this.dmgDrawingPath = "";
		this.drawingName = "";
		this.revNumber = "";
		this.diameterLow = "";
		this.diameterHigh = "";
		this.faceLengthLow = "";
		this.faceLengthHigh = "";
		this.bearingMax = "";
		this.bearingMin = "";
		this.steps = "";
		this.oem = "";
		this.type = "";
		this.customer = "";
		this.originatingCustomer = "";
		this.customerPin = "";
		this.customerRevision = "";
		this.newBasePrice = "";
		this.date = "";
		this.subcontractor = "";
		this.productCode = "";
		this.prevPartNo = "";
		this.dateCreated = "";
		this.partNo = "";
	}

	public PrintDrawing(
			String bearingMax,
			String bearingMin,
			String customer,
			String customerPin,
			String customerRevision,
			String date,
			String dateCreated,
			String diameterLow,
			String diameterHigh,
			String dmgDrawingPath,
			String drawingName,
			String faceLengthLow,
			String faceLengthHigh,
			String newBasePrice,
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
		this.customer = customer;
		this.customerPin = customerPin;
		this.customerRevision = customerRevision;
		this.date = date;
		this.dateCreated = dateCreated;
		this.diameterLow = diameterLow;
		this.diameterHigh = diameterHigh;
		this.dmgDrawingPath = dmgDrawingPath;
		this.drawingName = drawingName;
		this.faceLengthLow = faceLengthLow;
		this.faceLengthHigh = faceLengthHigh;
		this.newBasePrice = newBasePrice;
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

	public String getCustomer() {
		return customer;
	}

	public String getCustomerPin() {
		return customerPin;
	}

	public String getCustomerRevision() {
		return customerRevision;
	}

	public String getDate() {
		return date;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public String getDiameterHigh() {
		return diameterHigh;
	}

	public String getDiameterLow() {
		return diameterLow;
	}

	public String getDmgDrawingPath() {
		return dmgDrawingPath;
	}

	public String getDrawingName() {
		return drawingName;
	}

	public String getFaceLengthHigh() {
		return faceLengthHigh;
	}

	public String getFaceLengthLow() {
		return faceLengthLow;
	}

	public int getId() {
		return id;
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

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setCustomerPin(String customerPin) {
		this.customerPin = customerPin;
	}

	public void setCustomerRevision(String customerRevision) {
		this.customerRevision = customerRevision;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDiameterHigh(String diameterHigh) {
		this.diameterHigh = diameterHigh;
	}

	public void setDiameterLow(String diameterLow) {
		this.diameterLow = diameterLow;
	}

	public void setDmgDrawingPath(String dmgDrawingPath) {
		this.dmgDrawingPath = dmgDrawingPath;
	}

	public void setDrawingName(String drawingName) {
		this.drawingName = drawingName;
	}

	public void setFaceLengthHigh(String faceLengthHigh) {
		this.faceLengthHigh = faceLengthHigh;
	}

	public void setFaceLengthLow(String faceLengthLow) {
		this.faceLengthLow = faceLengthLow;
	}

	public void setId(int id) {
		this.id = id;
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
		return "PrintDrawing [bearingMax=" + bearingMax + ", bearingMin=" + bearingMin + ", customer=" + customer +
				", customerPin=" + customerPin + ", customerRevision=" + customerRevision + ", date=" + date + ", dateCreated=" +
				dateCreated + ", diameterHigh=" + diameterHigh + ", diameterLow=" + diameterLow + ", dmgDrawingPath=" +
				dmgDrawingPath + ", drawingName=" + drawingName + ", faceLengthHigh=" + faceLengthHigh + ", faceLengthLow=" +
				faceLengthLow + ", id=" + id + ", newBasePrice=" + newBasePrice + ", oem=" + oem + ", originatingCustomer=" +
				originatingCustomer + ", partNo=" + partNo + ", pdfPath=" + pdfPath + ", prevPartNo=" + prevPartNo +
				", productCode=" + productCode + ", revNumber=" + revNumber + ", scannedPath=" + scannedPath + ", steps=" +
				steps + ", subcontractor=" + subcontractor + ", type=" + type + ", xlsmPath=" + xlsmPath + ", xlsxPath=" +
				xlsxPath + "]";
	}
}
