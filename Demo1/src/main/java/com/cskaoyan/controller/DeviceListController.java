package com.cskaoyan.controller;

import com.cskaoyan.bean.Device;
import com.cskaoyan.utils.JsonFindRet;
import com.cskaoyan.service.DeviceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/deviceList")
public class DeviceListController {

    @Autowired
    DeviceListService service;

    HashMap<String,String> result =new HashMap<>();
    public HashMap<String, String> getResult() {
        return result;
    }
    public void setResult(HashMap<String, String> result) {
        this.result = result;
    }

    //对应 deviceList/list 查看清单
    @RequestMapping("/list")
    @ResponseBody
    public JsonFindRet getList(Integer page, Integer rows) {
        JsonFindRet result = service.getList(page,rows);
        return result;
    }

    //找到所有device的id和name
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Device> findAll(){
        return service.findAll();
    }

    //根据id找到对应device
    @ResponseBody
    @RequestMapping("/get/{deviceId}")
    public Device getDeviceById(@PathVariable String deviceId) {
        return service.selectById(deviceId);
    }


    //弹出页面的具体操作
    //增加设备
    @RequestMapping("/insert")
    @ResponseBody
    public HashMap insert(@Valid Device device, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            result.put("status",fieldError.getDefaultMessage());
            result.put("msg",fieldError.getDefaultMessage());
        }
        String id = device.getDeviceId();
        Device exists = service.selectById(id);
        //先判断有没有重复的编号 如果有 返回错误
        if(exists==null){
            result = service.insert(device);
            //再判断是否增加成功
        }else{
            result.put("status","0");
            result.put("msg","该设备种类编号已经存在，请更换设备种类编号！");
        }
        System.out.println("insert result = "+result);
        return result;
    }

    //更新
    @RequestMapping("/update")
    @ResponseBody
    public HashMap update(@Valid Device device, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            result.put("status",fieldError.getDefaultMessage());
            result.put("msg",fieldError.getDefaultMessage());
        }
        result = service.update(device);
        //再判断是否更新成功
        System.out.println("update result = "+result);
        return result;
    }

    //批量删除(也可以单选)
    @RequestMapping("/delete_batch")
    @ResponseBody
    public HashMap deleteBatch(String ids) throws Exception{
        String[] deviceIds = ids.split(",");
        result = service.deleteBatch(deviceIds);
        //返回是否删除成功
        System.out.println("deleteBatch result = "+result);
        return result;
    }

    //三例搜索(和显示list很类似)
    @RequestMapping("/search_device_by_deviceId")
    @ResponseBody
    public JsonFindRet searchDeviceByDeviceId(String searchValue, Integer page, Integer rows) {
        JsonFindRet result = service.searchDeviceByDeviceId(page,rows,searchValue);
        return result;
    }

    @RequestMapping("/search_device_by_deviceName")
    @ResponseBody
    public JsonFindRet searchDeviceByDeviceName(String searchValue, Integer page, Integer rows) {
        JsonFindRet result = service.searchDeviceByDeviceName(page,rows,searchValue);
        return result;
    }

    @RequestMapping("/search_device_by_deviceTypeName")
    @ResponseBody
    public JsonFindRet searchDeviceByDeviceTypeName(String searchValue, Integer page, Integer rows) {
        JsonFindRet result = service.searchDeviceByDeviceTypeName(page,rows,searchValue);
        return result;
    }

    //修改备注
    //更新
    @RequestMapping("/update_note")
    @ResponseBody
    public HashMap updateNote(@Valid Device device, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            result.put("status",fieldError.getDefaultMessage());
            result.put("msg",fieldError.getDefaultMessage());
        }
        result = service.updateNote(device);
        //再判断是否更新成功
        System.out.println("update result = "+result);
        return result;
    }

    //judge控制
    @RequestMapping("/add_judge")
    @ResponseBody
    public Map add_judge() throws Exception{
        return null;
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map edit_judge() throws Exception{
        return null;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map delete_judge() throws Exception{
        return null;
    }

    //弹出页面
    @RequestMapping("/add")
    public String add() throws Exception{
        return "/deviceList_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "/deviceList_edit";
    }

}
