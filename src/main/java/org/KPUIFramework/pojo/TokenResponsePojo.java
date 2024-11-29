package org.KPUIFramework.pojo;

public class TokenResponsePojo {

    private String accessToken;
    private String refreshToken;
    private String expiresIn;
    private PartnerResponsePojo partner;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public PartnerResponsePojo getPartner() {
        return partner;
    }

    public void setPartner(PartnerResponsePojo partner) {
        this.partner = partner;
    }
}
