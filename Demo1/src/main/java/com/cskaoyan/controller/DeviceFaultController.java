package com.cskaoyan.controller;


import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.bean.pojo.EUDataGridResult;
import com.cskaoyan.service.DeviceFaultService;
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
@RequestMapping("/deviceFault")
public class DeviceFaultController {

    @Autowired
    DeviceFaultService service;

    HashMap<String,String> result =new HashMap<>();
    public HashMap<String, String> getResult() {
        return result;
    }
    public void setResult(HashMap<String, String> result) {
        this.result = result;
    }

    //对应 deviceFault/list 查看清单
    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getList(Integer page, Integer rows) {
        EUDataGridResult result = service.getList(page,rows);
        return result;
    }

    //找到所有deviceFault的id和name
    @ResponseBody
    @RequestMapping("/get_data")
    public List<DeviceFault> findAll(){
        return service.findAll();
    }

    //根据id找到对应deviceFault(有地方好像需要这个方法)
    @ResponseBody
    @RequestMapping("/get/{deviceFaultId}")
    public DeviceFault getDeviceById(@PathVariable String deviceFaultId) {
        return service.selectById(deviceFaultId);
    }


    //弹出页面的具体操作
    //增加设备
    @RequestMapping("/insert")
    @ResponseBody
    public HashMap insert(@Valid DeviceFault deviceFault, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            result.put("status",fieldError.getDefaultMessage());
            result.put("msg",fieldError.getDefaultMessage());
        }
        String id = deviceFault.getDeviceFaultId();
        DeviceFault exists = service.selectById(id);
        //先判断有没有重复的编号 如果有 返回错误
        if(exists==null){
            result = service.insert(deviceFault);
            //再判断是否增加成功
        }else{
            result.put("status","0");
            result.put("msg","该设备故障编号已经存在，请更换设备检查编号！");
        }
        System.out.println("insert result = "+result);
        return result;
    }

    //更新
    @RequestMapping("/update")
    @ResponseBody
    public HashMap update(@Valid DeviceFault deviceFault, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            result.put("status",fieldError.getDefaultMessage());
            result.put("msg",fieldError.getDefaultMessage());
        }
        result = service.update(deviceFault);
        //再判断是否更新成功
        System.out.println("update result = "+result);
        return result;
    }

    //批量删除(也可以单选)
    @RequestMapping("/delete_batch")
    @ResponseBody
    public HashMap deleteBatch(String ids) throws Exception{
        String[] deviceFaultIds = ids.split(",");
        result = service.deleteBatch(deviceFaultIds);
        //返回是否删除成功
        System.out.println("deleteBatch result = "+result);
        return result;
    }

    //二例搜索(和显示list很类似)
    @RequestMapping("/search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public EUDataGridResult searchDeviceFaultByDeviceFaultId(String searchValue, Integer page, Integer rows) {
        EUDataGridResult result = service.searchDeviceFaultByDeviceFaultId(page,rows,searchValue);
        return result;
    }

    @RequestMapping("/search_deviceFault_by_deviceName")
    @ResponseBody
    public EUDataGridResult searchDeviceFaultByDeviceName(String searchValue, Integer page, Integer rows) {
        EUDataGridResult result = service.searchDeviceFaultByDeviceName(page,rows,searchValue);
        return result;
    }

    //修改备注
    //更新
    @RequestMapping("/update_note")
    @ResponseBody
    public HashMap updateNote(@Valid DeviceFault deviceFault, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            result.put("status",fieldError.getDefaultMessage());
            result.put("msg",fieldError.getDefaultMessage());
        }
        result = service.updateNote(deviceFault);
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
        return "/deviceFault_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "/deviceFault_edit";
    }

}
