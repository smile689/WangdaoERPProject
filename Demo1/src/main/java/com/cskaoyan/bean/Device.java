package com.cskaoyan.bean;

import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Repository
public class Device {

    @Size(max=40, message="{id.length.error}")
    private String deviceId;
    @Size(max=100, message="{name.length.error}")
    private String deviceName;

    private String deviceTypeId;

    private String deviceStatusId;

    private String deviceStatus;

    private Date devicePurchaseDate;
    @Max(value=999999999, message="{purchasePrice.length.error}")
    private BigDecimal devicePurchasePrice;

    private Date deviceManufactureDate;

    private Date deviceServiceLife;

    private String deviceKeeperId;
    @Size(max=5000, message="{note.length.error}")
    private String note;

    public Device() {
    }

    public Device(String deviceId, String deviceName,
                  String deviceTypeId, String deviceStatusId,
                  String deviceStatus, Date devicePurchaseDate,
                  BigDecimal devicePurchasePrice, Date deviceManufactureDate,
                  Date deviceServiceLife, String deviceKeeperId, String note) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceTypeId = deviceTypeId;
        this.deviceStatusId = deviceStatusId;
        this.deviceStatus = deviceStatus;
        this.devicePurchaseDate = devicePurchaseDate;
        this.devicePurchasePrice = devicePurchasePrice;
        this.deviceManufactureDate = deviceManufactureDate;
        this.deviceServiceLife = deviceServiceLife;
        this.deviceKeeperId = deviceKeeperId;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceTypeId='" + deviceTypeId + '\'' +
                ", deviceStatusId='" + deviceStatusId + '\'' +
                ", deviceStatus='" + deviceStatus + '\'' +
                ", devicePurchaseDate=" + devicePurchaseDate +
                ", devicePurchasePrice=" + devicePurchasePrice +
                ", deviceManufactureDate=" + deviceManufactureDate +
                ", deviceServiceLife=" + deviceServiceLife +
                ", deviceKeeperId='" + deviceKeeperId + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId == null ? null : deviceTypeId.trim();
    }

    public String getDeviceStatusId() {
        return deviceStatusId;
    }

    public void setDeviceStatusId(String deviceStatusId) {
        this.deviceStatusId = deviceStatusId == null ? null : deviceStatusId.trim();
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus == null ? null : deviceStatus.trim();
    }

    public Date getDevicePurchaseDate() {
        return devicePurchaseDate;
    }

    public void setDevicePurchaseDate(Date devicePurchaseDate) {
        this.devicePurchaseDate = devicePurchaseDate;
    }

    public BigDecimal getDevicePurchasePrice() {
        return devicePurchasePrice;
    }

    public void setDevicePurchasePrice(BigDecimal devicePurchasePrice) {
        this.devicePurchasePrice = devicePurchasePrice;
    }

    public Date getDeviceManufactureDate() {
        return deviceManufactureDate;
    }

    public void setDeviceManufactureDate(Date deviceManufactureDate) {
        this.deviceManufactureDate = deviceManufactureDate;
    }

    public Date getDeviceServiceLife() {
        return deviceServiceLife;
    }

    public void setDeviceServiceLife(Date deviceServiceLife) {
        this.deviceServiceLife = deviceServiceLife;
    }

    public String getDeviceKeeperId() {
        return deviceKeeperId;
    }

    public void setDeviceKeeperId(String deviceKeeperId) {
        this.deviceKeeperId = deviceKeeperId == null ? null : deviceKeeperId.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}