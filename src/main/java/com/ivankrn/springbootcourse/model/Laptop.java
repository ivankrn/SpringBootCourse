package com.ivankrn.springbootcourse.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Laptop {
    private final CPU cpu;
    @Autowired
    @Qualifier("fastSSD")
    private StorageDevice storageDevice;
    private RAM ram;

    @Autowired
    public Laptop(@Qualifier("intelCPU") CPU cpu) {
        this.cpu = cpu;
    }

    @Autowired
    public void setRam(RAM ram) {
        this.ram = ram;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Laptop is turned on!");
        System.out.println("CPU: " + this.cpu.vendor);
        System.out.println("RAM size: " + ram.getSizeInGB() + " GB");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Laptop is turned off!");
    }
}
