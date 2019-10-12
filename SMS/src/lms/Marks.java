/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

/**
 *
 * @author haad4
 */
public class Marks {

    int evalType;
    int evalno;
    float evalWeight;
    int marks;
    float obtainedmarks;
    
    
      public Marks(int evaltype,int evalno,float evalweight, int marks) {
        this.evalType=evaltype;
        this.evalno = evalno;
        System.out.println(evalweight);
        this.evalWeight= evalweight;
        this.marks = marks;
    }

    public Marks(int evalType, int evalno, float obtainedmarks) {
        this.evalType = evalType;
        this.evalno = evalno;
        this.obtainedmarks = obtainedmarks;
    }

    public float getObtainedmarks() {
        return obtainedmarks;
    }
   
      
      
    public int getEvalType() {
        return evalType;
    }

    public int getEvalno() {
        return evalno;
    }

    public void setEvalType(int evalType) {
        this.evalType = evalType;
    }

    public void setEvalno(int evalno) {
        this.evalno = evalno;
    }

    public void setEvalWeight(float evalWeight) {
        this.evalWeight = evalWeight;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setObtainedmarks(int obtainedmarks) {
        this.obtainedmarks = obtainedmarks;
    }


    public int getMarks() {
        return marks;
    }

    public float getEvalWeight() {
        return evalWeight;
    }
    
    
    
    
}
