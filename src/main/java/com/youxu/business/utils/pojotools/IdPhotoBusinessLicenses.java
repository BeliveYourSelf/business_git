package com.youxu.business.utils.pojotools;

import lombok.Data;

@Data
public class IdPhotoBusinessLicenses {

    String file;
    // 证件照环境监测app_key
    String app_key = "e235edf918da000631b2814cfbaaad036e7f77be";

    String facepose = "50";

    String eyegaze = "50";

    String eyeskew = "50";

    String shoulderskew = "50";

    String darkillum = "50";

    String unbalanceillum = "50";

    String bfsimilarity = "50";
}
