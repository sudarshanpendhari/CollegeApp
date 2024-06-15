package com.codedev.college.ebook;

public class ebookData {
    private String pdfTitle,pdfUrl;

    public ebookData() {
    }

    public ebookData(String name, String pdfUrl) {
        this.pdfTitle = name;
        this.pdfUrl = pdfUrl;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String name) {
        this.pdfTitle = name;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
