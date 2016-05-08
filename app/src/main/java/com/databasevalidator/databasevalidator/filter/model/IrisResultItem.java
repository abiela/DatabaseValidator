package com.databasevalidator.databasevalidator.filter.model;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class IrisResultItem implements ResultItem {

    public Double leafLength;
    public Double leafWidth;
    public Double petalLength;
    public Double petalWidth;
    public String similarityRate;
    public String className;

    public IrisResultItem(Double leafLength, Double leafWidth, Double petalLength, Double petalWidth, String className, String similarityRate) {
        this.leafLength = leafLength;
        this.leafWidth = leafWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.className = className;
        this.similarityRate = similarityRate;
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

    public String getSimilarityRate() {
        return similarityRate;
    }

    public void setSimilarityRate(String similarityRate) {
        this.similarityRate = similarityRate;
    }
}
