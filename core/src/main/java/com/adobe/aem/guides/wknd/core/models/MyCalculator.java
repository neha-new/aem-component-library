package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,resourceType = "wknd/components/mycalculator")
public class MyCalculator {
    private static final Logger log = LoggerFactory.getLogger(MyCalculator.class);
    @ValueMapValue
    private String addNum1;
    @ValueMapValue
    private String addNum2;
    @ValueMapValue
    private String subNum1;
    @ValueMapValue
    private String subNum2;
    @ValueMapValue
    private String mulNum1;
    @ValueMapValue
    private String mulNum2;
    @ValueMapValue
    private String divNum1;
    @ValueMapValue
    private String divNum2;

    public String sum;
    public String subtract;
    public String mul;
    public String divide;

    @PostConstruct
    protected void init(){
         sum = addTwoNumbers(addNum1,addNum2);
         subtract = subtractTwoNumbers(subNum1,subNum2);
         mul = multiTwoNumbers(mulNum1,mulNum2);
         divide = divTwoNumbers(divNum1,divNum2);
    }
    private String addTwoNumbers(String i,String j){
        /*int tempI = Integer.valueOf(i);
        int tempJ = Integer.valueOf(j);
        int result = tempI+tempJ;
        String add = String.valueOf(result);
        return add;*/
        return String.valueOf((Integer.valueOf(i) + Integer.valueOf(j)));
    }
    private String subtractTwoNumbers(String i, String j){

        return String.valueOf((Integer.valueOf(i)-Integer.valueOf(j)));
    }

    private String multiTwoNumbers(String i, String j){
        return String.valueOf((Integer.valueOf(i)*Integer.valueOf(j)));
    }
    private String divTwoNumbers(String i, String j){
        return String.valueOf((Integer.valueOf(i)/Integer.valueOf(j)));
    }
    public String getAddNum1() {
        return addNum1;
    }
    public void setAddNum1(String addNum1) {
        this.addNum1 = addNum1;
    }
    public String getAddNum2() {
        return addNum2;
    }
    public void setAddNum2(String addNum2) {
        this.addNum2 = addNum2;
    }
    public String getSubNum1() {
        return subNum1;
    }
    public void setSubNum1(String subNum1) {
        this.subNum1 = subNum1;
    }
    public String getSubNum2() {
        return subNum2;
    }
    public void setSubNum2(String subNum2) {
        this.subNum2 = subNum2;
    }
    public String getMulNum1() {
        return mulNum1;
    }
    public void setMulNum1(String mulNum1) {
        this.mulNum1 = mulNum1;
    }
    public String getMulNum2() {
        return mulNum2;
    }
    public void setMulNum2(String mulNum2) {
        this.mulNum2 = mulNum2;
    }
    public String getDivNum1() {
        return divNum1;
    }
    public void setDivNum1(String divNum1) {
        this.divNum1 = divNum1;
    }
    public String getDivNum2() {
        return divNum2;
    }
    public void setDivNum2(String divNum2) {
        this.divNum2 = divNum2;
    }
}
