package com.pokemonreview.dto;

import java.util.Scanner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "printspecifications")

public class PrintDrawingDto {
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

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

	// Default constructor
	public PrintDrawingDto() {

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

	public PrintDrawingDto(
			int id,
			String bearingMax,
			String bearingMin,
			String cust,
			String custPin,
			String custRev,
			String date,
			String dateCreated,
			String dia1,
			String dia2,
			String dmgDrawingPath,
			String drawingName,
			String face1,
			String face2,
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
		this.id = id;
		this.bearingMax = bearingMax;
		this.bearingMin = bearingMin;
		this.cust = cust;
		this.custPin = custPin;
		this.custRev = custRev;
		this.date = date;
		this.dateCreated = dateCreated;
		this.dia1 = dia1;
		this.dia2 = dia2;
		this.dmgDrawingPath = dmgDrawingPath;
		this.drawingName = drawingName;
		this.face1 = face1;
		this.face2 = face2;
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

	public void pressEnter(final Scanner scanner) {

		scanner.nextLine();

	}

	public void print() {

		System.out.printf("%-30S%-30S%n", "xlsxPath ", this.xlsxPath);
		System.out.printf("%-30S%-30S%n", "xlsmPath", this.xlsmPath);
		System.out.printf("%-30S%-30S%n", "scannedPath", this.scannedPath);
		System.out.printf("%-30S%-30S%n", "dmgDrawingPath", this.dmgDrawingPath);
		System.out.printf("%-30S%-30S%n", "drawingName", this.drawingName);
		System.out.printf("%-30S%-30S%n", "revNumber", this.revNumber);
		System.out.printf("%-30S%-30S%n", "dia1", this.dia1);
		System.out.printf("%-30S%-30S%n", "dia2", dia2);
		System.out.printf("%-30S%-30S%n", "face1", face1);
		System.out.printf("%-30S%-30S%n", "face2", face2);
		System.out.printf("%-30S%-30S%n", "bearingMax", bearingMax);
		System.out.printf("%-30S%-30S%n", "bearingMin", bearingMin);
		System.out.printf("%-30S%-30S%n", "steps", steps);
		System.out.printf("%-30S%-30S%n", "oem", oem);
		System.out.printf("%-30S%-30S%n", "type", type);

		System.out.printf("%-30S%-30S%n", "cust", cust);
		System.out.printf("%-30S%-30S%n", "originatingCustomer", originatingCustomer);
		System.out.printf("%-30S%-30S%n", "custPin", custPin);
		System.out.printf("%-30S%-30S%n", "custRev", custRev);
		System.out.printf("%-30S%-30S%n", "newBasePrice", newBasePrice);
		System.out.printf("%-30S%-30S%n", "date", date);
		System.out.printf("%-30S%-30S%n", "subcontractor", subcontractor);
		System.out.printf("%-30S%-30S%n", "productCode", productCode);
		System.out.printf("%-30S%-30S%n", "prevPartNo", prevPartNo);
		System.out.printf("%-30S%-30S%n", "dateCreated", dateCreated);
		System.out.printf("%-30S%-30S%n", "partNo", partNo);
		System.out.println();

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

		StringBuilder sb1 = new StringBuilder();

		sb1.append(String.format("%-50S%-50S\n", "xlsxPath ", this.xlsxPath));
		sb1.append(String.format("%-50S%-50S\n", "xlsmPath", this.xlsmPath));
		sb1.append(String.format("%-50S%-50S\n", "scannedPath", this.scannedPath));
		sb1.append(String.format("%-50S%-50S\n", "dmgDrawingPath", this.dmgDrawingPath));
		sb1.append(String.format("%-50S%-50S\n", "drawingName", this.drawingName));
		sb1.append(String.format("%-50S%-50S\n", "revNumber", this.revNumber));
		sb1.append(String.format("%-50S%-50S\n", "dia1", this.dia1));
		sb1.append(String.format("%-50S%-50S\n", "dia2", dia2));
		sb1.append(String.format("%-50S%-50S\n", "face1", face1));
		sb1.append(String.format("%-50S%-50S\n", "face2", face2));
		sb1.append(String.format("%-50S%-50S\n", "bearingMax", bearingMax));
		sb1.append(String.format("%-50S%-50S\n", "bearingMin", bearingMin));
		sb1.append(String.format("%-50S%-50S\n", "steps", steps));
		sb1.append(String.format("%-50S%-50S\n", "oem", oem));
		sb1.append(String.format("%-50S%-50S\n", "type", type));
		sb1.append(String.format("%-50S%-50S\n", "cust", cust));
		sb1.append(String.format("%-50S%-50S\n", "originatingCustomer", originatingCustomer));
		sb1.append(String.format("%-50S%-50S\n", "custPin", custPin));
		sb1.append(String.format("%-50S%-50S\n", "custRev", custRev));
		sb1.append(String.format("%-50S%-50S\n", "newBasePrice", newBasePrice));
		sb1.append(String.format("%-50S%-50S\n", "date", date));
		sb1.append(String.format("%-50S%-50S\n", "subcontractor", subcontractor));
		sb1.append(String.format("%-50S%-50S\n", "productCode", productCode));
		sb1.append(String.format("%-50S%-50S\n", "prevPartNo", prevPartNo));
		sb1.append(String.format("%-50S%-50S\n", "dateCreated", dateCreated));
		sb1.append(String.format("%-50S%-50S\n", "partNo", partNo));

		return sb1.toString();
	}

}