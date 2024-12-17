package com.furoc.service.impl;

import com.furoc.mapper.InstMapper;
import com.furoc.pojo.Free;
import com.furoc.pojo.SecondScore;
import com.furoc.service.InstService;
import com.furoc.vo.FreeVo;
import com.furoc.vo.LeaveCampusVo;
import com.furoc.vo.LessonLeaveVo;
import com.furoc.vo.SecondScoreVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InstServiceimpl implements InstService {
    private final InstMapper instMapper;

    public InstServiceimpl(InstMapper instMapper) {
        this.instMapper = instMapper;
    }

    /**
     * 辅导员查询所有请假审核中记录
     */
    @Override
    public List<LessonLeaveVo> findAllinReview(Integer tid,Integer id) {
        List<LessonLeaveVo> result = new ArrayList<>();
        if (id == 1)
            result = instMapper.selectReviewHistory(tid);
        else if(id == 0)
            result = instMapper.selectReviewWorking(tid);
        return result;
    }

    @Override
    public int queryResult(Integer lid, String result) {
        return instMapper.updateResult(lid, result);
    }

    @Override
    public List<LeaveCampusVo> findCampusInReview(Integer tid) {
        return instMapper.selectCampusInReview(tid);
    }

    /**
     * 修改未审核的请课记录
     */
    @Override
    public int queryInReview(Integer rid, String resultInst) {
        return instMapper.updateResultInst(rid, resultInst);
    }

    @Override
    public List<LeaveCampusVo> queryAllLeave(Integer tid) {
        return instMapper.selectLeaveHistory(tid);
    }

    @Override
    public boolean findIsInst(Integer tid) {
        return instMapper.isInst(tid);
    }

    @Override
    public int reviewFree(Free free) {
        return instMapper.reviewFree(free);
    }

    @Override
    public int reviewSecondScore(SecondScore secondScore) {
        return instMapper.reviewSecondScore(secondScore);
    }

    @Override
    public List<FreeVo> getFree(Integer tid) {
        return instMapper.getFree(tid);
    }


    @Override
    public List<FreeVo> getFreeInReview(Integer tid) {
        return instMapper.getFreeInReview(tid);
    }

    @Override
    public List<FreeVo> getFreeHistory(Integer tid) {
        return instMapper.getFreeHistory(tid);
    }

    @Override
    public List<SecondScoreVo> getSecondScoreInReview(Integer tid,Integer id) {
        List<SecondScoreVo> secondScoreInReview = new ArrayList<>();
        if (id == 1)
            secondScoreInReview = instMapper.getSecondScoreHistory(tid);
        else if (id == 0)
            secondScoreInReview = instMapper.getSecondScoreInReview(tid);
        return  secondScoreInReview;
    }
}
