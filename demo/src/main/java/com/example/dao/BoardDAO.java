package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.vo.BoardVO;

public interface BoardDAO {
	public int insertBoard(BoardVO obj);
	public List<BoardVO> selectBoard(HashMap<String, Object> map);
	public BoardVO selectBoardOne(int no);
	public int updateBoard(BoardVO obj);
	public int deleteBoard(BoardVO obj);
	
	public int updateHit(int no);
	
	public int countBoard(); 
	
	public int insertBatch(List<BoardVO> list);
	//Board.insertBatch mapper
	public BoardVO selectBoardImg(int no);
	
}
