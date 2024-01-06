package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 我的笔记
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@TableName("my_notes")
public class MyNotes implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "note_id", type = IdType.AUTO)
    private Integer noteId;

    private String userId;

    private String title;

    private String noteDate;

    private String content;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MyNotes{" +
                "noteId=" + noteId +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", noteDate=" + noteDate +
                ", content='" + content + '\'' +
                '}';
    }
}
