package com.oazofeifa.tcudrake.Persistence.Entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "blog_entry", schema = "drake", catalog = "")
public class BlogEntry {
    private int entryId;
    private Timestamp creationTimestamp;
    private Timestamp broadcastingDate;
    private Integer likes;
    private String titleEntry;
    private String abstractEntry;
    private String contentEntry;
    private byte[] news;
    private String useremailFk;
    private String imageUrl;

    @Id
    @Column(name = "entry_id")
    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    @Basic
    @Column(name = "creation_timestamp")
    public Timestamp getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Timestamp creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    @Basic
    @Column(name = "broadcasting_date")
    public Timestamp getBroadcastingDate() {
        return broadcastingDate;
    }

    public void setBroadcastingDate(Timestamp broadcastingDate) {
        this.broadcastingDate = broadcastingDate;
    }

    @Basic
    @Column(name = "title_entry")
    public String getTitleEntry() {
        return titleEntry;
    }

    public void setTitleEntry(String titleEntry) {
        this.titleEntry = titleEntry;
    }

    @Basic
    @Column(name = "abstract_entry")
    public String getAbstractEntry() {
        return abstractEntry;
    }

    public void setAbstractEntry(String abstractEntry) {
        this.abstractEntry = abstractEntry;
    }

    @Basic
    @Column(name = "content_entry")
    public String getContentEntry() {
        return contentEntry;
    }

    public void setContentEntry(String contentEntry) {
        this.contentEntry = contentEntry;
    }

    @Basic
    @Column(name = "news")
    public byte[] getNews() {
        return news;
    }

    public void setNews(byte[] news) {
        this.news = news;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogEntry blogEntry = (BlogEntry) o;
        return entryId == blogEntry.entryId &&
                Objects.equals(creationTimestamp, blogEntry.creationTimestamp) &&
                Objects.equals(broadcastingDate, blogEntry.broadcastingDate) &&
                Objects.equals(likes, blogEntry.likes) &&
                Objects.equals(titleEntry, blogEntry.titleEntry) &&
                Objects.equals(abstractEntry, blogEntry.abstractEntry) &&
                Objects.equals(contentEntry, blogEntry.contentEntry) &&
                Arrays.equals(news, blogEntry.news);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(entryId, creationTimestamp, broadcastingDate, likes, titleEntry, abstractEntry, contentEntry);
        result = 31 * result + Arrays.hashCode(news);
        return result;
    }

    @Basic
    @Column(name = "useremail_fk")
    public String getUseremailFk() {
        return useremailFk;
    }

    public void setUseremailFk(String useremailFk) {
        this.useremailFk = useremailFk;
    }

    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
