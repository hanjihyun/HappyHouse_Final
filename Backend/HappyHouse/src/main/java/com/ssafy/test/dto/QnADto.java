package com.ssafy.test.dto;

public class QnADto {
	private int qnaNo;
	private String title;
	private String writer;
	private String content;
	private String date;
	
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "QnADto [qnaNo=" + qnaNo + ", title=" + title + ", writer=" + writer + ", content=" + content + ", date="
				+ date + "]";
	}
	
	
}
