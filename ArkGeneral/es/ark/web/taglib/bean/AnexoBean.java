// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 10/08/2012 1:59:23
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   AnexoBean.java

package es.ark.web.taglib.bean;


public class AnexoBean
{

    public AnexoBean()
    {
        contentType = null;
        fileName = null;
        fileSize = 0;
        fileData = null;
    }

    public String getContentType()
    {
        return contentType;
    }

    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    public byte[] getFileData()
    {
        return fileData;
    }

    public void setFileData(byte fileData[])
    {
        this.fileData = fileData;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public int getFileSize()
    {
        return fileSize;
    }

    public void setFileSize(int fileSize)
    {
        this.fileSize = fileSize;
    }

    String contentType;
    String fileName;
    int fileSize;
    byte fileData[];
}