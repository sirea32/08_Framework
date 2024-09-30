package com.kh.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	private int bookNo;
	private String title; // bookTitle title로 수정 /* index에서는 book.title을 불러오게 되어있지만 book 클래스에서 필드 이름이 booktitle로 명명되어있다 */
	private String writer; 
	private int price; 
	
}