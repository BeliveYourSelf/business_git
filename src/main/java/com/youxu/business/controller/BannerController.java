package com.youxu.business.controller;

import com.youxu.business.pojo.Banner;
import com.youxu.business.pojo.remotepojo.User;
import com.youxu.business.remoteinterface.MemberInterface;
import com.youxu.business.service.BannerService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Api(description = "banner表")
public class BannerController {
    @Resource
    private BannerService bannerService;

/*    @Autowired
    private RestTemplate restTemplate;*/

    @Resource
    private MemberInterface memberInterface;

   /* @Autowired
    private DiscoveryClient discoveryClient;*/

    @ApiOperation(value = "查看所有banner", notes = "contentType :  1.手机素材2.pc端素材")
    @GetMapping("/selectBannerList")
    public ResponseMessage<List<Banner>> selectBannerList(@RequestParam String contentType) {
        List<Banner> selectBannerList =bannerService.selectBannerList(contentType);
        if (selectBannerList.size() <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",selectBannerList);
    }

    @ApiOperation(value = "查看其中一个banner", notes = "banner的id")
    @GetMapping("/selectOneBannerById")
    public ResponseMessage<Banner> selectOneBannerById(@RequestParam String id) {
        Banner selectBannerById =bannerService.selectBannerById(id);
        if (StringUtils.isEmpty(selectBannerById)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",selectBannerById);
    }

    @ApiOperation(value = "测试feign：查看用户信息通过userId", notes = "userId")
    @GetMapping("/selectUserInfoByUId")
    public ResponseMessage<User> selectUserInfoByUId(@RequestParam("userId") String userId) {
        ResponseMessage<User> userResponseMessage = memberInterface.selectUserInfoByUId(Integer.valueOf(userId));
        User user = userResponseMessage.getData();
        if (StringUtils.isEmpty(user)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",user);
    }
    /*@ApiOperation(value = "测试：查看用户信息通过userId", notes = "userId")
    @GetMapping("/selectUserInfoOther")
    public ResponseMessage<User> selectUserInfoOther(@RequestParam("userId") String userId){
        //根据ID获取服务实力
        List<ServiceInstance> instances = discoveryClient.getInstances("useraccount");
        //获取实例ip与端口
        ServiceInstance instance = instances.get(0);
        String url="http://"+instance.getHost()+":"+instance.getPort()+"/userLogin/selectUserInfoByUId";
        User user = restTemplate.getForObject(url, User.class);
        if (StringUtils.isEmpty(user)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",user);
    }*/
}
