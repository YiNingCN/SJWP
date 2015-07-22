package com.soujuw.android.partner.Database;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class UsedHouseContract
        implements BaseColumns {
    public static final String TABLE_NAME = "UsedHouse";

    public static final String CONTENT_URI_PATH = "UsedHouse";
    public static final String AUTHORITY = "com.soujuw.android.partner.Database";

    public static final String MIMETYPE_TYPE = "sjw_used_house";
    public static final String MIMETYPE_NAME = "com.soujuw.android.partner.Database";

    public static final int CONTENT_URI_PATTERN_MANY = 1;
    public static final int CONTENT_URI_PATTERN_ONE = 2;

    public static final Uri CONTENT_URI = new Uri.Builder().scheme(ContentResolver.SCHEME_CONTENT).authority(AUTHORITY).appendPath(CONTENT_URI_PATH).build();
    public static final String VILLAGEID = "VILLAGEID";
    public static final String VILLAGENAME = "VILLAGENAME";
    public static final String VILLAGEADDRESS = "VILLAGEADDRESS";
    public static final String SHINUM = "SHINUM";
    public static final String TINGNUM = "TINGNUM";
    public static final String WEINUM = "WEINUM";
    public static final String BUILDAREA = "BUILDAREA";
    public static final String FACTAREA = "FACTAREA";
    public static final String FLOOR = "FLOOR";
    public static final String TOTALFLOOR = "TOTALFLOOR";
    public static final String ORIENTATION = "ORIENTATION";
    public static final String BUILDDECON = "BUILDDECON";
    public static final String HOUSETYPE = "HOUSETYPE";
    public static final String DECORATION = "DECORATION";
    public static final String BUILDYEAR = "BUILDYEAR";
    public static final String HOUSINGPROPERTY = "HOUSINGPROPERTY";
    public static final String PROPERTYYEAR = "PROPERTYYEAR";
    public static final String LIFT = "LIFT";
    public static final String PRICE = "PRICE";
    public static final String HOUSETITLE = "HOUSETITLE";
    public static final String HOUSEDESC = "HOUSEDESC";
    public static final String LABEL1 = "LABEL1";
    public static final String LABEL2 = "LABEL2";
    public static final String LABEL3 = "LABEL3";
    public static final String LABEL4 = "LABEL4";
    public static final String CREATTIME = "CREATTIME";
    public static final String DELSTATE = "DELSTATE";
    public static final String ENTRUSTER = "ENTRUSTER";
    public static final String CITYID = "CITYID";
    public static final String AREAID = "AREAID";
    public static final String OWNERTYPE = "OWNERTYPE";
    public static final String ISENTRUST = "ISENTRUST";
    public static final String OWNERID = "OWNERID";
    public static final String EXCLUSIVESTATE = "EXCLUSIVESTATE";
    public static final String PROCESSSTATE = "PROCESSSTATE";
    public static final String CHECKTIME = "CHECKTIME";
    public static final String COUNT = "COUNT";
    public static final String CYJPRICE = "CYJPRICE";
    public static final String QUINUM = "QUINUM";
    public static final String HOUSENAME = "HOUSENAME";
    public static final String HOUSEMOBILE = "HOUSEMOBILE";
    public static final String EXCLUSIVEID = "EXCLUSIVEID";
    public static final String ENTRUSTNAME = "ENTRUSTNAME";
    public static final String ENTRUSTCARD = "ENTRUSTCARD";
    public static final String ENTRUSTFLOOR = "ENTRUSTFLOOR";
    public static final String EXCLUSIVENUM = "EXCLUSIVENUM";
    public static final String EXCLUSIVEFLOOR = "EXCLUSIVEFLOOR";
    public static final String EXCLUSIVECREATETIME = "EXCLUSIVECREATETIME";
    public static final String EXCLUSIVEENDTIME = "EXCLUSIVEENDTIME";
    public static final String ENTRUSTCREATETIME = "ENTRUSTCREATETIME";
    public static final String ENTRUSTENDTIME = "ENTRUSTENDTIME";
    public static final String NOTREASON = "NOTREASON";
    public static final String LONGITUDE = "LONGITUDE";
    public static final String LATITUDE = "LATITUDE";

    private UsedHouseContract() {
    }
}

