package com.furoc.service;

import com.furoc.pojo.Free;
import com.furoc.pojo.SecondScore;
import com.furoc.vo.FreeVo;
import com.furoc.vo.LeaveCampusVo;
import com.furoc.vo.LessonLeaveVo;
import com.furoc.vo.SecondScoreVo;

import java.util.List;


public interface InstService {

    /**
     * 辅导员查询所有请假审核中记录
     */
    public List<LessonLeaveVo> findAllinReview(Integer tid,Integer id);

    public int queryResult(Integer lid, String result);

    public List<LeaveCampusVo> findCampusInReview(Integer tid);

    /**
     * 修改未审核的请课记录
     */
    public int queryInReview(Integer rid, String resultInst);

    public List<LeaveCampusVo> queryAllLeave(Integer tid);

    public boolean findIsInst(Integer tid);

    public int reviewFree(Free free);

    public int reviewSecondScore(SecondScore secondScore);

    public List<FreeVo> getFree(Integer tid);

    public List<FreeVo> getFreeInReview(Integer tid);

    public List<FreeVo> getFreeHistory(Integer tid);

    public List<SecondScoreVo> getSecondScoreInReview(Integer tid,Integer id);

}
