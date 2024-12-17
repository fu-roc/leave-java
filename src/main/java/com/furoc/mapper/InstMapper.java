package com.furoc.mapper;

import com.furoc.pojo.Free;
import com.furoc.pojo.SecondScore;
import com.furoc.vo.FreeVo;
import com.furoc.vo.LeaveCampusVo;
import com.furoc.vo.LessonLeaveVo;
import com.furoc.vo.SecondScoreVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author 13926
 * @description 针对表【teacher(教师信息表)】的数据库操作Mapper
 * @createDate 2023-06-09 11:12:59
 * @Entity com.leave.entity.Teacher
 */
@Mapper
public interface InstMapper {

    /**
     * 辅导员查询所有课程请假历史记录
     */
    List<LessonLeaveVo> selectReviewHistory(Integer tid);

    /**
     * 辅导员查询所有课程请假待审核记录
     */
    List<LessonLeaveVo> selectReviewWorking(Integer tid);

    /**
     * 辅导员审核请假的记录
     */
    int updateResult(@Param("lid") Integer lid, @Param("result") String result);

    /**
     * 出校的审核中查询
     */
    List<LeaveCampusVo> selectCampusInReview(Integer tid);

    /**
     * 修改未审核的请课记录
     */
    int updateResultInst(@Param("rid") Integer rid, @Param("resultInst") String resultInst);

    List<LeaveCampusVo> selectLeaveHistory(Integer tid);

    boolean isInst(Integer tid);

    int reviewFree(Free free);

    int reviewSecondScore(SecondScore secondScore);

    List<FreeVo> getFree(Integer tid);

    List<FreeVo> getFreeInReview(Integer tid);

    List<FreeVo> getFreeHistory(Integer tid);

    List<SecondScoreVo> getSecondScoreInReview(Integer tid);

    List<SecondScoreVo> getSecondScoreHistory(Integer tid);
}
