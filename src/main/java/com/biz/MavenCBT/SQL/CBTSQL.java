package com.biz.MavenCBT.SQL;

public class CBTSQL {
	
	public static final String CBT_SELECTALL=" SELECT * FROM tbl_cbt ";
	public static final String CBT_FINDBYID =" SELECT * FROM tbl_cbt WHERE cb_id=#{cb_id} ";
	public static final String CBT_INSERT=" INSERT INTO tbl_cbt VALUES(seq_cbt.nextval, #{cb_Question}, #{cb_bogi}, #{cb_answer}) "; 		
	public static final String CBT_UPDATE=" UPDATE tbl_cbt SET cb_Question=#{cb_Question}, cb_bogi=#{cb_bogi}, cb_answer=#{cb_answer} WHERE cb_id=#{cb_id} ";	
	public static final String CBT_DELETE=" DELETE FROM tbl_cbt WHERE cb_id=#{cb_id} " ;

}
