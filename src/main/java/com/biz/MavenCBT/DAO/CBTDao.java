package com.biz.MavenCBT.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biz.MavenCBT.SQL.CBTSQL;
import com.biz.MavenCBT.vo.CBTVO;

public interface CBTDao {
	
	@Select (CBTSQL.CBT_SELECTALL)
	public List<CBTVO> selectAll();
	@Select (CBTSQL.CBT_FINDBYID)
	public CBTVO findById(long cb_id);
	@Insert (CBTSQL.CBT_INSERT)
	public int insert (CBTVO vo);
	@Update (CBTSQL.CBT_UPDATE)
	public int update (CBTVO vo);
	@Delete (CBTSQL.CBT_DELETE)
	public int delete (long cb_id);

}
