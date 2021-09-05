/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Orazio
 * @author Alessandro
 */
public class TestResult implements Serializable{
    private int cycle;
    private String directory;
    private double meanAdd;
    private double meanDownload;
    private double stdAdd;
    private double stdDownload;
    private String timestamp;
    private int state;

    public TestResult(int cycle, String directory, double meanAdd, double meanDownload, double stdAdd, double stdDownload, int state, String timestamp) {
        this.cycle = cycle;
        this.directory = directory;
        this.meanAdd = meanAdd;
        this.meanDownload = meanDownload;
        this.stdAdd = stdAdd;
        this.stdDownload = stdDownload;
        this.timestamp = timestamp;
        this.state = state;
    }
    
    public int getCycle() {
        return cycle;
    }

    public String getDirectory() {
        return directory;
    }

    public double getMeanAdd() {
        return meanAdd;
    }

    public double getMeanDownload() {
        return meanDownload;
    }

    public double getStdAdd() {
        return stdAdd;
    }

    public double getStdDownload() {
        return stdDownload;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getState() {
        return state;
    }

    /**
     * 
     * @return Serialized Object as a byte
     */
    public byte[] serialize() throws IOException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        out = new ObjectOutputStream(bos);   
        out.writeObject(this);
        out.flush();
        return bos.toByteArray();
    }
    
    @Override
    public String toString() {
        return "TestResult{" + "cycle=" + cycle + ", directory=" + directory + ", meanAdd=" + meanAdd + ", meanDownload=" + meanDownload + ", stdAdd=" + stdAdd + ", stdDownload=" + stdDownload + ", timestamp=" + timestamp + ", state=" + state + '}';
    }
}
