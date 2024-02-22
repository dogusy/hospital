package com.example.hospitalRecord.enums;

import java.util.Arrays;

public enum HospitalTypes {

    DENTIST("Diş Hastahanesi"), EYE("Göz Hastahanesi"),GENERAL("Genel Hastahane"),OTHER("Diğer");
    private String hospitalType;

    HospitalTypes(String hospitalType) {
        this.hospitalType=hospitalType;
    }


    public static String[] getHospitalTypes(){
        return Arrays.stream(HospitalTypes.values()).map(e->e.hospitalType).toArray(String[]::new);
    }


}
