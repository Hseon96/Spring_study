package com.sist.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // outline가서 만들어져 있는지 확인!!
public class MemberVo {
	private String name,sex,loc,content;
	private String[] hobby;
}
