package com.service.crimefin.domain;

public class HistoryVO {
    private String historyId; //이력 아이디
    private String memberId; //사용자 아이디
    private String historyDate; //조회 일자
    private String phishingId; //파싱 아이디

    private PhishingInfoVO phishingInfoVO;

    public HistoryVO() {}

    public HistoryVO(String historyId, String memberId, String historyDate, String phishingId) {
        this.historyId = historyId;
        this.memberId = memberId;
        this.historyDate = historyDate;
        this.phishingId = phishingId;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getUserId() {
        return memberId;
    }

    public void setUserId(String memberId) {
        this.memberId = memberId;
    }

    public String getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(String historyDate) {
        this.historyDate = historyDate;
    }

    public String getPhishingId() {
        return phishingId;
    }

    public void setPhishingId(String phishingId) {
        this.phishingId = phishingId;
    }

    public PhishingInfoVO getPhishingInfoVO() {
        return phishingInfoVO;
    }

    public void setPhishingInfoVO(PhishingInfoVO phishingInfoVO) {
        this.phishingInfoVO = phishingInfoVO;
    }

    @Override
    public String toString() {
        return "HistoryVO{" +
                "historyId='" + historyId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", historyDate='" + historyDate + '\'' +
                ", phishingId='" + phishingId + '\'' +
                ", phishingInfoVO=" + phishingInfoVO +
                '}';
    }
}
