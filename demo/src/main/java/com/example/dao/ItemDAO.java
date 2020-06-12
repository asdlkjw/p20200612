package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vo.ItemVO;


@Service
@Transactional
public class ItemDAO {
	@Autowired  //@Bean으로 만들어진 객체를 받아옴.
	private SqlSessionFactory sqlFactory = null;
	
	public  List<ItemVO> selectItemList(HashMap<String, Object> map) {
		return sqlFactory.openSession().selectList("Item.list", map);
	}
	
	public int countItem() {
	return sqlFactory.openSession().selectOne("Item.count");
	}
	public ItemVO selectItemOne(int no) {
	return sqlFactory.openSession().selectOne("Item.selectOne", no);
	}
	
	public List<ItemVO> selectItemSearch(String txt) {
		return sqlFactory.openSession().selectList("Item.listsearch", txt);
	}
	
	public int insertItemBatch(List<ItemVO> list) {
	return sqlFactory.openSession().insert("Item.insertItemBatch", list);
	}
	
	public int deleteItemBatch(int[] no) {
		return sqlFactory.openSession().insert("Item.deleteItemBatch", no);
	}
	
	public List<ItemVO> selectItemWhere(int[] itemno) {
		return sqlFactory.openSession().selectList("Item.selectItemWhere", itemno);
	}
	
	public int updateItemBatch(List<ItemVO> list) {
	return sqlFactory.openSession().update("Item.updateItemBatch", list);
	}
}