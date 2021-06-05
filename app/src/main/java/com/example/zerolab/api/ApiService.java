package com.example.zerolab.api;

import com.example.zerolab.bean.LabBean;
import com.example.zerolab.bean.LabInformationBean;
import com.example.zerolab.bean.LabInsertResponseBean;
import com.example.zerolab.bean.LoginUserBean;
import com.example.zerolab.bean.ReserveCheckBean;
import com.example.zerolab.bean.ReserveResultBean;
import com.example.zerolab.bean.ResultBean;
import com.example.zerolab.bean.ResultCheckResponseBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 将URL拆分，在这里展示URL变化的部分
 *
 * @author DELL
 */
public interface ApiService {
    /**
     * 将地址进一步拆分，将可变的一部分放在注解@GET的地址里面，其中
     * 参数放入@Query里面，因为是使用的GET请求，所以里面的内容会拼接到地址后面，并且自动会加上 & 符号
     * Call是retrofit2框架里面的，这个框架是对OKHttp的进一步封装，会让你的使用更加简洁明了，里面放入之前通过接口返回
     * 的JSON字符串生成返回数据实体Bean,Retrofit支持Gson解析实体类,所以，后面的返回值就不用做解析了。
     * getTodayWeather是这个接口的方法名。这样说应该很清楚了吧
     *
     * @param userNum
     * @param userPassword
     * @param userStatus
     *
     * @return
     * */
    @GET("/LabInformationManageService/LoginServlet?")
    Call<LoginUserBean> loginServlet(@Query("userNum") String userNum,
                                               @Query("userPassword") String userPassword,
                                               @Query("userStatus") String userStatus);

    /**
     * 获得实验室信息列表
     * @return
     * */
    @GET("/LabInformationManageService/LabInformationServlet")
    Call<LabInformationBean> labInformationServlet();

    /**
     * 查询实验室
     * @param labName
     * @return
     * */
    @GET("/LabInformationManageService/LabInformationServlet?")
    Call<LabBean> queryLab(@Query("labName") String labName);

    /**
     * 插入预约信息
     * @param stuName
     * @param stuNum
     * @param labName
     * @param experimentName
     * @param stuSum
     * @param experimentTime
     * @return
     * */
    @GET("/LabInformationManageService/ReserveServlet?")
    Call<ResultBean> insertReserve(@Query("stuName") String stuName, @Query("stuNum") String stuNum,
                                   @Query("labName") String labName, @Query("experimentName") String experimentName,
                                   @Query("stuSum") String stuSum, @Query("experimentTime") String experimentTime);

    /**
     * 查询预约结果信息
     *
     * @param stuNum
     * @return
     * */
    @GET("/LabInformationManageService/StudentResultServlet?")
    Call<ReserveResultBean> queryStuResult(@Query("stuNum") String stuNum);

    /**
     * 插入实验室信息
     * @param labNum
     * @param labName
     * @param labIntroduce
     * @param labAddress
     * @param labEquip
     * @param labOpenTime
     * @param labSum
     * @return
     * */
    @GET("/LabInformationManageService/LabInsertServlet?")
    Call<LabInsertResponseBean> insertLabInformation(@Query("labNum") String labNum, @Query("labName") String labName,
                                                     @Query("labIntroduce") String labIntroduce, @Query("labAddress") String labAddress,
                                                     @Query("labOpenTime") String labOpenTime, @Query("labSum") String labSum, @Query("labEquip") String labEquip);
    /**
     * 查询需要审核的实验室预约信息
     * @return
     * */
    @GET("/LabInformationManageService/CheckResultServlet")
    Call<ReserveCheckBean> getReserveCheckList();

    /**
     * 返回实验室预约审核结果
     * @param checkResult
     * @param checkTeacher
     * @param experimentName
     * @param stuName
     * @return
     * */
    @GET("/LabInformationManageService/EditResultServlet?")
    Call<ResultCheckResponseBean> editReserveCheck(@Query("stuName") String stuName, @Query("experimentName") String experimentName,
                                                   @Query("checkResult") String checkResult, @Query("checkTeacher") String checkTeacher);
}
