package com.adobe.aem.guides.wknd.core.models;

import javax.annotation.PostConstruct;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,resourceType = "wknd/components/mytable")
@Exporter(name="jackson",extensions = "json")
public class MyTableModel {
    private static final Logger log = LoggerFactory.getLogger(MyTableModel.class);
    @ValueMapValue
    public String noRows;
    @ValueMapValue
    public String noCols;
    @ValueMapValue
    public String option;
    public String[] numOfRowArray;
    public String[] numOfColArray;
    public boolean boolValue;
    @PostConstruct
    protected void init(){
        log.info("The value of radio button {}", option);
        boolValue = Boolean.parseBoolean(option);
        if (boolValue) {
            log.info("Success");
        }
        log.info("The value of boolvalue {}",boolValue);
        log.info("number of rows {}" , noRows);
        log.info("number of columns {}" , noCols);
        this.setNoCols(noCols);
        this.setNoRows(noRows);
        numOfRowArray = new String[Integer.parseInt(noRows)];
        numOfColArray = new String[Integer.parseInt(noCols)];
    }
    public String getNoRows() { return noRows;}
    public void setNoRows(String noRows) {
        this.noRows = noRows;
    }
    public String getNoCols() {
        return noCols;
    }
    public void setNoCols(String noCols) {
        this.noCols = noCols;
    }
    public String[] getNumOfRowArray() {
        return numOfRowArray;
    }
    public void setNumOfRowArray(String[] numOfRowArray) {
        this.numOfRowArray = numOfRowArray;
    }
    public String[] getNumOfColArray() {
        return numOfColArray;
    }
    public void setNumOfColArray(String[] numOfColArray) {
        this.numOfColArray = numOfColArray;
    }
    public String getOption() {return option;}
    public void setOption(String option) {this.option = option;}
    public boolean isBoolValue() {return boolValue;
    }

    public void setBoolValue(boolean boolValue) {
        this.boolValue = boolValue;
    }

}