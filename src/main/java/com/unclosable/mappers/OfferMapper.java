package com.unclosable.mappers;

import com.unclosable.DO.Offer;
import com.unclosable.DO.OfferExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfferMapper {
    int countByExample(OfferExample example);

    int deleteByExample(OfferExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Offer record);

    int insertSelective(Offer record);

    List<Offer> selectByExampleWithBLOBs(OfferExample example);

    List<Offer> selectByExample(OfferExample example);

    Offer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Offer record, @Param("example") OfferExample example);

    int updateByExampleWithBLOBs(@Param("record") Offer record, @Param("example") OfferExample example);

    int updateByExample(@Param("record") Offer record, @Param("example") OfferExample example);

    int updateByPrimaryKeySelective(Offer record);

    int updateByPrimaryKeyWithBLOBs(Offer record);

    int updateByPrimaryKey(Offer record);
}