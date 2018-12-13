package com.cskaoyan.controller;


import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.utils.JsonFindRet;
import com.cskaoyan.service.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设备维修模块
 */
@Controller
@RequestMapping("/deviceMaintain")
public class DeviceMaintainController {

    @Autowired
    DeviceMaintainService service;

    @Autowired
    DeviceController controller;

    HashMap<String,String> result =new HashMap<>();
    public HashMap<String, String> getResult() {
        return result;
    }
    public void setResult(HashMap<String, String> result) {
        this.result = result;
    }

    //对应 deviceMaintain/list 查看清单
    @RequestMapping("/list")
    @ResponseBody
    public JsonFindRet getList(Integer page, Integer rows) {
        JsonFindRet result = service.getList(page,rows);
        return result;
    }

    //找到所有deviceMaintain的id和name
    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceMaintain> findAll(){
        return service.findAll();
    }

    //根据id找到对应deviceMaintain(有地方好像需要这个方法)
    @RequestMapping("/get/{deviceMaintainId}")
    @ResponseBody
    public DeviceMaintain getDeviceById(@PathVariable String deviceMaintainId) {
        return service.selectById(deviceMaintainId);
    }


    //弹出页面的具体操作
    //增加设备
    @RequestMapping("/insert")
    @ResponseBody
    public HashMap insert(@Valid DeviceMaintain deviceMaintain, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            result.put("status",fieldError.getDefaultMessage());
            result.put("msg",fieldError.getDefaultMessage());
        }
        String id = deviceMaintain.getDeviceMaintainId();
        DeviceMaintain exists = service.selectById(id);
        //先判断有没有重复的编号 如果有 返回错误
        if(exists==null){
            result = service.insert(deviceMaintain);
            //再判断是否增加成功
        }else{
            result.put("status","0");
            result.put("msg","该设备维修编号已经存在，请更换设备检查编号！");
        }
        System.out.println("insert result = "+result);
        return result;
    }

    //更新
    @RequestMapping(path={"/update","/update_all"})
    @ResponseBody
    public HashMap update(@Valid DeviceMaintain deviceMaintain, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            result.put("status",fieldError.getDefaultMessage());
            result.put("msg",fieldError.getDefaultMessage());
        }
        result = service.update(deviceMaintain);
        //再判断是否更新成功
        System.out.println("update result = "+result);
        return result;
    }

    //批量删除(也可以单选)
    @RequestMapping("/delete_batch")
    @ResponseBody
    public HashMap deleteBatch(String ids) throws Exception{
        String[] deviceMaintainIds = ids.split(",");
        result = service.deleteBatch(deviceMaintainIds);
        //返回是否删除成功
        System.out.println("deleteBatch result = "+result);
        return result;
    }

    //二例搜索(和显示list很类似)
    @RequestMapping("/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public JsonFindRet searchDeviceMaintainByDeviceMaintainId(String searchValue, Integer page, Integer rows) {
        JsonFindRet result = service.searchDeviceMaintainByDeviceMaintainId(page,rows,searchValue);
        return result;
    }

    @RequestMapping("/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public JsonFindRet searchDeviceMaintainByDeviceName(String searchValue, Integer page, Integer rows) {
        JsonFindRet result = service.searchDeviceMaintainByDeviceFaultId(page,rows,searchValue);
        return result;
    }

    //修改备注
    //更新
    @RequestMapping("/update_note")
    @ResponseBody
    public HashMap updateNote(@Valid DeviceMaintain deviceMaintain, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            result.put("status",fieldError.getDefaultMessage());
            result.put("msg",fieldError.getDefaultMessage());
        }
        result = service.updateNote(deviceMaintain);
        //再判断是否更新成功
        System.out.println("update result = "+result);
        return result;
    }

    //judge控制
    @RequestMapping("/add_judge")
    @ResponseBody
    public HashMap add_judge(HttpSession session) throws Exception{
        String percode = "deviceMaintain:add";
        return controller.deviceJudge(session,percode);
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map edit_judge(HttpSession session) throws Exception{
        String percode = "deviceMaintain:edit";
        return controller.deviceJudge(session,percode);
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map delete_judge(HttpSession session) throws Exception{
        String percode = "deviceMaintain:delete";
        return controller.deviceJudge(session,percode);
    }

    //弹出页面
    @RequestMapping("/add")
    public String add() throws Exception{
        return "/deviceMaintain_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "/deviceMaintain_edit";
    }
}
