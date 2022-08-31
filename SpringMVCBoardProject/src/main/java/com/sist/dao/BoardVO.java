package com.sist.dao;
import java.util.*;

/*import com.sun.istack.NotNull;*/

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BoardVO {
	private int no,hit;
	/*
	 * @NotNull // 유효성 검사 
	 * private String name1;
	 */
	private String name,subject,content,pwd,dbday;
	private Date regdate;
}
