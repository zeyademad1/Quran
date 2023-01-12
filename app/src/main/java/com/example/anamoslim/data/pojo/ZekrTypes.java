package com.example.anamoslim.data.pojo;

import java.util.Objects;

public class ZekrTypes {

    private String zekrName;
    private int zekrImage;

    public ZekrTypes(String zekrName, int zekrImage) {
        this.zekrName = zekrName;
        this.zekrImage = zekrImage;
    }
    public ZekrTypes(String zekrName) {
        this.zekrName = zekrName;
        zekrImage = -1;
    }

    public String getZekrName() {
        return zekrName;
    }

    public int getZekrImage() {
        return zekrImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZekrTypes zekrType = (ZekrTypes) o;
        return zekrImage == zekrType.zekrImage && zekrName.equals(zekrType.zekrName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zekrName, zekrImage);
    }
}
