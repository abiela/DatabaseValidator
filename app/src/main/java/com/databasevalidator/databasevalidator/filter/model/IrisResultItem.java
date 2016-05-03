package com.databasevalidator.databasevalidator.filter.model;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class IrisResultItem implements ResultItem {

    private Double leafLength;
    private Double leafWidth;
    private Double petalLength;
    private Double petalWidth;
    private String className;

    public IrisResultItem(Double leafLength, Double leafWidth, Double petalLength, Double petalWidth, String className) {
        this.leafLength = leafLength;
        this.leafWidth = leafWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.className = className;
    }

    public Double getLeafLength() {
        return leafLength;
    }

    public void setLeafLength(Double leafLength) {
        this.leafLength = leafLength;
    }

    public Double getLeafWidth() {
        return leafWidth;
    }

    public void setLeafWidth(Double leafWidth) {
        this.leafWidth = leafWidth;
    }

    public Double getPetalLength() {
        return petalLength;
    }

    public void setPetalLength(Double petalLength) {
        this.petalLength = petalLength;
    }

    public Double getPetalWidth() {
        return petalWidth;
    }

    public void setPetalWidth(Double petalWidth) {
        this.petalWidth = petalWidth;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
