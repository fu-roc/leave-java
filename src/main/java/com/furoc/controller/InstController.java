package com.furoc.controller;

import com.furoc.controller.utils.Result;
import com.furoc.pojo.Free;
import com.furoc.pojo.LeaveCampus;
import com.furoc.pojo.LessonLeave;
import com.furoc.pojo.SecondScore;
import com.furoc.service.InstService;
import com.furoc.utils.JwtUtils;
import com.furoc.vo.FreeVo;
import com.furoc.vo.LeaveCampusVo;
import com.furoc.vo.LessonLeaveVo;
import com.furoc.vo.SecondScoreVo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/inst")
public class InstController {
    private final InstService instService;

    public InstController(InstService instService) {
        this.instService = instService;
    }

    /**
     * 辅导员查询所有课程请假记录,1为获取历史,0为获取审核中
     */
    @GetMapping("/lessonInReview/{id}")
    public Result allinReview(HttpServletRequest req,@PathVariable Integer id) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (instService.findIsInst(tid)) {
            List<LessonLeaveVo> data = instService.findAllinReview(tid,id);
            return Result.success(data);
        } else return Result.error("不是辅导员");
    }

    /**
     * 审核请课记录
     */
    @PutMapping("/examineInReview")
    public Result examineInReview(@RequestBody LessonLeave lessonLeave, HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (instService.findIsInst(tid)) {
            int row = instService.queryInReview(lessonLeave.getRid(),lessonLeave.getResultInst());
            if (row != 0) {
                return Result.success("更新成功");
            } else return Result.error("更新失败");
        } else return Result.error("不是辅导员");
    }

    /**
     * 出校的审核中查询
     */
    @GetMapping("/campusInReview")
    public Result campusInReview(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (instService.findIsInst(tid)) {
            List<LeaveCampusVo> data = instService.findCampusInReview(tid);
            return Result.success(data);
        } else return Result.error("不是辅导员");
    }

    /**
     * 辅导员修改出校请假的记录
     */
    @PutMapping("/examine")
    public Result examine(@RequestBody LeaveCampus leaveInfo, HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (instService.findIsInst(tid)) {
            int row = instService.queryResult(leaveInfo.getLid(), leaveInfo.getResult());
            if (row != 0) {
                return Result.success("更新了成功");
            } else return Result.error("更新失败");
        } else return Result.error("不是辅导员");
    }

    /**
     * 所有请假出校历史记录
     */
    @GetMapping("/leaveHistory")
    public Result LeaveHistory(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (instService.findIsInst(tid)) {
            List<LeaveCampusVo> data = instService.queryAllLeave(tid);
            return Result.success(data);
        } else return Result.error("不是辅导员");
    }

    /**
     * 审核申请免听免修
     *
     * @param free
     * @param req
     * @return
     */
    @PutMapping("/reviewFree")
    public Result reviewApplication(@RequestBody Free free, HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (instService.findIsInst(tid)) {
            int row = instService.reviewFree(free);
            if (row != 0) {
                return Result.success("更新成功");
            } else return Result.error("更新失败");
        } else return Result.error("不是辅导员");
    }

    /**
     * 获取学生免听免修记录
     *
     * @param req
     * @return
     */
    @GetMapping("/getFree")
    public Result getFree(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (instService.findIsInst(tid)) {
            List<FreeVo> data = instService.getFree(tid);
            if (data != null) {
                return Result.success(data);
            } else return Result.error("获取失败");
        }
        return Result.error("不是辅导员");
    }

    /**
     * 获取免听免修待审核记录
     *
     * @param req
     * @return
     */
    @GetMapping("/getFreeInReview")
    public Result getFreeInReview(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (instService.findIsInst(tid)) {
            List<FreeVo> data = instService.getFreeInReview(tid);
            if (data != null) {
                return Result.success(data);
            } else return Result.error("获取失败");
        }
        return Result.error("不是辅导员");
    }

    /**
     * 获取学生免听免修历史记录
     *
     * @param req
     * @return
     */
    @GetMapping("/getFreeHistory")
    public Result getFreeHistory(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (instService.findIsInst(tid)) {
            List<FreeVo> data = instService.getFreeHistory(tid);
            if (data != null) {
                return Result.success(data);
            } else return Result.error("获取失败");
        }
        return Result.error("不是辅导员");
    }

    /**
     * 审核二课成绩记录
     *
     * @param secondScore
     * @param req
     * @return
     */
    @PutMapping("/reviewSecondScore")
    public Result reviewSecondScore(@RequestBody SecondScore secondScore, HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (instService.findIsInst(tid)) {
            int row = instService.reviewSecondScore(secondScore);
            if (row != 0) return Result.success("更新成功");
            else return Result.error("更新失败");
        } else return Result.error("不是辅导员");
    }

    /**
     * 获取二课记录,1为获取历史,0为获取审核中
     */
    @GetMapping("/getSecondScoreInReview/{id}")
    public Result getSecondScoreInReview(HttpServletRequest req,@PathVariable Integer id) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (instService.findIsInst(tid)) {
            List<SecondScoreVo> data = instService.getSecondScoreInReview(tid,id);
            if (data != null) {
                return Result.success(data);
            } else return Result.error("获取失败");
        }
        return Result.error("不是辅导员");
    }
}
